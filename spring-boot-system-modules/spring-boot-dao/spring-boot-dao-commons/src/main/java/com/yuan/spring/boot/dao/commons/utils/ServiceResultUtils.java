package com.yuan.spring.boot.dao.commons.utils;

import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;

/**
 * @author yuane
 * @date 2019/7/13 12:42
 **/
public abstract class ServiceResultUtils {
    private static final String OK = "操作成功";
    private static final String FAILURE = "操作失败";
    private static final String ERROR = "操作异常";
    private static final String WARN = "操作警告";

    public static AjaxResult convert(ServiceResult result) {
        return AjaxResult.build(result.getCode(), result.getMessage(), result.getData());
    }

    public static ServiceResult build(ServiceResult.Status status, String message, Object data) {
        return new ServiceResult(status, message, data);
    }

    public static ServiceResult build(String status, String message, Object data) {
        ServiceResult.Status status1 = ServiceResult.Status.valueOf(status);
        if (status != null) {
            return build(status1, message, data);
        } else {
            return new ServiceResult(status, message, data);
        }
    }

    public static ServiceResult message(ServiceResult.Status status, String message) {
        return build(status, message, null);
    }

    public static ServiceResult message(String status, String message) {
        return build(status, message, null);
    }

    public static ServiceResult data(ServiceResult.Status status, Object data) {
        return build(status, null, data);
    }

    public static ServiceResult data(String status, Object data) {
        return build(status, null, data);
    }

    public static ServiceResult ok(String message, Object data) {
        return build(ServiceResult.Status.OK, message, data);
    }

    public static ServiceResult ok(String message) {
        return message(ServiceResult.Status.OK, message);
    }

    public static ServiceResult ok() {
        return ok(OK);
    }

    public static ServiceResult failure(String message, Object data) {
        return build(ServiceResult.Status.FAILURE, message, data);
    }

    public static ServiceResult failure(String message) {
        return message(ServiceResult.Status.FAILURE, message);
    }

    public static ServiceResult failure() {
        return failure(FAILURE);
    }

    public static ServiceResult error(String message, Object data) {
        return build(ServiceResult.Status.ERROR, message, data);
    }

    public static ServiceResult error(String message) {
        return message(ServiceResult.Status.ERROR, message);
    }

    public static ServiceResult error() {
        return error(ERROR);
    }

    public static ServiceResult warn(String message, Object data) {
        return build(ServiceResult.Status.WARN, message, data);
    }

    public static ServiceResult warn(String message) {
        return message(ServiceResult.Status.WARN, message);
    }

    public static ServiceResult warn() {
        return warn(WARN);
    }
}
