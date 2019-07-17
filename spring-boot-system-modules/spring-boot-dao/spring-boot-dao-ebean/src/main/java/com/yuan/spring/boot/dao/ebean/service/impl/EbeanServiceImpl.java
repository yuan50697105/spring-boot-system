package com.yuan.spring.boot.dao.ebean.service.impl;

import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.dao.ebean.dao.EbeanDao;
import com.yuan.spring.boot.dao.ebean.entity.domain.EbeanDomain;
import com.yuan.spring.boot.dao.ebean.service.EbeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.ebean.querychannel.EbeanQueryChannelService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/13 12:37
 **/
public abstract class EbeanServiceImpl<S extends EbeanDao<T, ID>, T extends EbeanDomain<ID>, ID extends Serializable> extends EbeanQueryChannelService implements EbeanService<T, ID> {
    @Autowired
    protected S baseDao;

    protected S getBaseDao() {
        return baseDao;
    }

    protected abstract T setCommonsParams(T t);

    protected abstract T setId(T t);

    protected boolean isNew(T t) {
        return StringUtils.isEmpty(t.getId()) && !getBaseDao().findById(t.getId()).isPresent();
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
        setId(t);
        setCommonsParams(t);
        getBaseDao().save(t);
        return ServiceResultUtils.ok();
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
        T db = getBaseDao().findById(t.getId()).orElse(null);
        if (db != null) {
            db.copyFrom(t);
            setCommonsParams(db);
            getBaseDao().save(db);
        }
        return ServiceResultUtils.ok();
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
        getBaseDao().deleteById(id);
        return ServiceResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult deleteById(ID[] ids) {
        Arrays.stream(ids).forEach(this::deleteById);
        return ServiceResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult deleteById(Collection<ID> collection) {
        collection.forEach(this::deleteById);
        return ServiceResultUtils.ok();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult delete(T t) {
        getBaseDao().delete(t);
        return ServiceResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult delete(T[] arrays) {
        Arrays.stream(arrays).forEach(this::delete);
        return ServiceResultUtils.ok();
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
        return getBaseDao().findAllById(Arrays.asList(ids));
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
    public List<T> findAll(Sort sort) {
        return getBaseDao().findAll(sort);
    }

    @Override
    public List<T> findAll(T t) {
        return getBaseDao().findAll(Example.of(t, ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)));
    }

    @Override
    public List<T> findAll(T t, Sort sort) {
        return getBaseDao().findAll(Example.of(t, ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)), sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getBaseDao().findAll(pageable);
    }

    @Override
    public Page<T> findAll(T t, Pageable pageable) {
        return getBaseDao().findAll(Example.of(t, ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)), pageable);
    }
}
