package com.check.datacheck.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.check.datacheck.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 谢森
 * @Description 用户映射接口
 * @className com.check.datacheck.dao.UserMapper
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/2 16:57 星期一
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * @param wrapper Wrapper<User>
     * @return List<User>
     */
    List<User> selectAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    /**
     * 根据用户名查询
     *
     * @param username 用户名
     * @return User 对象
     */
    User selectUserByName(@Param("username") String username);
}
