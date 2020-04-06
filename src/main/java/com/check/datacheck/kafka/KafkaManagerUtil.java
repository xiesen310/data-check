package com.check.datacheck.kafka;

import com.check.datacheck.init.AppProperties;
import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.admin.TopicCommand;
import kafka.server.ConfigType;
import kafka.utils.ZkUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.security.JaasUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import scala.collection.JavaConversions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * @author 谢森
 * @Description kafka 管理工具
 * @className com.check.datacheck.kafka.KafkaManagerUtil
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 16:14 星期五
 */
@Component
@Slf4j
public class KafkaManagerUtil {
    private static final String brokerUrl = "s103:9092";
    private static String zkStr = "s103:2181/kafka111";

    @Autowired
    private AppProperties appProperties;

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
    public String createKafkaTopic(String topicName, int partition, int replication) {
        try {
            System.out.println(appProperties.getZookeeperUrl());
            ZkUtils zkUtils = ZkUtils.
                    apply(appProperties.getZookeeperUrl().toString(), 30000, 30000, JaasUtils.isZkSecurityEnabled());

            boolean b = AdminUtils.topicExists(zkUtils, topicName);
            if (!b) {
                AdminUtils.createTopic(zkUtils, topicName, partition,
                        replication, new Properties(), new RackAwareMode.Enforced$());
                boolean flag = AdminUtils.topicExists(zkUtils, topicName);
                zkUtils.close();
                return flag ? "success" : "fail";
            } else {
                log.error(" [{}]已存在", topicName);
                return "fail";
            }
        } catch (Exception e) {
            log.error("创建 [" + topicName + "] 失败");
            return "fail";
        }

    }

    /**
     * 列举所有 topic
     */
    public static List<String> listTopics() {
        ZkUtils zkUtils = ZkUtils.apply(zkStr, 30000, 30000, JaasUtils.isZkSecurityEnabled());
        List<String> topics = JavaConversions.seqAsJavaList(zkUtils.getAllTopics());
        topics.forEach(System.out::println);
        return topics;
    }

    /**
     * 删除指定 topic
     *
     * @param topicName 主题名称
     */
    public String deleteTopic(String topicName) {
        ZkUtils zkUtils = null;
        try {
            zkUtils = ZkUtils.
                    apply(zkStr, 30000, 30000, JaasUtils.isZkSecurityEnabled());
            boolean b = AdminUtils.topicExists(zkUtils, topicName);
            if (b) {
                AdminUtils.deleteTopic(zkUtils, topicName);
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                boolean flag = AdminUtils.topicExists(zkUtils, topicName);
                return !flag ? "success" : "fail";
            } else {
                log.info("[" + topicName + "] 不存在");
                return "fail";
            }

        } finally {
            if (null != zkUtils) {
                zkUtils.close();
            }
        }

    }

    /**
     * 判断 topic 是否存在
     *
     * @param topicName topic
     * @return
     */
    public static boolean topicExists(String topicName) {
        ZkUtils zkUtils = null;
        try {
            zkUtils = ZkUtils.
                    apply(zkStr, 30000, 30000, JaasUtils.isZkSecurityEnabled());

            boolean exists = AdminUtils.topicExists(zkUtils, topicName);
            return exists;
        } finally {
            if (null != zkUtils) {
                zkUtils.close();
            }
        }
    }


}
