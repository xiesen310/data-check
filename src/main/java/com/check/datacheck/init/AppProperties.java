package com.check.datacheck.init;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author 谢森
 * @Description 应用配置
 * @className com.check.datacheck.init.AppProperties
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 13:25 星期五
 */
@Configuration
@Getter
public class AppProperties {

    @Value("${check.kafka.servers}")
    private String kafkaServers;

    @Value("${check.kafka.error-topic}")
    private String errorTopic;

    @Value("${check.kafka.batchSize}")
    private Integer batchSize;
}
