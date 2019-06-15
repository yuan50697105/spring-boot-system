package com.yuan.springbootwebenhance.commons.service;

import com.github.pagehelper.IPage;
import com.github.pagehelper.PageInfo;
import com.yuan.springbootwebenhance.commons.entity.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 22:22
 **/
public interface BaseService<T extends BaseEntity, ID extends Serializable> {
    void insert(T t);

    void insertAll(T[] ts);

    void insertAll(Collection<T> collection);

    void update(T t);

    void delete(ID id);

    void delete(ID[] ids);

    void delete(Collection<ID> ids);

    T findById(ID id);

    List<T> findAllById(ID[] ids);

    List<T> findAllById(Collection<ID> ids);

    List<T> findAll();

    PageInfo<T> findAll(IPage page);
}
