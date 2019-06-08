package com.yuan.springbootwebfreemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("indexFree")
    public String indexFree(Model model) {
        model.addAttribute("name", "hello spring boot web");
        return "index";
    }

    @RequestMapping("callableFree")
    public Callable<String> callableFree(Model model) {
        return () -> {
            model.addAttribute("name", "hello spring boot web");
            return "index";
        };
    }

    @RequestMapping("asyncTaskFree")
    public WebAsyncTask<String> asyncTaskFree(Model model) {
        return new WebAsyncTask<>(() -> {
            model.addAttribute("name", "hello spring boot web");
            return "index";
        });
    }
}

