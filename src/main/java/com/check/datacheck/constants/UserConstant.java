package com.check.datacheck.constants;

/**
 * @author 谢森
 * @Description 用户常量 错误码定义以 10000-10099
 * @className com.check.datacheck.constants.UserConstant
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 9:46 星期二
 */
public interface UserConstant {
    /**
     * 用户名不能为空
     */
    Integer USERNAME_IS_NULL = 10000;

    /**
     * 用户名不存在
     */
    Integer USERNAME_NOT_EXIST = 10001;
}
