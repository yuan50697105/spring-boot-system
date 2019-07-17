package com.yuan.spring.boot.dao.nutz.service.impl;

import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.dao.nutz.dao.NutzDao;
import com.yuan.spring.boot.dao.nutz.entity.domain.NutzDomain;
import com.yuan.spring.boot.dao.nutz.service.NutzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author yuane
 * @date 2019/7/18 0:23
 **/

public abstract class NutzServiceImpl<S extends NutzDao<T, ID>, T extends NutzDomain<ID>, ID extends Serializable> implements NutzService<T, ID> {
    @Autowired
    protected S baseDao;

    protected S getBaseDao() {
        return baseDao;
    }

    protected boolean isNew(T t) {
        return baseDao.isNew(t);
    }

    protected abstract T setId(T t);

    protected abstract T setCommonsParams(T t);

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
    public ServiceResult save(T t) {
        setId(t);
        setCommonsParams(t);
        baseDao.save(t);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult saveBatch(T[] arrays) {
        return saveBatch(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult saveBatch(Collection<T> collection) {
        collection.forEach(this::save);
        return ServiceResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult update(T t) {
        setCommonsParams(t);
        baseDao.update(t);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult updateBatch(Collection<T> collection) {
        collection.forEach(this::update);
        return ServiceResultUtils.ok();
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
    public ServiceResult deleteById(ID id) {
        baseDao.deleteById(id);
        return ServiceResultUtils.ok();
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
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult delete(T t) {
        baseDao.delete(t);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult delete(T[] arrays) {
        return delete(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult delete(Collection<T> collection) {
        collection.forEach(this::delete);
        return ServiceResultUtils.ok();
    }

    @Override
    public T get(ID id) {
        return baseDao.get(id);
    }
}
