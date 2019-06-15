package com.yuan.springbootwebjdbc.commons.service.impl;

import com.xphsc.easyjdbc.core.entity.Sorts;
import com.xphsc.easyjdbc.page.PageInfo;
import com.yuan.springbootwebjdbc.commons.dao.BaseDao;
import com.yuan.springbootwebjdbc.commons.entity.BaseEntity;
import com.yuan.springbootwebjdbc.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 16:28
 **/
public abstract class BaseServiceImpl<T extends BaseEntity, S extends BaseDao<T>> implements BaseService<T> {
    protected abstract S getDao();

    @Override
    @Transactional
    public int insert(T t) {
        return getDao().insert(t);
    }

    @Override
    @Transactional
    public int batchInsert(List<T> list) {
        return getDao().batchInsert(list);
    }

    @Override
    @Transactional
    public int update(T t) {
        return getDao().update(t);
    }

    @Override
    @Transactional
    public int batchUpdate(List<T> list) {
        return getDao().batchUpdate(list);
    }

    @Override
    @Transactional
    public int delete(Serializable id) {
        return getDao().deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int delete(Iterable iterable) {
        return getDao().deleteByIds(iterable);
    }

    @Override
    public Optional<T> findById(Serializable id) {
        return getDao().getById(id);
    }

    @Override
    public List<T> findByIds(Iterable iterable) {
        return getDao().findByIds(iterable);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public List<T> findAll(Sorts sorts) {
        return getDao().findAll(sorts);
    }

    @Override
    public PageInfo<T> findAll(PageInfo pageInfo) {
        return getDao().findAll(pageInfo);
    }

    @Override
    public PageInfo<T> findAll(PageInfo pageInfo, Sorts sorts) {
        return getDao().findAll(pageInfo, sorts);
    }
}
