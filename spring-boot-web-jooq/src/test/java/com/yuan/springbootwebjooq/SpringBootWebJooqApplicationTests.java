package com.yuan.springbootwebjooq;

import com.xphsc.easyjdbc.page.PageInfo;
import org.jooq.DSLContext;
import org.jooq.Query;
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

import java.util.List;
import java.util.Map;

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

    public PageInfo<Map<String, Object>> findAll(Query query, PageInfo<Map<String, Object>> pageInfo) {
        DSLContext dslContext = context.getBean(DSLContext.class);
        Integer integer = dslContext.select(DSL.count()).from(DSL.sql(query.getSQL(), query.getBindValues())).fetchOne(DSL.count());
        List<Map<String, Object>> records = dslContext.selectFrom(DSL.sql(query.getSQL(), query.getBindValues())).offset(pageInfo.getOffset()).limit(pageInfo.getLimit()).fetchMaps();
        pageInfo.setList(records);
        pageInfo.setTotal(integer);
        return pageInfo;
    }


}
