package com.yuan.spring.boot.dao.jdbc.service.impl;

import com.xphsc.easyjdbc.core.entity.Sorts;
import com.xphsc.easyjdbc.page.PageInfo;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.dao.jdbc.dao.JdbcDao;
import com.yuan.spring.boot.dao.jdbc.entity.domain.JdbcDomain;
import com.yuan.spring.boot.dao.jdbc.service.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/13 22:42
 **/

public abstract class JdbcServiceImpl<S extends JdbcDao<T, ID>, T extends JdbcDomain<ID>, ID extends Serializable> implements JdbcService<T, ID> {
    @Autowired
    protected S baseDao;

    protected S getBaseDao() {
        return baseDao;
    }

    protected abstract T setId(T t);

    protected abstract T setCommonsParams(T t);

    protected boolean isNew(T t) {
        return StringUtils.isEmpty(t.getId()) && !getBaseDao().getById(t.getId()).isPresent();
    }

    @Override
    public ServiceResult saveOrUpdate(T t) {
        if (isNew(t)) {
            return save(t);
        } else {
            return update(t);
        }
    }

    @Override
    public ServiceResult save(T t) {
        setId(t);
        setCommonsParams(t);
        getBaseDao().insert(t);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult update(T t) {
        T db = getBaseDao().getById(t.getId()).orElse(null);
        if (db != null) {
            db.copyFrom(t);
            setCommonsParams(db);
            getBaseDao().update(db);
        }
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult saveOrUpdateBatch(Collection<T> collection) {
        collection.forEach(this::saveOrUpdate);
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
    public ServiceResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult updateBatch(Collection<T> collection) {
        collection.forEach(this::update);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult deleteById(ID id) {
        getBaseDao().deleteByPrimaryKey(id);
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
    public ServiceResult delete(T t) {
        getBaseDao().delete(t);
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
        return getBaseDao().getByPrimaryKey(id);
    }

    @Override
    public List<T> findAllById(ID[] arrays) {
        return findAllById(Arrays.asList(arrays));
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return getBaseDao().findByIds(collection);
    }

    @Override
    public List<T> findAll() {
        return getBaseDao().findAll();
    }

    @Override
    public List<T> findAll(Sorts sorts) {
        return getBaseDao().findAll(sorts);
    }

    @Override
    public PageInfo<T> findAll(PageInfo pageInfo) {
        return getBaseDao().findAll(pageInfo);
    }

    @Override
    public PageInfo<T> findAll(PageInfo pageInfo, Sorts sorts) {
        return getBaseDao().findAll(pageInfo, sorts);
    }
}
