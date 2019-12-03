package com.check.datacheck.dao;

import com.check.datacheck.model.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 谢森
 * @Description 项目对象测试
 * @className com.check.datacheck.dao.ProjectMapperTest
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 11:26 星期二
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectMapperTest {
    @Autowired
    private ProjectMapper projectMapper;

    @Test
    public void insert(){
        Project project = new Project();
        project.setName("test");
        project.setDescribeMessage("这是一个测试项目");

        int rows = projectMapper.insert(project);
        System.out.println("影响记录数: " + rows);
    }

    @Test
    public void selectById(){
        Project project = projectMapper.selectById(1201706102832623618L);
        System.out.println(project);
    }

    @Test
    public void selectProjectByName(){
        Project project = projectMapper.selectProjectByName("test");
        System.out.println(project);
    }
}
