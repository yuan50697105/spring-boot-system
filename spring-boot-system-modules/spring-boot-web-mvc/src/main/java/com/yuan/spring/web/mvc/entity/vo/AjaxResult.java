package com.yuan.spring.web.mvc.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AjaxResult<T> implements Serializable {
    private String code;
    private String message;
    private T data;

    private AjaxResult(Status status, String message, T data) {
        this.code = status.code;
        this.message = message;
        this.data = data;
    }

    private AjaxResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> AjaxResult<T> build(String code, String message, T data) {
        return new AjaxResult<>(code, message, data);
    }

    public static <T> AjaxResult<T> build(Status status, String message, T data) {
        return new AjaxResult<>(status, message, data);
    }

    public static <T> AjaxResult<T> message(AjaxResult.Status status, String message) {
        return build(status, message, null);
    }

    public static <T> AjaxResult<T> ok(String message, T data) {
        return build(AjaxResult.Status.OK, message, data);
    }

    public static <T> AjaxResult<T> ok(String message) {
        return ok(message, null);
    }

    public static <T> AjaxResult<T> ok() {
        return ok("操作成功");
    }

    public static <T> AjaxResult<T> error(String message, T data) {
        return build(AjaxResult.Status.ERROR, message, data);
    }

    public static <T> AjaxResult<T> data(String message, T data) {
        return build(Status.DATA, message, data);
    }

    public static <T> AjaxResult<T> data(T data) {
        return data(null, data);
    }

    public static <T> AjaxResult<T> error(String message) {
        return error(message, null);
    }

    public Status getStatus() {
        return Status.valueOf(code);
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
