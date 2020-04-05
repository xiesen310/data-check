package com.check.datacheck.service;

import com.check.datacheck.model.DataSet;
import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.model.enums.DatasetTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 谢森
 * @Description 数据集服务测试
 * @className com.check.datacheck.service.DataSetServiceTest
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/4 10:47 星期三
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSetServiceTest {
    @Autowired
    private DataSetService dataSetService;

    @Test
    public void selectByName() {
        RespDto resp = dataSetService.selectByName("test2");
        System.out.println("data： " + resp.getData() + " ,code： " + resp.getCode() + " ,message: " + resp.getMessage());
    }

    @Test
    public void checkNameIsExist() {
        Boolean exist = dataSetService.checkNameIsExist("test2");
        System.out.println(exist);
    }

    @Test
    public void createDataSet() {

    }

    @Test
    public void deleteById() {
        RespDto resp = dataSetService.deleteById(1202038652042002433L);
        System.out.println("data： " + resp.getData() + " ,code： " + resp.getCode() + " ,message: " + resp.getMessage());
    }
}
