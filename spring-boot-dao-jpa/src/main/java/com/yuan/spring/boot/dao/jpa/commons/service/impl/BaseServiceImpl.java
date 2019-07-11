package com.yuan.spring.boot.dao.jpa.commons.service.impl;

import com.yuan.spring.boot.dao.jpa.commons.dao.BaseDao;
import com.yuan.spring.boot.dao.jpa.commons.entity.po.BasePo;
import com.yuan.spring.boot.dao.jpa.commons.service.BaseSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/

@Slf4j
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BasePo<ID>, ID extends Serializable, S extends BaseDao<T, ID>> implements BaseSerivce<T, ID> {
    public abstract S getBaseDao();

    protected boolean isNotEmpty(Object object) {
        return !StringUtils.isEmpty(object);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(T t) {
        checkSave(t);
        getBaseDao().save(t);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(T[] ts) {
        log.info("执行批量保存方法");
        saveAll(Arrays.asList(ts));
    }


    @SuppressWarnings("InfiniteRecursion")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(Collection<T> collection) {
        log.info("执行批量保存方法");
        collection.forEach(this::checkSave);
        collection = collection.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        saveAll(collection);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID id) {
        log.info("删除ID为" + id + "数据");
        getBaseDao().deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID[] ids) {
        delete(Arrays.asList(ids));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Collection<ID> collection) {
        getBaseDao().findAllById(collection).forEach(getBaseDao()::delete);
    }

    @Override
    public Optional<T> findById(ID id) {
        return getBaseDao().findById(id);
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return findAllById(Arrays.asList(ids));
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return getBaseDao().findAllById(collection);
    }

    @Override
    public Optional<T> findOne(T t) {
        return getBaseDao().findOne(Example.of(t));
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

    private T setCommonsParameters(T t) {
        t.setCreateDate(new Date());
        t.setUpdateDate(new Date());
        t.setCreateUser("");
        t.setUpdateUser("");
        return t;
    }

    protected boolean isNew(T t) {
        return findById(t.getId()).isPresent();
    }


}
