package com.yuan.spring.boot.dao.mybatis.enhance.commons.service.impl;

import com.gitee.hengboy.mybatis.pageable.Page;
import com.gitee.hengboy.mybatis.pageable.request.Pageable;
import com.yuan.spring.boot.dao.mybatis.enhance.commons.entity.po.BasePo;
import com.yuan.spring.boot.dao.mybatis.enhance.commons.mapper.BaseMapper;
import com.yuan.spring.boot.dao.mybatis.enhance.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BasePo, ID extends Serializable, S extends BaseMapper<T, ID>> implements BaseService<T, ID> {
    protected abstract S getBaseMapper();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(T t) {
        checkInsert(t);
        setCommonsParmas(t);
        getBaseMapper().insert(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertAll(T[] arrays) {
        Arrays.stream(arrays).forEach(this::checkInsert);
        List<T> collect = Arrays.stream(arrays).map(this::setCommonsParmas).collect(Collectors.toList());
        getBaseMapper().insertCollection(collect);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertAll(Collection<T> collection) {
        collection.forEach(this::checkInsert);
        collection = collection.stream().map(this::setCommonsParmas).collect(Collectors.toList());
        getBaseMapper().insertCollection(collection);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(T t) {
        checkUpdate(t);
        setCommonsParmas(t);
        getBaseMapper().update(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID id) {
        getBaseMapper().deleteOne(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID[] ids) {
        getBaseMapper().deleteArray(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Collection<ID> collection) {
        getBaseMapper().deleteCollection(collection);
    }

    @Override
    public T getById(ID id) {
        return getBaseMapper().selectOne(id);
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return getBaseMapper().selectArray(ids);
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return getBaseMapper().selectCollection(collection);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return pageable.request(getBaseMapper()::selectAll);
    }

    @Override
    public List<T> findAll() {
        return getBaseMapper().selectAll();
    }

    private T setCommonsParmas(T t) {
        t.setCreateDate(new Date());
        t.setUpdateDate(new Date());
        t.setCreateUser("");
        t.setUpdateUser("");
        return t;
    }
}
