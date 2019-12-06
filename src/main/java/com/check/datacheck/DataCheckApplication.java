package com.check.datacheck;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 谢森
 */
@SpringBootApplication
@MapperScan({"com.check.datacheck.dao"})
//@PropertySource(value = {"classpath:kafka.properties"}, ignoreResourceNotFound = true)
public class DataCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCheckApplication.class, args);
    }

}
