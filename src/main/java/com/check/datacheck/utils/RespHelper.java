package com.check.datacheck.utils;

import com.check.datacheck.model.dto.RespDto;

/**
 * @author 谢森
 * @Description 响应工具类
 * @className com.check.datacheck.utils.RespHelper
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/2 18:10 星期一
 */
public class RespHelper {
    public static <T> RespDto<T> createEmptyRespDto() {
        return new RespDto<>();
    }

    public static <T> RespDto<T> fail(int code) {
        RespDto<T> t = createEmptyRespDto();
        t.setCode(code);
        t.setMessage(null);
        return t;
    }

    public static <T> RespDto<T> fail(int code, String message) {
        RespDto<T> t = createEmptyRespDto();
        t.setCode(code);
        t.setMessage(message);
        return t;
    }

    public static <T> RespDto<T> fail(int code, T data, String message) {
        RespDto<T> t = createEmptyRespDto();
        t.setCode(code);
        t.setData(data);
        t.setMessage(message);
        return t;
    }

    public static <T> RespDto<T> ok(T data) {
        RespDto<T> t = createEmptyRespDto();
        t.setCode(0);
        t.setData(data);
        return t;
    }

    public static <T> RespDto<T> ok(T data, String message) {
        RespDto<T> t = createEmptyRespDto();
        t.setCode(0);
        t.setData(data);
        t.setMessage(message);
        return t;
    }
}
