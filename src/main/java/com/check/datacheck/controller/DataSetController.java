package com.check.datacheck.controller;

import com.check.datacheck.model.DataSet;
import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.DataSetService;
import com.check.datacheck.utils.RespHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 谢森
 * @Description 数据集控制器
 * @className com.check.datacheck.controller.DataSetController
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/4 11:00 星期三
 */
@Api(value = "数据集控制器", protocols = "http")
@RestController
public class DataSetController {
    @Autowired
    private DataSetService dataSetService;

    @ApiOperation(
            value = "创建数据集",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = RespDto.class
    )
    @RequestMapping(value = "/dataset/add", method = RequestMethod.POST)
    @ResponseBody
    public RespDto add(@ApiParam(value = "数据集对象", required = true) @Valid @RequestBody DataSet dataSet) {
        return dataSetService.createDataSet(dataSet);
    }

    @ApiOperation(
            value = "分页查询数据集",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = RespDto.class
    )
    @RequestMapping(value = "/dataset", method = RequestMethod.GET)
    @ResponseBody
    public RespDto search(@ApiParam(value = "起始页", required = true) int pageNum,
                          @ApiParam(value = "一页显示多少数据", required = true) int pageSize) {
        return RespHelper.ok(dataSetService.searchByPage(pageNum, pageSize));
    }

    @ApiOperation(
            value = "删除数据集",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = RespDto.class
    )
    @RequestMapping(value = "/dataset/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RespDto delete(@ApiParam(value = "数据集 ID", required = true) @PathVariable Long id) {
        return dataSetService.deleteById(id);
    }

    @ApiOperation(
            value = "查看数据集",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = RespDto.class
    )
    @RequestMapping(value = "/dataset/view", method = RequestMethod.GET)
    @ResponseBody
    public RespDto view(@ApiParam(value = "数据集 ID", required = true)
                        @RequestParam(value = "id", required = true) Long id) {
        return dataSetService.selectById(id);
    }
}
