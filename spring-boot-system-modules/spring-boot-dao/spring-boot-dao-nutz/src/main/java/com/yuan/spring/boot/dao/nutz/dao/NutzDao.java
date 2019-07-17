package com.yuan.spring.boot.dao.nutz.dao;

import com.yuan.spring.boot.dao.nutz.entity.domain.NutzDomain;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author yuane
 * @date 2019/7/17 23:51
 **/
public interface NutzDao<T extends NutzDomain<ID>, ID extends Serializable> {
    boolean isNew(T t);

    void save(T t);

    void saveBatch(T[] arrays);

    void saveBatch(Collection<T> collection);

    void update(T t);

    void updateBatch(T[] arrays);

    void updateBatch(Collection<T> collection);

    void deleteById(ID id);

    void deleteById(ID[] arrays);

    void deleteById(Collection<ID> collection);

    void delete(T t);

    void delete(T[] arrays);

    void delete(Collection<T> collection);

    T get(ID id);
}
