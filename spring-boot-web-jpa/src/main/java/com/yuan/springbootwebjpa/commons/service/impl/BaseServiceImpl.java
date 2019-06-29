package com.yuan.springbootwebjpa.commons.service.impl;

import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import com.yuan.springbootwebjpa.commons.service.BaseSerivce;
import org.springframework.beans.factory.annotation.Autowired;
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

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BasePo, ID extends Serializable, S extends BaseRepository<T, ID>> implements BaseSerivce<T, ID> {
    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private S baseRepository;

    protected S getRepository() {
        return baseRepository;
    }

    protected boolean isNotEmpty(Object object) {
        return !StringUtils.isEmpty(object);
    }

    protected abstract void beforeSave(T t) throws RuntimeException;

    protected abstract void beforeInsert(T t) throws RuntimeException;

    protected abstract void beforeUpdate(T t) throws RuntimeException;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(T t) {
        beforeSave(t);
        getRepository().save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(T t) {
        beforeInsert(t);
        getRepository().persist(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertAll(T[] arrays) {
        insertAll(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertAll(Collection<T> collection) {
        collection.forEach(this::beforeInsert);
        collection.stream().map(this::setCommonsParameters).forEach(this::insert);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(T t) {
        beforeUpdate(t);
        getRepository().refresh(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAll(T[] arrays) {
        updateAll(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAll(Collection<T> collection) {
        collection.forEach(this::beforeUpdate);
        collection.stream().map(this::setCommonsParameters).forEach(this::update);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(T[] ts) {
        saveAll(Arrays.asList(ts));
    }


    @SuppressWarnings("InfiniteRecursion")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(Collection<T> collection) {
        collection.forEach(this::beforeSave);
        collection = collection.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        saveAll(collection);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID[] ids) {
        delete(Arrays.asList(ids));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Collection<ID> collection) {
        getRepository().findAllById(collection).forEach(getRepository()::delete);
    }

    @Override
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return findAllById(Arrays.asList(ids));
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return getRepository().findAllById(collection);
    }

    @Override
    public Optional<T> findOne(T t) {
        return getRepository().findOne(Example.of(t));
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<T> findAll(T t) {
        return getRepository().findAll(Example.of(t));
    }

    @Override
    public List<T> findAll(T t, Sort sort) {
        return getRepository().findAll(Example.of(t), sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public Page<T> findAll(T t, Pageable pageable) {
        return getRepository().findAll(Example.of(t), pageable);
    }

    private T setCommonsParameters(T t) {
        t.setCreateDate(new Date());
        t.setUpdateDate(new Date());
        t.setCreateUser("");
        t.setUpdateUser("");
        return t;
    }

}
