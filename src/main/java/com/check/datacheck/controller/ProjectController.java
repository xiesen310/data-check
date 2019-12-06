package com.check.datacheck.controller;

import com.check.datacheck.model.Project;
import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 谢森
 * @Description 项目控制器
 * @className com.check.datacheck.controller.ProjectController
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 13:40 星期二
 */
@Api(value = "项目控制器", protocols = "http")
@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @ApiOperation(
            value = "创建项目",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = RespDto.class
    )
    @RequestMapping(value = "/project/create", method = RequestMethod.POST)
    @ResponseBody
    public RespDto createProject(@ApiParam(value = "项目对象", required = true)
                                 @RequestBody Project project) {
        return projectService.createProject(project);
    }

    @ApiOperation(
            value = "查询项目",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = RespDto.class
    )
    @RequestMapping(value = "/project/search", method = RequestMethod.GET)
    @ResponseBody
    public RespDto search(@ApiParam(value = "项目名称", required = false) String name) {
        return projectService.selectByName(name);
    }

    @ApiOperation(
            value = "删除项目",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = RespDto.class
    )
    @RequestMapping(value = "/project/delete", method = RequestMethod.GET)
    @ResponseBody
    public RespDto delete(@ApiParam(value = "ID", required = true)
                          @RequestParam(value = "id", required = true) Long id) {
        return projectService.deleteById(id);
    }

    @ApiOperation(
            value = "查看项目详情",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = RespDto.class
    )
    @RequestMapping(value = "/project/view", method = RequestMethod.GET)
    @ResponseBody
    public RespDto view(@ApiParam(value = "项目 ID ", required = true)
                        @RequestParam(value = "id", required = true) Long id) {
        return projectService.checkButton(id);
    }
}
