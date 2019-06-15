package com.yuan.springbootwebenhance;

import com.yuan.springbootwebenhance.entity.User;
import com.yuan.springbootwebenhance.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebEnhanceApplicationTests {

    @Autowired
    ApplicationContext context;
    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testInset() {
        UserMapper userMapper = context.getBean(UserMapper.class);
        List<User> users = new ArrayList<>();
    }

}
