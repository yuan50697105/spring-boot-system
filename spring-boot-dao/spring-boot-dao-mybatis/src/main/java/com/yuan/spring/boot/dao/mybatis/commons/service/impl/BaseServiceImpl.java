package com.yuan.spring.boot.dao.mybatis.commons.service.impl;

import com.yuan.spring.boot.dao.mybatis.commons.dao.BaseDao;
import com.yuan.spring.boot.dao.mybatis.commons.entity.po.BasePo;
import com.yuan.spring.boot.dao.mybatis.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yuane
 * @date 2019/7/10 21:48
 **/

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BasePo<ID>, ID extends Serializable, S extends BaseDao<T, ID>> implements BaseService<T, ID> {
    protected abstract S getBaseDao();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(T t) {
        setCommonsParameters(t);
        getBaseDao().save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveIgnoreNull(T t) {
        setCommonsParameters(t);
        getBaseDao().saveIgnoreNull(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(T[] arrays) {
        List<T> collect = Arrays.stream(arrays).map(this::setCommonsParameters).collect(Collectors.toList());
        getBaseDao().saveAll(collect);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        for (T t : iterable) {
            list.add(setCommonsParameters(t));
        }
        getBaseDao().saveAll(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(T t) {
        getBaseDao().insert(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(T t) {
        getBaseDao().update(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateIgnoreNull(T t) {
        getBaseDao().updateIgnoreNull(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID id) {
        getBaseDao().deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID[] ids) {
        getBaseDao().findAllById(Arrays.asList(ids)).forEach(getBaseDao()::delete);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Iterable<ID> iterable) {
        getBaseDao().findAllById(iterable).forEach(getBaseDao()::delete);
    }

    @Override
    public Optional<T> findById(ID id) {
        return getBaseDao().findById(id);
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return getBaseDao().findAllById(Arrays.asList(ids));
    }

    @Override
    public List<T> findAllById(Iterable<ID> iterable) {
        return getBaseDao().findAllById(iterable);
    }

    protected boolean isNew(T t) {
        return StringUtils.isEmpty(t.getId()) && !findById(t.getId()).isPresent();
    }

    protected T setCommonsParameters(T entity) {
        entity.setCreateDate(new Date());
        entity.setUpdateDate(new Date());
        entity.setCreateUser("");
        entity.setUpdateUser("");
        return entity;
    }
}

