package com.yuan.springbootwebmapper.commons.entity.dto;

import lombok.Data;

/**
 * @author yuane
 * @date 2019/6/21 20:59
 **/
@Data
public final class Result<T> {
    private String code;
    private String message;
    private T data;


    private Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private static <T> Result<T> of(String code, String message, T data) {
        return new Result<>(code, message, data);
    }
}
