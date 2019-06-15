package com.yuan.springbootwebjdbc;

import com.xphsc.easyjdbc.boot.annotation.EnableEasyJdbc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEasyJdbc
public class SpringBootWebJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebJdbcApplication.class, args);
    }


}
