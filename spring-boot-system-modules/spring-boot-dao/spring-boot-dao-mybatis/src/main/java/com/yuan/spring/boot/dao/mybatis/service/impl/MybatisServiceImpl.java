package com.yuan.spring.boot.dao.mybatis.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.dao.mybatis.dao.MybatisDao;
import com.yuan.spring.boot.dao.mybatis.entity.domain.MybatisDomain;
import com.yuan.spring.boot.dao.mybatis.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/10 21:48
 **/

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Transactional(rollbackFor = Exception.class)
public abstract class MybatisServiceImpl<S extends MybatisDao<T, ID>, T extends MybatisDomain<ID>, ID extends Serializable> implements MybatisService<T, ID> {
    @Autowired
    protected S baseDao;

    protected S getBaseDao() {
        return baseDao;
    }

    protected abstract T setId(T t);

    protected abstract T setCommonsParameters(T entity);

    protected boolean isNew(T t) {
        return ObjectUtil.isEmpty(t.getId()) && !baseDao.findById(t.getId()).isPresent();
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
        setId(t);
        setCommonsParameters(t);
        baseDao.insert(t);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult saveBatch(T[] arrays) {
        return saveBatch(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult saveBatch(Collection<T> collection) {
        collection.forEach(getBaseDao()::insert);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult update(T t) {
        setCommonsParameters(t);
        baseDao.updateIgnoreNull(t);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult updateBatch(Collection<T> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(getBaseDao()::updateIgnoreNull);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult deleteById(ID id) {
        getBaseDao().deleteById(id);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult deleteById(ID[] ids) {
        return deleteById(Arrays.asList(ids));
    }

    @Override
    public ServiceResult deleteById(Collection<ID> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(getBaseDao()::deleteById);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult delete(T t) {
        baseDao.delete(t);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult delete(T[] arrays) {
        return delete(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult delete(Collection<T> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(getBaseDao()::delete);
        return ServiceResultUtils.ok();
    }

    @Override
    public T get(ID id) {
        return baseDao.findById(id).orElse(null);
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return findAllById(Arrays.asList(ids));
    }

    @Override
    public List<T> findAllById(Collection<ID> iterable) {
        return getBaseDao().findAllById(iterable);
    }


    @Override
    public List<T> findAll() {
        return baseDao.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return baseDao.findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return baseDao.findAll(pageable);
    }
}

