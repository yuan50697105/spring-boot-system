package com.yuan.spring.boot.dao.commons.entity.dto;

import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import lombok.Data;

/**
 * @author yuane
 * @date 2019/7/13 12:39
 **/
@Data
public class ServiceResult {
    private String code;
    private String message;
    private Object data;

    public ServiceResult(Status status, String message, Object data) {
        this.code = status.code;
        this.message = message;
        this.data = data;
    }

    public ServiceResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public AjaxResult convert() {
        return ServiceResultUtils.convert(this);
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
