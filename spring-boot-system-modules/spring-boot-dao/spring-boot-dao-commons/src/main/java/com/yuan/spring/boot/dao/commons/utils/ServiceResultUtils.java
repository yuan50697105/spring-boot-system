package com.yuan.spring.boot.dao.commons.utils;

import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;

/**
 * @author yuane
 * @date 2019/7/13 12:42
 **/
public class ServiceResultUtils {
    private static final String OK = "操作成功";
    private static final String FAILURE = "操作失败";
    private static final String ERROR = "操作异常";
    private static final String WARN = "操作警告";

    public static <T> AjaxResult<T> convert(ServiceResult<T> result) {
        return AjaxResult.build(result.getCode(), result.getMessage(), result.getData());
    }

    public static <T> ServiceResult<T> build(ServiceResult.Status status, String message, T data) {
        return new ServiceResult<>(status, message, data);
    }

    public static <T> ServiceResult<T> build(String status, String message, T data) {
        ServiceResult.Status status1 = ServiceResult.Status.valueOf(status);
        if (status != null) {
            return build(status1, message, data);
        } else {
            return new ServiceResult<>(status, message, data);
        }
    }

    public static <T> ServiceResult<T> message(ServiceResult.Status status, String message) {
        return build(status, message, null);
    }

    public static <T> ServiceResult<T> message(String status, String message) {
        return build(status, message, null);
    }

    public static <T> ServiceResult<T> data(ServiceResult.Status status, T data) {
        return build(status, null, data);
    }

    public static <T> ServiceResult<T> data(String status, T data) {
        return build(status, null, data);
    }

    public static <T> ServiceResult<T> ok(String message, T data) {
        return build(ServiceResult.Status.OK, message, data);
    }

    public static <T> ServiceResult<T> ok(String message) {
        return message(ServiceResult.Status.OK, message);
    }

    public static <T> ServiceResult<T> ok() {
        return ok(OK);
    }

    public static <T> ServiceResult<T> failure(String message, T data) {
        return build(ServiceResult.Status.FAILURE, message, data);
    }

    public static <T> ServiceResult<T> failure(String message) {
        return message(ServiceResult.Status.FAILURE, message);
    }

    public static <T> ServiceResult<T> failure() {
        return failure(FAILURE);
    }

    public static <T> ServiceResult<T> error(String message, T data) {
        return build(ServiceResult.Status.ERROR, message, data);
    }

    public static <T> ServiceResult<T> error(String message) {
        return message(ServiceResult.Status.ERROR, message);
    }

    public static <T> ServiceResult<T> error() {
        return error(ERROR);
    }

    public static <T> ServiceResult<T> warn(String message, T data) {
        return build(ServiceResult.Status.WARN, message, data);
    }

    public static <T> ServiceResult<T> warn(String message) {
        return message(ServiceResult.Status.WARN, message);
    }

    public static <T> ServiceResult<T> warn() {
        return warn(WARN);
    }
}
