package com.check.datacheck.service;


import com.check.datacheck.model.dto.DataDto;

/**
 * @Description 数据服务
 * @className com.check.datacheck.service.DataService
 * @Author 谢森
 * @Email xiesen@zork.com.cn
 * @Date 2020/4/6 13:38
 */
public interface DataService {
    boolean putData(DataDto dataDto);

    /**
     * 将 mysql 中的日志集同步到 redis 中
     */
    void mysql2redis();
}
