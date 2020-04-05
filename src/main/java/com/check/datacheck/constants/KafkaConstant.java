package com.check.datacheck.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 定义 kafka 相关常量
 * @className com.check.datacheck.constants.KafkaConstant
 * @Author 谢森
 * @Email xiesen@zork.com.cn
 * @Date 2020/4/5 22:30
 */
public class KafkaConstant {
    public static final Map<Integer, String> CODE_TABLE = new HashMap<>(1000);
    public final static int TOPIC_EXIST_ERR = 800100;
    public final static int SUCCESS = 0;
    public final static int FAIL = 1;

    static {
        CODE_TABLE.put(TOPIC_EXIST_ERR, "topic 已存在");
        CODE_TABLE.put(SUCCESS, "成功");
        CODE_TABLE.put(FAIL, "失败");
    }

    public static String getDescription(Integer code) {
        return CODE_TABLE.get(code);
    }

}
