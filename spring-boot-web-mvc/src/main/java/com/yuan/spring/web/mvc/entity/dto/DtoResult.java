package com.yuan.spring.web.mvc.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoResult implements Serializable {
    private String code;
    private String message;
    private Object data;

    @Builder
    public DtoResult(Status status, String message, Object data) {
        this.code = status.code;
        this.message = message;
        this.data = data;
    }

    public static DtoResult build(Status status, String message, Object data) {
        return new DtoResult(status, message, data);
    }

    public static DtoResult message(Status status, String message) {
        return build(status, message, null);
    }

    public static DtoResult ok(String message, Object data) {
        return build(Status.OK, message, data);
    }

    public static DtoResult ok(String message) {
        return ok(message, null);
    }

    public static DtoResult error(String message, Object data) {
        return build(Status.ERROR, message, data);
    }

    public static DtoResult error(String message) {
        return error(message, null);
    }

    public AjaxResult convert() {
        return AjaxResult.build(code, message, data);
    }


    public enum Status {
        OK("ok"), ERROR("error"), WARN("warn"), DATA("data"), MESSAGE("message");
        private String code;

        Status(String code) {
            this.code = code;
        }
    }
}
