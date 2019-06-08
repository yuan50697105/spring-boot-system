package com.yuan.springbootwebmybatisplus;

import com.yuan.springbootwebmybatisplus.entity.User;
import com.yuan.springbootwebmybatisplus.mapper.UserMapper;
import com.yuan.springbootwebmybatisplus.utils.IdUtils;
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
        SqlSession sqlSession = context.getBean(SqlSession.class);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setId(IdUtils.generateId());
        user.setName(String.valueOf(System.currentTimeMillis()));
        mapper.insert(user);
        System.out.println(user);
    }

}
