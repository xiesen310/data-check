package com.check.datacheck.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.check.datacheck.model.Project;
import com.check.datacheck.model.dto.RespDto;

/**
 * @author 谢森
 * @Description 项目服务
 * @className com.check.datacheck.service.ProjectService
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 11:36 星期二
 */
public interface ProjectService extends IService<Project> {
    /**
     * 创建项目
     * @param project
     * @return
     */
    RespDto createProject(Project project);

    /**
     * 检查项目名是否存在
     * @param name
     * @return
     */
    Boolean checkNameIsExist(String name);

    /**
     * 根据项目名称查询
     * @param name 项目名称
     * @return
     */
    RespDto selectByName(String name);

    /**
     * 根据 ID 删除
     * @param id ID
     * @return
     */
    RespDto deleteById(Long id);
}
