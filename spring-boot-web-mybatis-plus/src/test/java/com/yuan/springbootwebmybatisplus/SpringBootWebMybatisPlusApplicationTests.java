package com.yuan.springbootwebmybatisplus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebMybatisPlusApplicationTests {

    @Autowired
    ApplicationContext context;
    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testSave(){
    }

}
