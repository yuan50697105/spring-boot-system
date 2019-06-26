package com.yuan.springbootwebmybatisplus.commons.controller;

import com.yuan.springbootwebmybatisplus.commons.entity.dto.Result;
import com.yuan.springbootwebmybatisplus.commons.entity.vo.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.WebAsyncTask;

/**
 * @author yuane
 * @date 2019/6/25 22:43
 **/
@ControllerAdvice
public class BaseController {
    @ExceptionHandler(Exception.class)
    public WebAsyncTask<AjaxResult> exceptionHandler(Exception e) {
        return new WebAsyncTask<>(() -> Result.of(Result.Status.ERROR, e.getMessage(), null).toAjax());
    }
}
