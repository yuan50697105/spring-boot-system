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
public final class AjaxResult implements Serializable {
    private String code;
    private String message;
    private Object data;

    private AjaxResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static AjaxResult of(String code, String message, Object data) {
        return new AjaxResult(code, message, data);
    }
}
