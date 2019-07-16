package com.yuan.spring.boot.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yuane
 * @date 2019/7/12 23:57
 **/
//@SpringBootApplication(exclude = { DataSourceConfiguration.class,DruidDataSourceAutoConfigure.class})
@SpringBootApplication
public class SpringBootWebApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication1.class, args);
    }
}
