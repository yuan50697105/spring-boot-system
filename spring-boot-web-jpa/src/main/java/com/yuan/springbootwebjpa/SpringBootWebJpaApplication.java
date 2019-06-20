package com.yuan.springbootwebjpa;

import com.yuan.springbootwebjpa.commons.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class SpringBootWebJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebJpaApplication.class, args);
    }

}
