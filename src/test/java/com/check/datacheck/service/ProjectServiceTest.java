package com.check.datacheck.service;

import com.check.datacheck.model.Project;
import com.check.datacheck.model.dto.RespDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 谢森
 * @Description 项目服务测试
 * @className com.check.datacheck.service.ProjectServiceTest
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 12:42 星期二
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {
    @Autowired
    private ProjectService projectService;

    @Test
    public void createProject() {
        Project project = new Project();
        project.setName("test1");
        project.setDescribeMessage("创建测试项目1");
        RespDto resp = projectService.createProject(project);

        System.out.println("data： " + resp.getData() + " ,code： " + resp.getCode() + " ,message: " + resp.getMessage());
    }

    @Test
    public void checkNameIsExist() {
        Boolean nameIsExist = projectService.checkNameIsExist("test");
        System.out.println(nameIsExist);
    }

    @Test
    public void selectByName() {
        String name = "test";
        RespDto resp = projectService.selectByName(name);
        System.out.println(resp.getData());
    }

    @Test
    public void deleteById() {
        RespDto resp = projectService.deleteById(1201745119720550402L);
        System.out.println("data： " + resp.getData() + " ,code： " + resp.getCode() + " ,message: " + resp.getMessage());
    }

    @Test
    public void checkButton() {
        RespDto resp = projectService.checkButton(1201706102832623618L);
        System.out.println("data： " + resp.getData() + " ,code： " + resp.getCode() + " ,message: " + resp.getMessage());
    }
}
