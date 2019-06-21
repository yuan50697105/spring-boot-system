package com.yuan.springbootwebmybatisplus.commons.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/20 22:52
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class AjaxResult<T> implements Serializable {
    private String code;
    private String message;
    private T data;

    private AjaxResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    public static <T> AjaxResult of(String code, String message, T data) {
        return new AjaxResult(code, message, data);
    }
}
