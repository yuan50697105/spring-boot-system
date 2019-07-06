package com.yuan.springbootweb.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * @author yuane
 * @date 2019/7/3 22:28
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AjaxResult {
    private String code;
    private String message;
    private Object data;

    public AjaxResult() {
    }

    @Builder
    public AjaxResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static AjaxResult getInstance(String code, String message, Object data) {
        return new AjaxResult(code, message, data);
    }

    public static AjaxResult getInstance() {
        return new AjaxResult();
    }

    public static AjaxResult data(String code, Object data) {
        return getInstance(code, null, data);
    }

    public static AjaxResult message(String code, String message) {
        return getInstance(code, message, null);
    }

}
