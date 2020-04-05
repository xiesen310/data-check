package com.check.datacheck.dao;

import com.check.datacheck.model.DataSet;
import com.check.datacheck.model.enums.DatasetTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 谢森
 * @Description 数据集接口测试类
 * @className com.check.datacheck.dao.DataSetMapperTest
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 15:23 星期二
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSetMapperTest {

    @Autowired
    private DataSetMapper dataSetMapper;

    @Test
    public void insert() {

    }
}
