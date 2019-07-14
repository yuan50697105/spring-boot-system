package com.yuan.spring.boot.dao.commons.exception;

/**
 * @author yuane
 * @date 2019/7/14 13:24
 **/
public class CheckNotPassException extends RuntimeException {
    public CheckNotPassException() {
    }

    public CheckNotPassException(String message) {
        super(message);
    }

    public CheckNotPassException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckNotPassException(Throwable cause) {
        super(cause);
    }

    public CheckNotPassException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
