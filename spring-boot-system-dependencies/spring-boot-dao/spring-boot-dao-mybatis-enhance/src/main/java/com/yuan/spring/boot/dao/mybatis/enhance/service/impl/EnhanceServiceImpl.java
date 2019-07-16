package com.yuan.spring.boot.dao.mybatis.enhance.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.gitee.hengboy.mybatis.pageable.Page;
import com.gitee.hengboy.mybatis.pageable.request.Pageable;
import com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.dao.mybatis.enhance.dao.BaseDao;
import com.yuan.spring.boot.dao.mybatis.enhance.entity.domain.EnhanceDomain;
import com.yuan.spring.boot.dao.mybatis.enhance.service.EnhanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(rollbackFor = Exception.class)
public abstract class EnhanceServiceImpl<S extends BaseDao<T, ID>, T extends EnhanceDomain<ID>, ID extends Serializable> implements EnhanceService<T, ID> {
    @Autowired
    protected S baseDao;

    protected S getBaseDao() {
        return baseDao;
    }

    protected abstract T setId(T t);

    protected abstract T setCommonsParmas(T t);

    protected boolean isNew(T t) {
        return ObjectUtil.isEmpty(t.getId()) && getBaseDao().selectOne(t.getId()) == null;
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
    public ServiceResult saveOrUpdate(T t) {
        if (isNew(t)) {
            return save(t);
        } else {
            return update(t);
        }
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
    public ServiceResult save(T t) {
        ServiceResult serviceResult = checkSave(t);
        String code = serviceResult.getCode();
        if ("ok".equals(code)) {
            setId(t);
            setCommonsParmas(t);
            getBaseDao().insert(t);
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
    }

    @Override
    public ServiceResult saveBatch(T[] arrays) {
        getBaseDao().insertArray(arrays);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult saveBatch(Collection<T> collection) {
        collection.forEach(this::save);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult update(T t) {
        ServiceResult serviceResult = checkUpdate(t);
        String code = serviceResult.getCode();
        if ("ok".equals(code)) {
            T db = get(t.getId());
            db.copyFrom(t);
            getBaseDao().update(db);
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
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
        ServiceResult serviceResult = checkDelete(get(id));
        String code = serviceResult.getCode();
        if ("ok".equals(code)) {
            getBaseDao().deleteOne(id);
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
    }

    @Override
    public ServiceResult deleteById(ID[] ids) {
        getBaseDao().deleteArray(ids);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult deleteById(Collection<ID> collection) {
        getBaseDao().deleteCollection(collection);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult delete(T t) {
        ServiceResult serviceResult = checkDelete(t);
        String code = serviceResult.getCode();
        if ("ok".equals(code)) {
            getBaseDao().deleteOne(t.getId());
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
    }

    @Override
    public ServiceResult delete(T[] arrays) {
        return delete(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult delete(Collection<T> collection) {
        getBaseDao().deleteCollection(collection.stream().map(BaseDomain::getId).collect(Collectors.toList()));
        return ServiceResultUtils.ok();
    }

    @Override
    public T get(ID id) {
        return getBaseDao().selectOne(id);
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return getBaseDao().selectArray(ids);
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return getBaseDao().selectCollection(collection);
    }

    @Override
    public List<T> findAll() {
        return getBaseDao().selectAll();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return pageable.request(this::findAll);
    }
}

