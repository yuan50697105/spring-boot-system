package com.yuan.springbootwebmybatis;

import com.yuan.springbootwebmybatis.entity.User;
import com.yuan.springbootwebmybatis.mapper.UserMapper;
import com.yuan.springbootwebmybatis.utils.IdUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebMybatisApplicationTests {
    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testInsert() {

        User user = new User();
        user.setId(IdUtils.generateId());
        user.setName("myaaa");
        UserMapper bean = context.getBean(UserMapper.class);
        bean.insert(user);
        user = new User();
        user.setId(IdUtils.generateId());
        user.setName("myaaa");
        bean.insert(user);
        List<User> users = bean.selectAll();
        System.out.println(users);
        List<User> users1 = bean.selectAll();
        System.out.println(users1);
    }

}
