package com.yuan.springbootwebjpa.commons.controller;

import com.yuan.springbootwebjpa.commons.entity.dto.Result;
import com.yuan.springbootwebjpa.commons.entity.vo.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

/**
 * @author yuane
 * @date 2019/6/25 18:36
 **/
@ControllerAdvice
public abstract class BaseController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public WebAsyncTask<AjaxResult> exceptionHandler(Exception e) {
        return new WebAsyncTask<>(() -> Result.of(Result.Status.ERROR, e.getMessage(), null).toAjax());
    }


}
