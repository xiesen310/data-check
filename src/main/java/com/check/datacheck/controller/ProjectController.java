package com.check.datacheck.controller;

import com.check.datacheck.model.Project;
import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 谢森
 * @Description 项目控制器
 * @className com.check.datacheck.controller.ProjectController
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 13:40 星期二
 */
@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/project/create", method = RequestMethod.POST)
    @ResponseBody
    public RespDto createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @RequestMapping(value = "/project/search", method = RequestMethod.GET)
    @ResponseBody
    public RespDto search(String name) {
        return projectService.selectByName(name);
    }

    @RequestMapping(value = "/project/delete", method = RequestMethod.GET)
    @ResponseBody
    public RespDto delete(@RequestParam(value = "id", required = true) Long id) {
        return projectService.deleteById(id);
    }
}
