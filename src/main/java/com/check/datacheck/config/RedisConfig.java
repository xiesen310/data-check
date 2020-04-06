package com.check.datacheck.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @Description RedisConfig
 * @className com.check.datacheck.config.RedisConfig
 * @Author 谢森
 * @Email xiesen@zork.com.cn
 * @Date 2020/4/6 13:47
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
}
