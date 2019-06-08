package com.yuan.springbootweb.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yuan.springbootweb.entity.Status;
import lombok.Data;

/**
 * @author yuane
 * @date 2019/6/8 14:36
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AjaxResult {
    private Status status;
    private String message;
    private Object data;

    private AjaxResult(Status status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static AjaxResult getInstance(Status status, String message, Object data) {
        return new AjaxResult(status, message, data);
    }

    public static AjaxResult getInstance(Status status, String message) {
        return new AjaxResult(status, message, null);
    }

    public static AjaxResult getInstance(Status status, Object data) {
        return new AjaxResult(status, null, data);
    }
}
