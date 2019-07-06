package com.yuan.springbootwebfreemarker.controller;

import com.yuan.springbootweb.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuane
 * @date 2019/7/6 11:06
 **/
@Controller
public class TestController extends BaseController {
    @RequestMapping
    public String index() {
        return "index";
    }
}
