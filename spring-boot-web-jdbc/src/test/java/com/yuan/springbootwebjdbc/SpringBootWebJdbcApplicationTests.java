package com.yuan.springbootwebjdbc;

import com.yuan.springbootwebjdbc.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebJdbcApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private ApplicationContext context;
    @Test
    public void contextLoads() {
    }

    @Test
    @Rollback(false)
    @Transactional
    public void test() {
        UserDao bean = context.getBean(UserDao.class);

    }

    public void test1() {
//        jdbcTemplate.queryForList("select * from ")
    }

}
