package com.check.datacheck.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @className com.check.datacheck.utils.RedisUtil
 * @Author 谢森
 * @Email xiesen@zork.com.cn
 * @Date 2020/4/6 13:50
 */
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


}
