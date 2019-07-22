package com.yuan.spring.boot.test.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mybatis.repository.config.EnableMybatisAuditing;

/**
 * @author yuane
 * @date 2019/7/17 0:35
 **/
@SpringBootApplication
@EnableMybatisAuditing
public class SpringBootApp1 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp1.class, args);
    }
}
