package com.yuan.springbootweb.controller;

import com.yuan.springbootweb.entity.vo.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yuane
 * @date 2019/7/3 22:30
 **/
@ControllerAdvice
public class BaseController {
    @ExceptionHandler(Exception.class)
    public AjaxResult handler(Exception e) {
        return AjaxResult.message("error", e.getMessage());
    }

    public HttpServletResponse getResponse() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        return ((ServletRequestAttributes) requestAttributes).getResponse();
    }

    public HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    public String getString(String name) {
        return getRequest().getParameter(name);
    }

    public String[] getStringValues(String name) {
        return getRequest().getParameterValues(name);
    }

    public String getRemoteUser() {
        return getRequest().getRemoteUser();
    }

    public String getRemoteHost() {
        return getRequest().getRemoteHost();
    }

}
