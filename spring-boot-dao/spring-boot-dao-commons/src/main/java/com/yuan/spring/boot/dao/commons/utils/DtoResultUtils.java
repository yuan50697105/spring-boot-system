package com.yuan.spring.boot.dao.commons.utils;

import com.yuan.spring.boot.dao.commons.entity.dto.DtoResult;

/**
 * @author yuane
 * @date 2019/7/13 12:42
 **/
public abstract class DtoResultUtils {
    private static final String OK = "操作成功";
    private static final String FAILURE = "操作失败";
    private static final String ERROR = "操作异常";
    private static final String WARN = "操作警告";

    public static DtoResult build(DtoResult.Status status, String message, Object data) {
        return new DtoResult(status, message, data);
    }

    public static DtoResult build(String status, String message, Object data) {
        DtoResult.Status status1 = DtoResult.Status.valueOf(status);
        if (status != null) {
            return build(status1, message, data);
        } else {
            return new DtoResult(status, message, data);
        }
    }

    public static DtoResult message(DtoResult.Status status, String message) {
        return build(status, message, null);
    }

    public static DtoResult message(String status, String message) {
        return build(status, message, null);
    }

    public static DtoResult data(DtoResult.Status status, Object data) {
        return build(status, null, data);
    }

    public static DtoResult data(String status, Object data) {
        return build(status, null, data);
    }

    public static DtoResult ok(String message, Object data) {
        return build(DtoResult.Status.OK, message, data);
    }

    public static DtoResult ok(String message) {
        return message(DtoResult.Status.OK, message);
    }

    public static DtoResult ok() {
        return ok(OK);
    }

    public static DtoResult failure(String message, Object data) {
        return build(DtoResult.Status.FAILURE, message, data);
    }

    public static DtoResult failure(String message) {
        return message(DtoResult.Status.FAILURE, message);
    }

    public static DtoResult failure() {
        return failure(FAILURE);
    }

    public static DtoResult error(String message, Object data) {
        return build(DtoResult.Status.ERROR, message, data);
    }

    public static DtoResult error(String message) {
        return message(DtoResult.Status.ERROR, message);
    }

    public static DtoResult error() {
        return error(ERROR);
    }

    public static DtoResult warn(String message, Object data) {
        return build(DtoResult.Status.WARN, message, data);
    }

    public static DtoResult warn(String message) {
        return message(DtoResult.Status.WARN, message);
    }

    public static DtoResult warn() {
        return warn(WARN);
    }
}
