package com.check.datacheck.controller;

import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "用户控制器", protocols = "http")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(
            value = "用户登录",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = RespDto.class
    )
    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    @ResponseBody
    public RespDto login(@ApiParam(value = "用户名", required = true) String username,
                         @ApiParam(value = "密码", required = true) String password) {
        RespDto respDto = userService.login(username, password);
        return respDto;
    }
}
