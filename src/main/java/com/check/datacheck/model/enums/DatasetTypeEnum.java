package com.check.datacheck.model.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

/**
 * @author 谢森
 * @Description 数据集类型枚举
 * @className com.check.datacheck.model.DatasetTypeEnum
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/3 15:01 星期二
 */

public enum DatasetTypeEnum implements IEnum<Integer> {
    /**
     * 日志
     */
    LOG(0, "log"),
    /**
     * 指标
     */
    METRIC(1, "metric");

    private int index;
    private String name;

    DatasetTypeEnum(int index, String name) {
        this.name = name;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return this.index;
    }
}
