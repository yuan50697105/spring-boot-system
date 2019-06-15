package com.yuan.springbootwebjooq;

import com.xphsc.easyjdbc.boot.annotation.EnableEasyJdbc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEasyJdbc
public class SpringBootWebJooqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebJooqApplication.class, args);
    }

}
