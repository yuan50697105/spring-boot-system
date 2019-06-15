package com.yuan.springbootwebjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
@EnableJpaRepositories
public class SpringBootWebJpaApplicationTests {
    @Autowired
    ApplicationContext context;
    @Test
    public void contextLoads() {
    }

    public void test() {
    }

}
