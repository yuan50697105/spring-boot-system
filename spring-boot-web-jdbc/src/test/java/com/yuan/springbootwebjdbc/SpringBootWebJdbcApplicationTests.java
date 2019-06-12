package com.yuan.springbootwebjdbc;

import com.yuan.springbootwebjdbc.dao.UserDao;
import com.yuan.springbootwebjdbc.entity.User;
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
public class SpringBootWebJdbcApplicationTests {

    @Autowired
    private ApplicationContext context;
    @Test
    public void contextLoads() {
    }

    @Test
    @Rollback(false)
    @Transactional
    public void test() {
        UserDao userDao = context.getBean(UserDao.class);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
//            user.setId(IdUtils.generateId());
            user.setName("datajdbc");
            users.add(user);
        }
        Iterable<User> save = userDao.saveAll(users);
        System.out.println(save);
    }

}
