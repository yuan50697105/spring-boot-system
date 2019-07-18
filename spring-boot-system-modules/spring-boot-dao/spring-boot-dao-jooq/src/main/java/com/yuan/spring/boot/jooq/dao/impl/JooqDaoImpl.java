package com.yuan.spring.boot.jooq.dao.impl;

import com.yuan.spring.boot.jooq.dao.JooqDao;
import com.yuan.spring.boot.jooq.entity.domain.JooqDomain;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/18 22:15
 **/

public abstract class JooqDaoImpl<T extends JooqDomain<ID>, ID extends Serializable> implements JooqDao<T, ID> {
    @Autowired
    protected DSLContext dslContext;

    protected DSLContext getDslContext() {
        return dslContext;
    }


}
