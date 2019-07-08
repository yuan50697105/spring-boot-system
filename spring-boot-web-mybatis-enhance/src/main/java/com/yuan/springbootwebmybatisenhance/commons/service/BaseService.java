package com.yuan.springbootwebmybatisenhance.commons.service;

import com.gitee.hengboy.mybatis.pageable.Page;
import com.gitee.hengboy.mybatis.pageable.request.Pageable;
import com.yuan.springbootwebmybatisenhance.commons.entity.po.BasePo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseService<T extends BasePo, ID extends Serializable> {
    void checkInsert(T t) throws RuntimeException;

    void checkUpdate(T t) throws RuntimeException;

    void insert(T t) throws RuntimeException;

    void insertAll(T[] arrays);

    void insertAll(Collection<T> collection);

    void update(T t);

    void delete(ID id);

    void delete(ID[] ids);

    void delete(Collection<ID> collection);

    T getById(ID id);

    List<T> findAllById(ID[] ids);

    List<T> findAllById(Collection<ID> collection);

    Page<T> findAll(Pageable pageable);

    List<T> findAll();
}
