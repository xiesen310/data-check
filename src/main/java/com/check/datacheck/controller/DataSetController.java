package com.check.datacheck.controller;

import com.check.datacheck.model.DataSet;
import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 谢森
 * @Description 数据集控制器
 * @className com.check.datacheck.controller.DataSetController
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/4 11:00 星期三
 */
@RestController
public class DataSetController {
    @Autowired
    private DataSetService dataSetService;

    @RequestMapping(value = "/dataset/create", method = RequestMethod.POST)
    @ResponseBody
    public RespDto createProject(@RequestBody DataSet dataSet) {
        return dataSetService.createDataSet(dataSet);
    }

    @RequestMapping(value = "/dataset/search", method = RequestMethod.GET)
    @ResponseBody
    public RespDto search(String name) {
        return dataSetService.selectByName(name);
    }

    @RequestMapping(value = "/dataset/delete", method = RequestMethod.GET)
    @ResponseBody
    public RespDto delete(@RequestParam(value = "id", required = true) Long id) {
        return dataSetService.deleteById(id);
    }

    @RequestMapping(value = "/dataset/view", method = RequestMethod.GET)
    @ResponseBody
    public RespDto view(@RequestParam(value = "id", required = true) Long id) {
        return dataSetService.selectById(id);
    }
}
