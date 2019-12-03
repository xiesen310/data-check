package com.check.datacheck.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.check.datacheck.constants.ProjectConstant;
import com.check.datacheck.dao.ProjectMapper;
import com.check.datacheck.model.Project;
import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.ProjectService;
import com.check.datacheck.utils.RespHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 谢森
 * @Description 项目服务实现类
 * @className com.check.datacheck.service.impl.ProjectServiceImpl
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 11:36 星期二
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public RespDto createProject(Project project) {
        if (ObjectUtil.isNotNull(project.getName())) {
            // 判断项目名称是否存在
            Boolean isExist = checkNameIsExist(project.getName());
            if (!isExist) {
                int rows = projectMapper.insert(project);
                if (rows > 0) {
                    return RespHelper.ok(rows, "创建项目成功");
                } else {
                    return RespHelper.fail(ProjectConstant.PROJECT_INSERT_FAIL, "Project 数据插入失败");
                }
            } else {
                return RespHelper.fail(ProjectConstant.PROJECT_NAME_IS_EXIST, "项目名称已存在");
            }

        }
        return RespHelper.fail(ProjectConstant.PROJECT_NAME_IS_NULL, "项目名称不能为空");
    }

    @Override
    public Boolean checkNameIsExist(String name) {
        Project project = projectMapper.selectProjectByName(name);
        if (null == project) {
            return false;
        }
        return true;
    }

    @Override
    public RespDto selectByName(String name) {
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(name)) {
            Project project = new Project();
            project.setName(name);
            queryWrapper.setEntity(project);
        }

        List<Project> projectList = projectMapper.selectList(queryWrapper);
        return RespHelper.ok(projectList);
    }

    @Override
    public RespDto deleteById(Long id) {
        int rows = projectMapper.deleteById(id);
        if (rows >= 1) {
            return RespHelper.ok(rows, "删除 id 为 " + id + " 项目成功");
        }
        return RespHelper.fail(ProjectConstant.PROJECT_DELETE_FAIL, "项目删除失败");
    }
}
