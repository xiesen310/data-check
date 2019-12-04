package com.check.datacheck.constants;

/**
 * @author 谢森
 * @Description 数据集常量 错误码定义以 10200-10299
 * @className com.check.datacheck.constants.DataSetConstant
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/4 10:35 星期三
 */
public interface DataSetConstant {
    Integer DATASET_DELETE_FAIL = 10200;
    Integer DATASET_INSERT_FAIL = 10201;
    Integer DATASET_NAME_IS_EXIST = 10202;
    Integer DATASET_NAME_IS_NULL = 10103;

    Integer DATASET_ID_IS_NULL = 10104;
    Integer DATASET_ID_NOT_EXIST = 10105;
}
