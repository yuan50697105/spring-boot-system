package com.yuan.spring.boot.dao.hibernate.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.dao.hibernate.dao.HibernateDao;
import com.yuan.spring.boot.dao.hibernate.entity.domain.HibernateDomain;
import com.yuan.spring.boot.dao.hibernate.service.HibernateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public abstract class HibernateServiceImpl<S extends HibernateDao<T, ID>, T extends HibernateDomain<ID>, ID extends Serializable> implements HibernateService<T, ID> {
    @Autowired
    protected S baseDao;

    public S getBaseDao() {
        return baseDao;
    }

    protected abstract T setCommonsParameters(T t);

    protected abstract T setId(T t);

    protected boolean isNew(T t) {
        return StringUtils.isEmpty(t.getId()) && !getBaseDao().findById(t.getId()).isPresent();
    }

    protected boolean isNotEmpty(Object object) {
        return ObjectUtil.isNotEmpty(object);
    }

    @Override
    public ServiceResult checkSaveOrUpdate(T t) throws CheckNotPassException {
        if (isNew(t)) {
            return checkSave(t);
        } else {
            return checkUpdate(t);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveOrUpdate(T t) {
        if (isNew(t)) {
            return save(t);
        } else {
            return update(t);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveOrUpdateBatch(Collection<T> collection) {
        collection.forEach(this::saveOrUpdate);
        return ServiceResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult save(T t) {
        ServiceResult serviceResult = checkSave(t);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            setId(t);
            setCommonsParameters(t);
            getBaseDao().save(t);
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveBatch(T[] arrays) {
        return saveBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveBatch(Collection<T> collection) {
        collection.forEach(this::save);
        return ServiceResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult update(T t) {
        ServiceResult serviceResult = checkUpdate(t);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            setCommonsParameters(t);
            T db = getBaseDao().findById(t.getId()).orElse(null);
            if (db != null) {
                db.copyFrom(t);
                getBaseDao().save(db);
            }
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult updateBatch(Collection<T> collection) {
        collection.forEach(this::update);
        return ServiceResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult deleteById(ID id) {
        ServiceResult serviceResult = checkDelete(get(id));
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            getBaseDao().deleteById(id);
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult delete(T t) {
        ServiceResult serviceResult = checkDelete(t);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            getBaseDao().delete(t);
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
    }

    @Override
    public ServiceResult deleteById(ID[] ids) {
        return deleteById(Arrays.asList(ids));
    }

    @Override
    public ServiceResult deleteById(Collection<ID> collection) {
        collection.forEach(this::deleteById);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult delete(T[] arrays) {
        return delete(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult delete(Collection<T> collection) {
        collection.forEach(this::delete);
        return ServiceResultUtils.ok();
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


}
