package com.yuan.springbootwebflux;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

/**
 * @author yuane
 * @date 2019/6/9 23:21
 **/
@Controller
@RequestMapping
public class BaseController {
    @RequestMapping
    @ResponseBody
    public Mono createMono() {
        return Mono.justOrEmpty("aaa");
    }


    @RequestMapping("createMono1")
    @ResponseBody
    public Mono createMono1(String aaa) {
        return Mono.justOrEmpty(aaa);
    }
}
