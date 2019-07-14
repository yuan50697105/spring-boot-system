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

    private AjaxResult(Status status, String message, Object data) {
        this.code = status.code;
        this.message = message;
        this.data = data;
    }

    private AjaxResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static AjaxResult build(String code, String message, Object data) {
        return new AjaxResult(code, message, data);
    }

    public static AjaxResult build(Status status, String message, Object data) {
        return new AjaxResult(status, message, data);
    }

    public static AjaxResult message(AjaxResult.Status status, String message) {
        return build(status, message, null);
    }

    public static AjaxResult ok(String message, Object data) {
        return build(AjaxResult.Status.OK, message, data);
    }


    public static AjaxResult ok(String message) {
        return ok(message, null);
    }

    public static AjaxResult ok() {
        return ok("操作成功");
    }

    public static AjaxResult error(String message, Object data) {
        return build(AjaxResult.Status.ERROR, message, data);
    }

    public static AjaxResult data(String message, Object data) {
        return build(Status.DATA, message, data);
    }

    public static AjaxResult data(Object data) {
        return data(null, data);
    }


    public static AjaxResult error(String message) {
        return error(message, null);
    }

    public enum Status {
        OK("ok"), ERROR("error"), WARN("warn"), DATA("data"), MESSAGE("build");
        private String code;

        Status(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
