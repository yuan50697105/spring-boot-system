package com.yuan.spring.boot.jooq.dao;

import com.yuan.spring.boot.jooq.entity.domain.JooqDomain;
import org.jooq.Condition;
import org.jooq.TableRecord;
import org.jooq.UpdatableRecord;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author yuane
 * @date 2019/7/18 22:14
 **/
public interface JooqDao<T extends JooqDomain<ID>, ID extends Serializable> {
    <R extends TableRecord<R>> void insert(R record);

    <R extends TableRecord<R>> void insert(R[] records);

    <R extends TableRecord<R>> void insert(Collection<R> records);

    <R extends UpdatableRecord<R>> void update(R record);

    <R extends UpdatableRecord<R>> void update(R[] record);

    <R extends UpdatableRecord<R>> void update(Collection<R> record);

    <R extends UpdatableRecord<R>> void update(R record, Condition condition);

    <R extends UpdatableRecord<R>> void delete(R record);

    <R extends UpdatableRecord<R>> void delete(R record, Condition condition);

    <R extends UpdatableRecord<R>> void delete(R[] record);

    <R extends UpdatableRecord<R>> void delete(Collection<R> record);
}
