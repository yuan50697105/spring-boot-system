package com.yuan.springbootwebmapper.commons.service.impl;

import com.github.pagehelper.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.springbootwebmapper.commons.entity.BaseEntity;
import com.yuan.springbootwebmapper.commons.mapper.BaseMapper;
import com.yuan.springbootwebmapper.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 23:10
 **/
public abstract class BaseServiceImpl<T extends BaseEntity, S extends BaseMapper<T>> implements BaseService<T> {
    protected abstract S getMapper();

    @Override
    @Transactional
    public int insert(T t) {
        return getMapper().insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return getMapper().insertSelective(t);
    }

    @Override
    @Transactional
    public int insertAll(T[] arrays) {
        return insertAll(Arrays.asList(arrays));
    }

    @Override
    @Transactional
    public int insertAll(List<T> list) {
        return getMapper().insertList(list);
    }

    @Override
    @Transactional
    public int update(T t) {
        return getMapper().updateByPrimaryKey(t);
    }

    @Override
    @Transactional
    public int updateSelecttive(T t) {
        return getMapper().updateByPrimaryKeySelective(t);
    }

    @Override
    @Transactional
    public int delete(Serializable id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int delete(Serializable[] ids) {
        return delete(Arrays.asList(ids));
    }

    @Override
    @Transactional
    public int delete(Collection<Serializable> ids) {
        return ids.stream().map(getMapper()::deleteByPrimaryKey).reduce(Integer::sum).orElse(0);
    }

    @Override
    public T findById(Serializable id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<T> findAll(IPage page) {
        PageHelper.startPage(page);
        return PageInfo.of(getMapper().selectAll());
    }

    @Override
    public PageInfo<T> findAll(T t, IPage page) {
        PageHelper.startPage(page);
        return PageInfo.of(getMapper().select(t));
    }


    @Override
    public List<T> findAll() {
        return getMapper().selectAll();
    }

    @Override
    public List<T> findAll(T t) {
        return getMapper().select(t);
    }
}

