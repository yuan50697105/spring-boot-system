package com.yuan.springbootweb.controller;

import com.yuan.springbootweb.entity.Status;
import com.yuan.springbootweb.entity.vo.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * @author yuane
 * @date 2019/6/8 14:19
 **/
@Controller
@RequestMapping
public class BaseController {
    @RequestMapping
    @ResponseBody
    public String index() {
        return "hello spring boot web";
    }

    @RequestMapping("callable")
    @ResponseBody
    public Callable<String> callable() {
        return () -> "hello spring boot web callable";
    }

    @RequestMapping("asyncTask")
    @ResponseBody
    public WebAsyncTask<String> asyncTask() {
        return new WebAsyncTask<>(callable());
    }

    @RequestMapping("ajaxResult")
    @ResponseBody
    public AjaxResult ajaxResult() {
        return AjaxResult.getInstance(Status.SUCCESS, "hello spring boot web", "hello spring boot web");
    }

    @RequestMapping("ajaxResult2")
    @ResponseBody
    public AjaxResult ajaxResult2() {
        return AjaxResult.getInstance(Status.SUCCESS, "hello spring boot web");
    }

    @RequestMapping("ajaxResult3")
    @ResponseBody
    public AjaxResult ajaxResult3() {
        return AjaxResult.getInstance(Status.SUCCESS, 1+1);
    }
}

