package com.yuan.springbootwebjdbc.commons.service;

import com.xphsc.easyjdbc.core.entity.Sorts;
import com.xphsc.easyjdbc.page.PageInfo;
import com.yuan.springbootwebjdbc.commons.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 16:27
 **/
public interface BaseService<T extends BaseEntity> {
    int insert(T t);

    int batchInsert(List<T> list);

    int update(T t);

    int batchUpdate(List<T> list);

    int delete(Serializable id);

    int delete(Iterable iterable);

    Optional<T> findById(Serializable id);

    List<T> findByIds(Iterable iterable);

    List<T> findAll();

    List<T> findAll(Sorts sorts);

    PageInfo<T> findAll(PageInfo pageInfo);

    PageInfo<T> findAll(PageInfo pageInfo, Sorts sorts);
}
