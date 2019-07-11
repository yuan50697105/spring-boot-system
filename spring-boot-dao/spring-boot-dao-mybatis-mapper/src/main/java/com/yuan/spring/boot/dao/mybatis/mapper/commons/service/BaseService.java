package com.yuan.spring.boot.dao.mybatis.mapper.commons.service;

import com.github.pagehelper.IPage;
import com.github.pagehelper.PageInfo;
import com.yuan.spring.boot.dao.mybatis.mapper.commons.entity.po.BasePo;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 23:09
 **/
public interface BaseService<T extends BasePo<ID>, ID extends Serializable> {

    void checkInsert(T t) throws RuntimeException;

    void checkInsertSelective(T t) throws RuntimeException;

    void checkUpdate(T t) throws RuntimeException;

    void checkUpdateSelective(T t) throws RuntimeException;

    int insert(T t);

    int insertSelective(T t);

    int insertAll(T[] arrays);

    int insertAll(List<T> list);

    int update(T t);

    int updateSelective(T t);

    int delete(ID id);

    int delete(ID[] ids);

    int delete(Collection<ID> ids);

    T findById(ID id);

    List<T> findAll(T t);

    List<T> findAllById(ID[] ids);

    List<T> findAllById(Collection<ID> collection);

    T findOne(T t);

    PageInfo<T> findAll(IPage page);

    PageInfo<T> findAll(T t, IPage page);

    PageInfo<T> findAll(Example example, IPage page);

    List<T> findAll();


}
