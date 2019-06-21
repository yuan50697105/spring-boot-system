package com.yuan.springbootwebmapper.commons.entity.vo;

import lombok.Data;

/**
 * @author yuane
 * @date 2019/6/21 20:58
 **/
@Data
public final class AjaxResult<T> {
    private String code;
    private String message;
    private T data;

    private AjaxResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> AjaxResult<T> of(String code, String message, T data) {
        return new AjaxResult<>(code, message, data);
    }

}
