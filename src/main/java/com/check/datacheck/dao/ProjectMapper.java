package com.check.datacheck.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.check.datacheck.model.Project;

/**
 * @author 谢森
 * @Description 项目映射接口
 * @className com.check.datacheck.dao.ProjectMapper
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 10:34 星期二
 */
public interface ProjectMapper extends BaseMapper<Project> {
    /**
     * 根据项目名称进行查询
     * @param name
     * @return
     */
    Project selectProjectByName(String name);
}
