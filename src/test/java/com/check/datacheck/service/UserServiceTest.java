package com.check.datacheck.service;

import com.check.datacheck.model.dto.RespDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 谢森
 * @Description 用户服务测试
 * @className com.check.datacheck.service.UserServiceTest
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 9:42 星期二
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void login() {
        RespDto resp = userService.login("", "");
        System.out.println("data： " + resp.getData() + " ,code： " + resp.getCode() + " ,message: " + resp.getMessage());
    }
}
