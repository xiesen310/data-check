package com.check.datacheck.kafka;

import com.check.datacheck.init.AppProperties;
import com.check.datacheck.utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author 谢森
 * @Description kafka 生产者
 * @className com.check.datacheck.kafka.Producer
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 11:33 星期五
 */
@Slf4j
@Component
public class CustomProducer {
    static String servers = "kafka-data1:9092,kafka-data2:9092,kafka-data2:9092";
    static int batchSize = 1;
    static CustomProducer producer;
    private static KafkaProducer<String, String> kafkaProducer;
    static String topic;
    static String errorTopic;

    @Autowired
    AppProperties appProperties;

    public CustomProducer() {
        initConfig();
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArraySerializer");

        /**
         * 这个参数控制着相同分区内数据发送的批次个数大小，也就是当数据达到 这个size 时，进行数据发送,
         * 但是并不是数据达不到 size 的值，就不会发送数据，默认是 1048576，即 16k
         */
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);

        // 当数据发送失败时，重试次数设置
        props.put(ProducerConfig.RETRIES_CONFIG, 5);

        /**
         * 消息是否发送，不是仅仅通过 batch.size 的值来控制的，实际上是一种权衡策略，即吞吐量和延时之间的权衡
         * linger.ms 参数就是控制消息发送延时行为的，默认是 0，表示消息需要被立即发送。
         */
        props.put(ProducerConfig.LINGER_MS_CONFIG, 100);

        /**
         * 控制消息发送的最大消息大小，默认是 10485760 字节 即 10Mb
         */
        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, 10485760);

        /**
         * 当 producer 发送消息到 broker 时，broker 需要在规定的时间内返回结果，这个时间就是该参数控制的，默认是 30s
         */
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 60000);

        /**
         * 指定了producer 端用于缓存的缓存区大小，单位是字节，默认是 33554432, 即 32G
         */
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        /**
         * 用户控制 生产者的持久性 acks 有3个值，
         *  0: 表示producer 完全不理睬 broker 的处理结果
         *  all： 表示发送数据时，broker 不仅会将消息写入到本地磁盘，同时也要保证其他副本也写入完成，才返回结果
         *  1: 表示发送数据时，broker 接收到消息写入到本地磁盘即可，无需保证其他副本是否写入成功
         */
        props.put(ProducerConfig.ACKS_CONFIG, "1");

        kafkaProducer = new KafkaProducer<String, String>(props);
    }

    /**
     * 初始化 kafka 集群配置
     */
    public void initConfig() {
        servers = ConfigUtils.getString(AppProperties.kafkaServers, "localhost:9092");
        errorTopic = ConfigUtils.getString(AppProperties.errorTopic, "error");
        System.out.println("kafka batch size: " + AppProperties.batchSize);
        batchSize = 1;
    }

    public static synchronized CustomProducer getInstance() {
        if (producer == null) {
            producer = new CustomProducer();
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
            log.error("sendErrorLog - 插入 kafka 失败", e);
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
            log.error("sendMsg - 插入 kafka 失败", e);
        }
    }

}
