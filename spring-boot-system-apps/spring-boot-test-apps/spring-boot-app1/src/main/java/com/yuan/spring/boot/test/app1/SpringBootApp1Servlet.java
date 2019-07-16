package com.yuan.spring.boot.test.app1;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author yuane
 * @date 2019/7/17 0:36
 **/
public class SpringBootApp1Servlet extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootApp1.class);
    }
}
