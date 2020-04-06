package com.check.datacheck.kafka;

import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import scala.collection.Map;

import java.util.Properties;

/**
 * @Description
 * @className com.check.datacheck.kafka.KafkaManagerUtilTest
 * @Author 谢森
 * @Email xiesen@zork.com.cn
 * @Date 2020/4/5 21:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaManagerUtilTest {

    @Autowired
    private KafkaManagerUtil kafkaManagerUtil;

    @Test
    public void createTopic() {
        String result = kafkaManagerUtil.createKafkaTopic("test2", 1, 1);
        System.out.println(result);
    }

    @Test
    public void listTopics() {
        KafkaManagerUtil.listTopics();
    }


    @Test
    public void test() {
        String ZkStr = "s103:2181/kafka111";
        String topic = "test1";
        int partition = 1;
        int replication = 1;
        ZkUtils zkUtils = ZkUtils.
                apply(ZkStr, 30000, 30000, JaasUtils.isZkSecurityEnabled());

        AdminUtils.createTopic(zkUtils, topic, partition,
                replication, new Properties(), new RackAwareMode.Enforced$());

        zkUtils.close();
    }

    @Test
    public void fetchEntityConfig() {
        String ZkStr = "s103:2181/kafka111";
        String topic = "test1";
        int partition = 1;
        int replication = 1;
        ZkUtils zkUtils = ZkUtils.
                apply(ZkStr, 30000, 30000, JaasUtils.isZkSecurityEnabled());

        Map<String, Properties> map = AdminUtils.fetchAllTopicConfigs(zkUtils);
        System.out.println(map);

    }

    @Test
    public void deleteTopic() {
        String aa = kafkaManagerUtil.deleteTopic("aa");
        System.out.println(aa);
    }

}
