package com.check.datacheck.constants;

/**
 * @author 谢森
 * @Description 项目常量 错误码定义以 10100-10199
 * @className com.check.datacheck.constants.ProjectConstant
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 12:36 星期二
 */
public interface ProjectConstant {
    /**
     * 项目数据插入失败
     */
    Integer PROJECT_INSERT_FAIL = 10100;

    /**
     * 项目对象数据为空
     */
    Integer PROJECT_NAME_IS_NULL = 10101;

    /**
     * 项目名称已存在
     */
    Integer PROJECT_NAME_IS_EXIST = 10102;
    Integer PROJECT_DELETE_FAIL = 10103;

}
