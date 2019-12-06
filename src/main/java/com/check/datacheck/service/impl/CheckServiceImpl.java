package com.check.datacheck.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.check.datacheck.constants.Constant;
import com.check.datacheck.kafka.ProducerPool;
import com.check.datacheck.model.DataSet;
import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.CheckService;
import com.check.datacheck.service.DataSetService;
import com.check.datacheck.utils.JsonValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 谢森
 * @Description 校验业务逻辑
 * @className com.check.datacheck.service.impl.CheckServiceImpl
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 11:10 星期五
 */
public class CheckServiceImpl implements CheckService {
    private static final Logger logger = LoggerFactory.getLogger(CheckServiceImpl.class);
    @Autowired
    private DataSetService dataSetService;

    @Override
    public void check(String msg) {
        // 获取数据,解析 datasetId
        JSONObject jsonObject = JSON.parseObject(msg);
        Long datasetId = jsonObject.getLong("datasetId");

        // 根据 datasetId 先从缓存中拿数据(schema),如果缓存中无数据，请求数据库，将数据放入缓存，然后返回
        RespDto respDto = dataSetService.selectById(datasetId);
        DataSet dataSet = (DataSet) respDto.getData();
        String jsonSchema = dataSet.getSchemaJson();
        String topic = dataSet.getName();

        // 如果原始的数据的数据结构和 schema 相同,将数据发送到对应的 topic 中, 这里 topic 就是数据集名称
        RespDto resp = JsonValidateUtil.validate(jsonSchema, msg);
        if (Constant.SUCCESS_STATUS_STR.equals(resp.getData())) {
            ProducerPool.getInstance().getProducer().sendMsg(topic, msg);
        } else {
            // 如果失败,打印日志并且将数据发送到错误的 topic 中
            logger.error("校验失败: {}", resp);
        }

    }
}
