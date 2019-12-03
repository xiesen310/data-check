package com.check.datacheck.controller;

import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谢森
 * @Description 用户控制类
 * @className com.check.datacheck.controller.UserController
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/2 17:51 星期一
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    @ResponseBody
    public RespDto login(String username) {
        RespDto respDto = userService.login(username);
        return respDto;
    }
}
