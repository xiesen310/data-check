package com.check.datacheck.controller;

import com.check.datacheck.model.User;
import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.UserService;
import com.check.datacheck.utils.RespHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public RespDto login(@ApiParam(value = "用户名", required = true) String username,
                         @ApiParam(value = "密码", required = true) String password) {
        RespDto respDto = userService.login(username, password);
        return respDto;
    }

    @ApiOperation(
            value = "添加用户",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = RespDto.class
    )
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    @ResponseBody
    public RespDto addUser(@ApiParam(value = "用户对象", required = true) @RequestBody User user) {
        return userService.save(user) ? RespHelper.ok(user, "添加用户成功") : RespHelper.fail(1, "添加用户失败");
    }
}
