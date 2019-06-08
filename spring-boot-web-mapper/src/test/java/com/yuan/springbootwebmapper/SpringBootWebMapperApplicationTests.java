package com.yuan.springbootwebmapper;

import com.yuan.springbootwebmapper.entity.User;
import com.yuan.springbootwebmapper.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
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
public class SpringBootWebMapperApplicationTests {
    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testSave() {
        SqlSession bean = context.getBean(SqlSession.class);
        UserMapper mapper = bean.getMapper(UserMapper.class);
        User user = new User();
        user.setName("testmapper");
        mapper.insert(user);
        System.out.println(user);
    }

}
