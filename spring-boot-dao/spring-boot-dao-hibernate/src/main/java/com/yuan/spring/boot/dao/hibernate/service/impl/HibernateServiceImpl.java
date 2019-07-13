package com.yuan.spring.boot.dao.hibernate.service.impl;

import com.yuan.spring.boot.dao.commons.entity.dto.DtoResult;
import com.yuan.spring.boot.dao.commons.utils.DtoResultUtils;
import com.yuan.spring.boot.dao.hibernate.dao.HibernateDao;
import com.yuan.spring.boot.dao.hibernate.entity.domain.HibernateDomain;
import com.yuan.spring.boot.dao.hibernate.service.HibernateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/

@Slf4j
@Transactional(rollbackFor = Exception.class)
public abstract class HibernateServiceImpl<T extends HibernateDomain<ID>, ID extends Serializable, S extends HibernateDao<T, ID>> implements HibernateService<T, ID> {
    public abstract S getBaseDao();

    protected boolean isNotEmpty(Object object) {
        return !StringUtils.isEmpty(object);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult saveOrUpdate(T t) {
        getBaseDao().save(t);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult saveOrUpdateBatch(Collection<T> collection) {
        getBaseDao().saveAll(collection);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult save(T t) {
        getBaseDao().save(t);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult saveBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult saveBatch(Collection<T> collection) {
        getBaseDao().saveAll(collection);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult update(T t) {
        getBaseDao().save(t);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult updateBatch(Collection<T> collection) {
        getBaseDao().saveAll(collection);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult deleteById(ID id) {
        getBaseDao().deleteById(id);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult delete(T t) {
        getBaseDao().delete(t);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult deleteById(ID[] ids) {
        return deleteById(Arrays.asList(ids));
    }

    @Override
    public DtoResult deleteById(Collection<ID> collection) {
        collection.forEach(this::deleteById);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult delete(T[] arrays) {
        return delete(Arrays.asList(arrays));
    }

    @Override
    public DtoResult delete(Collection<T> collection) {
        collection.forEach(this::delete);
        return DtoResultUtils.ok();
    }

    @Override
    public T get(ID id) {
        return getBaseDao().findById(id).orElse(null);
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
    public T findOne(T t) {
        return getBaseDao().findOne(Example.of(t)).orElse(null);
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

    protected abstract T setCommonsParameters(T t);

    protected boolean isNew(T t) {
        return StringUtils.isEmpty(t.getId()) && !getBaseDao().findById(t.getId()).isPresent();
    }


}
