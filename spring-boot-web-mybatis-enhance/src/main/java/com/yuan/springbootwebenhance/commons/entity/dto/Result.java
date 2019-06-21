package com.yuan.springbootwebenhance.commons.entity.dto;

import lombok.Data;

/**
 * @author yuane
 * @date 2019/6/21 20:48
 **/
@Data
public final class Result {
    private String code;
    private String message;
    private Object data;

    private Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result of(String code, String message, Object data) {
        return new Result(code, message, data);
    }
}
