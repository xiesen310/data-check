package com.check.datacheck.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.check.datacheck.constants.UserConstant;
import com.check.datacheck.dao.UserMapper;
import com.check.datacheck.model.User;
import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.UserService;
import com.check.datacheck.utils.RespHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 谢森
 * @Description UserServiceImpl
 * @className com.check.datacheck.service.impl.UserServiceImpl
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/2 17:54 星期一
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public RespDto login(String username) {
        if(StrUtil.hasEmpty(username)){
            return RespHelper.fail(UserConstant.USERNAME_IS_NULL,"用户名不能为空");
        }else {
            User user = userMapper.selectUserByName(username);
            if(!ObjectUtil.hasEmpty(user)){
                return RespHelper.ok(user);
            }else {
                return RespHelper.fail(UserConstant.USERNAME_NOT_EXIST,"用户名不存在");
            }
        }
    }
}
