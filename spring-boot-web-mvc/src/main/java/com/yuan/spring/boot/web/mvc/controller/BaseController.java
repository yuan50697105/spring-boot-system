package com.yuan.spring.boot.web.mvc.controller;

import com.yuan.spring.boot.web.mvc.entity.dto.Result;
import com.yuan.spring.boot.web.mvc.entity.vo.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author yuane
 * @date 2019/7/3 22:30
 **/
@ControllerAdvice
public class BaseController {
    @ExceptionHandler(Exception.class)
    public AjaxResult handler(Exception e) {
        return Result.Status.ERROR.withMessage(e.getMessage()).toAjax();
    }


}
