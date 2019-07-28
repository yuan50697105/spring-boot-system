package com.yuan.spring.app1.modules.commons.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author yuane
 * @date 2019/7/27 10:54
 **/
@ControllerAdvice
public class BaseController {
    @ExceptionHandler(Exception.class)
    public String handler(Exception e) {
        return e.getMessage();
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AjaxResult<T> {
        private String code;
        private String message;
        private T data;

        public AjaxResult() {
        }

        @Builder
        public AjaxResult(String code, String message, T data) {
            this.code = code;
            this.message = message;
            this.data = data;
        }

        public static <T> AjaxResult<T> build(String code, String message, T data) {
            return new AjaxResult<>(code, message, data);
        }

        public static <T> AjaxResult<T> build(Status status, String message, T data) {
            return build(status.code, message, data);
        }

        public static AjaxResult build(String code, String message) {
            return build(code, message, null);
        }

        public static AjaxResult build(Status status, String message) {
            return build(status, message, null);
        }

        public static AjaxResult ok(String message) {
            return build(Status.OK, message);
        }

        public static <T> AjaxResult<T> ok(String message, T data) {
            return build(Status.OK, message, data);
        }

        public static AjaxResult ok() {
            return build(Status.OK, null);
        }

        public static AjaxResult error(String message) {
            return build(Status.ERROR, message);
        }

        public static <T> AjaxResult<T> error(String message, T data) {
            return build(Status.ERROR, message, data);
        }

        public static AjaxResult error() {
            return build(Status.ERROR, null);
        }

        public Status getStatus() {
            return Status.valueOf(code);
        }

        public enum Status {
            OK("ok"), ERROR("error");
            private String code;

            Status(String code) {
                this.code = code;
            }
        }
    }
}
