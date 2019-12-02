package com.check.datacheck.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.check.datacheck.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 谢森
 * @Description 用户对象测试类
 * @className com.check.datacheck.dao.UserMapperTest
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/2 17:00 星期一
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setAge(20);
        user.setEmail("admin@163.com");

        int rows = userMapper.insert(user);
        System.out.println("影响记录数: " + rows);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1201429830827032578L);
        user.setAge(21);
        int rows = userMapper.updateById(user);
        System.out.println("影响记录数: " + rows);
    }

    @Test
    public void searchAll() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> users = userMapper.selectAll(queryWrapper);
        users.forEach(System.out::println);
    }
}
