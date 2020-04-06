package com.check.datacheck.controller;

import com.check.datacheck.model.dto.DataDto;
import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.DataService;
import com.check.datacheck.utils.RespHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description 对外提供的数据接口
 * @className com.check.datacheck.controller.DataController
 * @Author 谢森
 * @Email xiesen@zork.com.cn
 * @Date 2020/4/6 13:36
 */
@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/putData", method = RequestMethod.POST)
    public RespDto putData(@RequestBody DataDto dataDto) {
        return dataService.putData(dataDto) ? RespHelper.ok(dataDto) : RespHelper.fail(1, "写入数据失败");
    }
}
