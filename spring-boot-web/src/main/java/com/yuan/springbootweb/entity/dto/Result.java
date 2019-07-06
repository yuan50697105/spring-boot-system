package com.yuan.springbootweb.entity.dto;

import com.yuan.springbootweb.entity.vo.AjaxResult;
import lombok.Data;

/**
 * @author yuane
 * @date 2019/7/6 11:31
 **/
@Data
public class Result {
    private String status;
    private String message;
    private Object data;

    private Result(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private Result(Status status, String message, Object data) {
        this.status = status.status;
        this.message = message;
        this.data = data;
    }


    public static Result of(String status, String message, Object data) {
        return new Result(status, message, data);
    }

    public static Result of(Status status, String message, Object data) {
        return of(status.status, message, data);
    }

    public static Result data(Status status, Object data) {
        return of(status, null, data);
    }

    public static Result data(Object data) {
        return data(Status.DATA, data);
    }

    public static Result message(Status status, String message) {
        return of(status, message, null);
    }

    public static Result message(String message) {
        return message(Status.MESSAGE, message);
    }

    public AjaxResult toAjax() {
        return AjaxResult.of(status, message, data);
    }

    public enum Status {
        SUCCESS("success"), FAILURE("failure"), WARN("warn"), ERROR("error"), DATA("data"), MESSAGE("message");
        private String status;

        Status(String status) {
            this.status = status;
        }

        public Result withResult(String message, Object data) {
            return Result.of(status, message, data);
        }

        public Result withData(Object data) {
            return withResult(null, data);
        }

        public Result withMessage(String message) {
            return withResult(message, null);
        }
    }
}
