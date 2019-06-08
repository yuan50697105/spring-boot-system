package com.yuan.springbootwebjooq.dao.impl;

import com.yuan.springbootwebjooq.dao.UserDao;
import com.yuan.springbootwebjooq.utils.IdUtils;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import javax.management.openmbean.OpenDataException;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/8 16:59
 **/
@Repository
public class UserDaoImpl implements UserDao {
    private final DSLContext dslContext;

    public UserDaoImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }


    @Override
    public void insert(com.yuan.springbootwebjooq.entity.User user) {
        InsertQuery<Record> insertQuery = dslContext.insertQuery(DSL.table("user"));
        insertQuery.addValue(DSL.field("id"), IdUtils.generateId());
        insertQuery.addValue(DSL.field("name"),"jooqaaaaaaa");
        insertQuery.execute();
    }




}
