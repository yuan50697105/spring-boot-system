package com.yuan.springbootwebmapper.commons.service;

import com.github.pagehelper.IPage;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 23:09
 **/
public interface BaseService<T> {
    int insert(T t);

    int insertSelective(T t);

    int insertAll(T[] arrays);

    int insertAll(List<T> list);

    int update(T t);

    int updateSelecttive(T t);

    int delete(Serializable id);

    int delete(Serializable[] ids);

    int delete(Collection<Serializable> ids);

    T findById(Serializable id);

    List<T> findAll(T t);

    PageInfo<T> findAll(IPage page);

    PageInfo<T> findAll(T t, IPage page);

    List<T> findAll();
}
