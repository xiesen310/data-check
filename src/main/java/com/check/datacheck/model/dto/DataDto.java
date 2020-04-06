package com.check.datacheck.model.dto;

import lombok.Data;

/**
 * @Description 数据格式
 * @className com.check.datacheck.model.dto.DataDto
 * @Author 谢森
 * @Email xiesen@zork.com.cn
 * @Date 2020/4/6 13:39
 */
@Data
public class DataDto {
    /**
     * 数据
     */
    private String msg;

    /**
     * schema id
     */
    private Long id;
}
