package com.yuan.spring.boot.dao.nutz.dao.impl;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.nutz.dao.NutzDao;
import com.yuan.spring.boot.dao.nutz.entity.domain.NutzDomain;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author yuane
 * @date 2019/7/17 23:52
 **/

public abstract class NutzDaoImpl<T extends NutzDomain<ID>, ID extends Serializable> implements NutzDao<T, ID> {
    @Autowired
    private Dao dao;
    private Class<T> type;
    private Class<ID> idClass;

    @SuppressWarnings("unchecked")
    public NutzDaoImpl() {
        Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        type = (Class<T>) actualTypeArguments[0];
        idClass = (Class<ID>) actualTypeArguments[1];
    }

    @Override
    public boolean isNew(T t) {
        return ObjectUtil.isEmpty(t.getId()) && get(t.getId()) == null;
    }

    @Override
    public void save(T t) {
        dao.insert(t);
    }

    @Override
    public void saveBatch(T[] arrays) {
        Arrays.stream(arrays).forEach(this::save);
    }

    @Override
    public void saveBatch(Collection<T> collection) {
        collection.forEach(this::save);
    }

    @Override
    public void update(T t) {
        dao.updateIgnoreNull(t);
    }

    @Override
    public void updateBatch(T[] arrays) {
        Arrays.stream(arrays).forEach(this::update);
    }

    @Override
    public void updateBatch(Collection<T> collection) {
        collection.forEach(this::update);
    }

    @Override
    public void deleteById(ID id) {
        dao.deletex(type, id);
    }

    @Override
    public void deleteById(ID[] arrays) {
        Arrays.stream(arrays).forEach(this::deleteById);
    }

    @Override
    public void deleteById(Collection<ID> collection) {
        collection.forEach(this::deleteById);
    }

    @Override
    public void delete(T t) {
        dao.delete(t);
    }

    @Override
    public void delete(T[] arrays) {
        Arrays.stream(arrays).forEach(this::delete);
    }

    @Override
    public void delete(Collection<T> collection) {
        collection.forEach(this::delete);
    }

    @Override
    public T get(ID id) {
        if (id instanceof Long) {
            return dao.fetch(type, (Long) id);
        } else {
            return dao.fetch(type, (String) id);
        }
    }


}
