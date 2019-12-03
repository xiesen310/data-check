package com.check.datacheck.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 谢森
 * @Description 返回给请求方的响应通用结构DataTransferObject(DTO)
 * @className com.check.datacheck.model.dto.RespDto
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/2 18:09 星期一
 */
@Getter
@Setter
public class RespDto<T> {
    /**
     * 错误码
     */
    public int code;
    /**
     * 错误描述
     */
    public String message;

    /**
     * 此项当有值时才会返回
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}
