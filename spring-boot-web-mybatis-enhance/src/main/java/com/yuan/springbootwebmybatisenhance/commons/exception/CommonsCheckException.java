package com.yuan.springbootwebmybatisenhance.commons.exception;

/**
 * @author yuane
 * @date 2019/7/9 0:24
 **/
public class CommonsCheckException extends RuntimeException {
    public CommonsCheckException() {
    }

    public CommonsCheckException(String message) {
        super(message);
    }

    public CommonsCheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonsCheckException(Throwable cause) {
        super(cause);
    }

    public CommonsCheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
