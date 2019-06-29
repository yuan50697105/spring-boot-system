package com.yuan.springbootwebenhance.commons.service.impl;

import com.github.pagehelper.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.springbootwebenhance.commons.entity.po.BasePo;
import com.yuan.springbootwebenhance.commons.mapper.BaseMapper;
import com.yuan.springbootwebenhance.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 22:22
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BasePo, ID extends Serializable, S extends BaseMapper<T, ID>> implements BaseService<T, ID> {
    protected abstract S getMapper();

    protected abstract void beforeInsert(T t) throws RuntimeException;

    protected abstract void beforeUpdate(T t) throws RuntimeException;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(T t) {
        beforeInsert(t);
        getMapper().insert(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertAll(T[] ts) {
        Arrays.stream(ts).forEach(this::beforeInsert);
        getMapper().insertArray(ts);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertAll(Collection<T> collection) {
        collection.forEach(this::beforeInsert);
        getMapper().insertCollection(collection);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(T t) {
        beforeUpdate(t);
        getMapper().update(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID id) {
        getMapper().deleteOne(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID[] ids) {
        getMapper().deleteArray(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Collection<ID> ids) {
        getMapper().deleteCollection(ids);
    }

    @Override
    public T findById(ID id) {
        return getMapper().selectOne(id);
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return getMapper().selectArray(ids);
    }

    @Override
    public List<T> findAllById(Collection<ID> ids) {
        return getMapper().selectCollection(ids);
    }

    @Override
    public List<T> findAll() {
        return getMapper().selectAll();
    }

    @Override
    public PageInfo<T> findAll(IPage page) {
        PageHelper.startPage(page);
        return PageInfo.of(getMapper().selectAll());
    }
}
