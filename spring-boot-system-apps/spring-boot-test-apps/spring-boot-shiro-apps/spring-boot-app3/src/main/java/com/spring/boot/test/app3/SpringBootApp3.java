package com.spring.boot.test.app3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringBootApp3 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp3.class, args);
    }
}
