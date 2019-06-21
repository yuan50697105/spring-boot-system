package com.yuan.springbootwebenhance.commons.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author yuane
 * @date 2019/6/21 20:49
 **/
@Data
@JsonFormat(pattern = "yyyy-MM-dd")
public final class AjaxResult {
    private String code;
    private String message;
    private Object data;

    private AjaxResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static AjaxResult of(String code, String message, Object data) {
        return new AjaxResult(code, message, data);
    }
}
