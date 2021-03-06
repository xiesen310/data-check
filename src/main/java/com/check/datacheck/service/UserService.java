package com.check.datacheck.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.check.datacheck.model.User;
import com.check.datacheck.model.dto.RespDto;
import com.github.pagehelper.PageInfo;

/**
 * @author 谢森
 * @Description 用户服务接口
 * @className com.check.datacheck.service.UserService
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/2 17:52 星期一
 */
public interface UserService extends IService<User> {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    RespDto login(String username, String password);

    /**
     * 分页查询
     *
     * @param pageNum  当前是第几页
     * @param pageSize 当前页一共几条记录
     * @return {@link PageInfo}
     */
    PageInfo<User> searchByPage(int pageNum, int pageSize);

}
