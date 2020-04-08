package com.check.datacheck.init;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 谢森
 * @Description 测试应用配置
 * @className com.check.datacheck.init.AppPropertiesTest
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 13:31 星期五
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppPropertiesTest {

    @Autowired
    AppProperties appProperties;

    @Test
    public void test() {
    }

}
