package com.yuan.spring.boot.dao.commons.entity.dto;

import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import lombok.Data;

/**
 * @author yuane
 * @date 2019/7/13 12:39
 **/
@Data
public class ServiceResult<T> {
    private String code;
    private String message;
    private T data;

    public ServiceResult(Status status, String message, T data) {
        this.code = status.code;
        this.message = message;
        this.data = data;
    }

    public ServiceResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public AjaxResult<T> convert() {
        return AjaxResult.build(code, message, data);
    }

    public enum Status {
        OK("ok"), FAILURE("failure"), ERROR("error"), WARN("warn");
        private String code;

        Status(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

}
