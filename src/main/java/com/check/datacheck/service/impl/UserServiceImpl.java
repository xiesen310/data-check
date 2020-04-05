package com.check.datacheck.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.check.datacheck.constants.UserConstant;
import com.check.datacheck.dao.UserMapper;
import com.check.datacheck.model.User;
import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.UserService;
import com.check.datacheck.utils.RespHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public RespDto login(String username, String password) {
        if (StrUtil.hasEmpty(username)) {
            return RespHelper.fail(UserConstant.USERNAME_IS_NULL, "用户名不能为空");
        } else {
            User user = userMapper.selectUserByName(username);
            if (password.equals(user.getPassword())) {
                return RespHelper.ok("success");
            } else {
                return RespHelper.fail(UserConstant.USERNAME_NOT_EXIST, "用户名不存在");
            }
        }
    }

    @Override
    public PageInfo<User> searchByPage(int pageNum, int pageSize) {
        // 1. 通过 pageHelper 的静态方法开始获取分页数据
        // 指定当前时第几页,以及每页显示的记录条数
        PageHelper.startPage(pageNum, pageSize);

        // 获得所有的商品记录
        List<User> list = list();

        // 获取当前分页对象
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
