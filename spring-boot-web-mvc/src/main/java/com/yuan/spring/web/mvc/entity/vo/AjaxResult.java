package com.yuan.spring.web.mvc.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AjaxResult implements Serializable {
    private String code;
    private String message;
    private Object data;

    private AjaxResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static AjaxResult build(String code, String message, Object data) {
        return new AjaxResult(code, message, data);
    }
}
