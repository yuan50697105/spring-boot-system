package com.yuan.spring.boot.dao.jdbc.dao.impl;

import com.xphsc.easyjdbc.core.SimpleJdbcDao;
import com.yuan.spring.boot.dao.jdbc.dao.JdbcDao;
import com.yuan.spring.boot.dao.jdbc.entity.domain.JdbcDomain;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.GenericSqlQuery;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 22:08
 **/
public class JdbcDaoImpl<T extends JdbcDomain<ID>, ID extends Serializable> extends SimpleJdbcDao<T> implements JdbcDao<T, ID> {
    @Autowired
    private DSLContext dslContext;
    @Override
    public DSLContext getDslContext() {
        return dslContext;
    }
}
