package com.check.datacheck.service.impl;

import com.check.datacheck.constants.Constant;
import com.check.datacheck.dao.DataSetMapper;
import com.check.datacheck.kafka.CustomProducer;
import com.check.datacheck.kafka.ProducerPool;
import com.check.datacheck.kafka.json.JsonSchema;
import com.check.datacheck.model.DataSet;
import com.check.datacheck.model.dto.DataDto;
import com.check.datacheck.service.DataService;
import com.check.datacheck.service.DataSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @className com.check.datacheck.service.impl.DataServiceImpl
 * @Author 谢森
 * @Email xiesen@zork.com.cn
 * @Date 2020/4/6 13:41
 */
@Service
@Slf4j
public class DataServiceImpl implements DataService {
    private CustomProducer producer = ProducerPool.getInstance().getProducer();

    @Autowired
    private DataSetMapper dataSetMapper;

    @Autowired
    private DataSetService dataSetService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean putData(DataDto dataDto) {
        if (null != dataDto) {
            Long id = dataDto.getId();
            String msg = dataDto.getMsg();
            // 根据 id 获取 schema 进行数据校验
            String res = selectDataSetById(id);
            String[] split = res.split("\\|");
            String topic = split[0];
            String schema = split[1];

            boolean flag = JsonSchema.check(schema, msg);
            if (flag) {
                producer.sendMsg(topic, msg);
                return true;
            } else {
                log.error("数据与 schema 不一致");
                return false;
            }
        }
        return false;
    }


    /**
     * 保存数据到 redis 中
     *
     * @param key
     * @param value
     */
    private void saveRedis(String key, String value) {
        String values = searchRedis(key);
        if (null == values) {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    /**
     * 查询 redis
     *
     * @param key
     * @return
     */
    private String searchRedis(String key) {
        String values = redisTemplate.opsForValue().get(key);
        return values;
    }

    /**
     * 1. 根据 id 去 redis 查询
     * 2. 如果在 redis 中查询到数据,直接返回
     * 3. 如果在 redis 中没有查询到数据，则去数据库中查询，并将查询到的数据保存到 redis 中
     */
    private String selectDataSetById(Long id) {
        if (null != id) {
            String key = Constant.CHECK_PREFIX + id;
            String value = searchRedis(key);
            if (null != value) {
                return value;
            } else {
                DataSet dataSet = dataSetMapper.selectById(id);
                String topic = dataSet.getTopic();
                if (null != dataSet) {
                    String jsonSchema = dataSet.getJsonSchema();
                    saveRedis(Constant.CHECK_PREFIX + dataSet.getId(), topic + "|" + jsonSchema);
                    return jsonSchema;
                }
            }
        }
        return null;
    }

    /**
     * 将 mysql 中的日志集数据同步到 redis 中
     * 1. 从 mysql 中获取全量的 日志结构数据，然后将数据写入到 redis 中
     */
    @Override
    public void mysql2redis() {
        List<DataSet> list = dataSetService.list();
        if (null != list) {
            for (DataSet dataSet : list) {
                Long id = dataSet.getId();
                String key = Constant.CHECK_PREFIX + id;
                String value = searchRedis(key);
                if (null == value) {
                    saveRedis(key, dataSet.getTopic() + "|" + dataSet.getJsonSchema());
                }
            }
        }
    }

}
