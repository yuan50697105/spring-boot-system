package com.yuan.springbootwebjooq;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
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
public class SpringBootWebJooqApplicationTests {

    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testSave() {
    }

    @Test
    @Transactional
//    @Rollback(false)
    public void testDelete() {

    }

    @Test
    @Transactional
    public void test() {
        DSLContext dslContext = context.getBean(DSLContext.class);
        Result<Record> record1s = dslContext.selectFrom(DSL.table("user")).offset(1).limit(1).fetch();
        System.out.println(record1s);
    }



}
