package com.yuan.springbootwebmybatisplus.commons.controller;

import com.yuan.springbootwebmybatisplus.commons.entity.dto.Result;
import com.yuan.springbootwebmybatisplus.commons.entity.vo.AjaxResult;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yuane
 * @date 2019/6/25 22:43
 **/
@ControllerAdvice
public abstract class BaseController {
    @ExceptionHandler(Exception.class)
    public WebAsyncTask<AjaxResult> exceptionHandler(Exception e) {
        return new WebAsyncTask<>(() -> Result.of(Result.Status.ERROR, e.getMessage(), null).toAjax());
    }

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    public HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
    }

    public String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    public String[] getParaamters(String name) {
        return getRequest().getParameterValues(name);
    }

    public void download(InputStream inputStream) {
        try (ServletOutputStream outputStream = getResponse().getOutputStream();
             BufferedInputStream bufferedInputStream = IOUtils.buffer(inputStream, 1024);
             BufferedOutputStream bufferedOutputStream = IOUtils.buffer(outputStream, 1024)) {
            IOUtils.copy(bufferedInputStream, bufferedOutputStream, 1024);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
