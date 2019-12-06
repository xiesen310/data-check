package com.check.datacheck.service;

/**
 * @author 谢森
 * @Description 校验服务
 * @className com.check.datacheck.service.CheckService
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 10:49 星期五
 */
public interface CheckService {
    /**
     * 数据校验
     *
     * @param msg 原始消息,原始消息中有一个datasetId 字段,标记着数据的来源
     */
    void check(String msg);
}
