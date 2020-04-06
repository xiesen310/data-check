package com.check.datacheck.init;

import com.check.datacheck.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description 数据同步
 * @className com.check.datacheck.init.DataSynchronous
 * @Author 谢森
 * @Email xiesen@zork.com.cn
 * @Date 2020/4/6 21:53
 */
@Component
@Slf4j
public class DataSynchronous {

    @Autowired
    private DataService dataService;

    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
        dataService.mysql2redis();
        log.info("将 mysql 中的数据同步到 redis 中");
    }
}
