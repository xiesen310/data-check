package com.check.datacheck.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.check.datacheck.model.DataSet;

/**
 * @author 谢森
 * @Description 数据集映射接口
 * @className com.check.datacheck.dao.DataSetMapper
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 15:22 星期二
 */
public interface DataSetMapper extends BaseMapper<DataSet> {
    /**
     * 根据数据集名称查询
     * @param name 数据集名称
     * @return
     */
    DataSet selectByName(String name);
}
