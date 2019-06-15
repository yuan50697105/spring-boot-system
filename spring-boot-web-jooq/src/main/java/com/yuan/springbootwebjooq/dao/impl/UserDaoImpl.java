package com.yuan.springbootwebjooq.dao.impl;

import com.yuan.springbootwebjooq.dao.UserDao;
import com.yuan.springbootwebjooq.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yuane
 * @date 2019/6/8 16:59
 **/
@Repository
@Slf4j
public class UserDaoImpl implements UserDao {
    private final DSLContext dslContext;

    public UserDaoImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }


    @Override
    public void insert(com.yuan.springbootwebjooq.entity.User user) {
        InsertQuery<Record> insertQuery = dslContext.insertQuery(DSL.table("user"));
        insertQuery.addValue(DSL.field("id"), IdUtils.generateId());
        insertQuery.addValue(DSL.field("name"), "jooqaaaaaaa");
        insertQuery.execute();
    }


    @Override
    @Transactional
    public Result<Record> selectAll() {
        return dslContext.selectFrom(DSL.table("user")).fetch();
    }

    @Override
    @Transactional
    public void testDelete() {
        UpdateQuery<Record> user = dslContext.updateQuery(DSL.table("user"));
//        user.addConditions(DSL.field("id").eq("aaa"));
//        user.addFrom(DSL.table("user"));
        user.addValue(DSL.field("name"), "aaaa");
        user.execute();
    }


}
