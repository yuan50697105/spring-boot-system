package com.yuan.springbootwebjpa.commons.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yuan.springbootwebjpa.commons.entity.vo.AjaxResult;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/20 19:24
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public final class Result implements Serializable {
    private Status status;
    private String message;
    private Object data;

    @Builder
    public Result(Status status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public static Result of(Status status, String message, Object data) {
        return new Result(status, message, data);
    }

    public AjaxResult toAjax() {
        return AjaxResult.of(status.code, message, data);
    }

    public enum Status {
        SUCCESS("success"), WARN("warn"), INFO("info"), ERROR("error"), FAILURE("failure"), DATA("data");

        private String code;

        Status(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
