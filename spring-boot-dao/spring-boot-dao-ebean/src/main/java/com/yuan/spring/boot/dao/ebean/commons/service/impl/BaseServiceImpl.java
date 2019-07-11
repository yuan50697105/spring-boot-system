package com.yuan.spring.boot.dao.ebean.commons.service.impl;

import com.yuan.spring.boot.dao.ebean.commons.dao.BaseDao;
import com.yuan.spring.boot.dao.ebean.commons.entity.po.BasePo;
import com.yuan.spring.boot.dao.ebean.commons.service.BaseService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.ebean.querychannel.EbeanQueryChannelService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BasePo<ID>, ID, S extends BaseDao<T, ID>> extends EbeanQueryChannelService implements BaseService<T, ID> {
    protected abstract S getBaseDao();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(T t) {
        setCommonsParameters(t);
        getBaseDao().save(t);
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
    public Optional<T> findOne(T t) {
        return getBaseDao().findOne(Example.of(t));
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return getBaseDao().findAllById(Arrays.asList(ids));
    }

    @Override
    public List<T> findAll() {
        return getBaseDao().findAll();
    }

    @Override
    public List<T> findAll(T t) {
        return getBaseDao().findAll(Example.of(t));
    }

    @Override
    public List<T> findAll(T t, Sort sort) {
        return getBaseDao().findAll(Example.of(t), sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getBaseDao().findAll(pageable);
    }

    @Override
    public Page<T> findAll(T t, Pageable pageable) {
        return getBaseDao().findAll(Example.of(t), pageable);
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
