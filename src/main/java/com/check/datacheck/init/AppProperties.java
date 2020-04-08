package com.check.datacheck.init;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 谢森
 * @Description 应用配置
 * @className com.check.datacheck.init.AppProperties
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 13:25 星期五
 */
@Getter
@Component
public class AppProperties {
    public static String kafkaServers;

    public static String errorTopic;

    public static String batchSize;

    @Value("${check.kafka.zkUrl}")
    private String zookeeperUrl;

    @Value("${check.kafka.servers:localhost:9092}")
    public void setKafkaServers(String kafkaServers) {
        this.kafkaServers = kafkaServers;
    }

    @Value("${check.kafka.error-topic:error}")
    public void setErrorTopic(String errorTopic) {
        this.errorTopic = errorTopic;
    }

    @Value("${check.kafka.batch-size}")
    public static void setBatchSize(String batchSize) {
        AppProperties.batchSize = batchSize;
    }
}
