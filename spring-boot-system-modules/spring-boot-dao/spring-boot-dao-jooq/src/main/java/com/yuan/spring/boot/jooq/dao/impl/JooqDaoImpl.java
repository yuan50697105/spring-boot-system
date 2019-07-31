package com.yuan.spring.boot.jooq.dao.impl;

import com.yuan.spring.boot.jooq.dao.JooqDao;
import com.yuan.spring.boot.jooq.entity.domain.JooqDomain;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.TableRecord;
import org.jooq.UpdatableRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;

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

    @Override
    public <R extends TableRecord<R>> void insert(R record) {
        dslContext.executeInsert(record);
    }

    @Override
    public <R extends TableRecord<R>> void insert(R[] records) {
        dslContext.batchInsert(records);
    }

    @Override
    public <R extends TableRecord<R>> void insert(Collection<R> records) {
        dslContext.batchInsert(records);
    }

    @Override
    public <R extends UpdatableRecord<R>> void update(R record) {
        dslContext.executeUpdate(record);
    }

    @Override
    public <R extends UpdatableRecord<R>> void update(R[] record) {
        dslContext.batchUpdate(record);
    }

    @Override
    public <R extends UpdatableRecord<R>> void update(Collection<R> record) {
        dslContext.batchUpdate(record);
    }

    @Override
    public <R extends UpdatableRecord<R>> void update(R record, Condition condition) {
        dslContext.executeUpdate(record, condition);
    }

    @Override
    public <R extends UpdatableRecord<R>> void delete(R record) {
        dslContext.executeDelete(record);
    }

    @Override
    public <R extends UpdatableRecord<R>> void delete(R record, Condition condition) {
        dslContext.executeDelete(record, condition);
    }

    @Override
    public <R extends UpdatableRecord<R>> void delete(R[] record) {
        dslContext.batchDelete(record);
    }

    @Override
    public <R extends UpdatableRecord<R>> void delete(Collection<R> record) {
        dslContext.batchDelete(record);
    }


}
