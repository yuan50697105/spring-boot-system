package com.yuan.springbootwebmybatisplus.commons.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yuan.springbootwebmybatisplus.commons.entity.vo.AjaxResult;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/20 22:53
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result implements Serializable {
    private String code;
    private String message;
    private Object data;

    private Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result of(String code, String message, Object data) {
        return new Result(code, message, data);
    }

    public AjaxResult toAjax() {
        return AjaxResult.of(code, message, data);
    }
}
