package com.check.datacheck.kafka;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

/**
 * @author 谢森
 * @Description kafka 管理工具
 * @className com.check.datacheck.kafka.KafkaManagerUtil
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 16:14 星期五
 */
public class KafkaManagerUtil {
    private static final String brokerUrl = "localhost:9092";

    /**
     * 获取 kafka Admin
     *
     * @return AdminClient
     */
    private static AdminClient getAdminClient() {
        Properties prop = new Properties();
        prop.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        AdminClient client = AdminClient.create(prop);
        return client;
    }

    /**
     * 创建 topic
     *
     * @param topicName   主题名称
     * @param partition   分区数量
     * @param replication 备份数
     */
    public static void createKafkaTopic(String topicName, int partition, int replication) {
        NewTopic newTopic = new NewTopic(topicName, partition, (short) replication);
        Collection<NewTopic> newTopicList = new ArrayList<>();
        newTopicList.add(newTopic);
        getAdminClient().createTopics(newTopicList);
    }

    /**
     * 列举所有 topic
     */
    public static void listTopics() {
        ListTopicsResult listTopicsResult = getAdminClient().listTopics();
        System.out.println(listTopicsResult);
    }

    /**
     * 删除指定 topic
     *
     * @param topicName 主题名称
     */
    public static void deleteTopic(String topicName) {
        Collection<String> topics = new ArrayList<>();
        topics.add(topicName);
        getAdminClient().deleteTopics(topics);

    }

    /**
     * 获取 topic 的描述信息
     *
     * @param topicName 主题名称
     */
    public static void describeTopics(String topicName) {
        Collection<String> topics = new ArrayList<>();
        topics.add(topicName);
        getAdminClient().describeTopics(topics);
    }

}
