package com.check.datacheck.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.check.datacheck.init.AppProperties;
import com.check.datacheck.utils.ConfigUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

/**
 * @author 谢森
 * @Description kafka 生产者
 * @className com.check.datacheck.kafka.Producer
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 11:33 星期五
 */
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    static String servers = "kafka-data1:9092,kafka-data2:9092,kafka-data2:9092";
    static int batchSize = 1;
    static Producer producer;
    private static KafkaProducer<String, String> kafkaProducer;
    static String topic;
    static String errorTopic;

    @Autowired
    AppProperties appProperties;


    public Producer() {
        initConfig();
        Properties props = new Properties();
        props.put("bootstrap.servers", servers);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("batch.size", batchSize);
        kafkaProducer = new KafkaProducer<String, String>(props);
    }

    /**
     * 初始化 kafka 集群配置
     */
    public void initConfig() {
        servers = ConfigUtils.getString(appProperties.getKafkaServers(), "localhost:9092");
        errorTopic = ConfigUtils.getString(appProperties.getErrorTopic(), "error");
        batchSize = ConfigUtils.getInteger(appProperties.getBatchSize(), 1000);
    }

    public static synchronized Producer getInstance() {
        if (producer == null) {
            producer = new Producer();
        }
        return producer;
    }


    /**
     * 发送错误日志到 kafka
     *
     * @param logJson 错误日志 json 格式
     */
    public void sendErrorLog(String logJson) {
        try {
            sendMsg(errorTopic, logJson);
        } catch (Exception e) {
            logger.error("sendErrorLog - 插入 kafka 失败", e);
        }
    }

    /**
     * 发送数据到 kafka
     *
     * @param topic topic
     * @param msg   消息
     */
    public void sendMsg(String topic, String msg) {
        try {
            kafkaProducer.send(new ProducerRecord<String, String>(topic, null, msg));
        } catch (Exception e) {
            logger.error("sendMsg - 插入 kafka 失败", e);
        }
    }

}