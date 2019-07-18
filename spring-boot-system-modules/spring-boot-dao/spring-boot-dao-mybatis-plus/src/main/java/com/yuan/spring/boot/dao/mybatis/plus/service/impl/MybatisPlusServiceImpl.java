package com.yuan.spring.boot.dao.mybatis.plus.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.dao.mybatis.plus.dao.MybatisPlusDao;
import com.yuan.spring.boot.dao.mybatis.plus.entity.domain.MybatisPlusDomain;
import com.yuan.spring.boot.dao.mybatis.plus.service.MybatisPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author yuane
 * @date 2019/6/15 23:30
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class MybatisPlusServiceImpl<M extends MybatisPlusDao<T, ID>, T extends MybatisPlusDomain<ID>, ID extends Serializable> implements MybatisPlusService<T, ID> {

    @Autowired
    protected M baseDao;

    protected M getBaseDao() {
        return baseDao;
    }

    protected abstract T setId(T t);

    protected abstract T setCommonsParameters(T entity);

    protected boolean isNew(T t) {
        return ObjectUtil.isEmpty(t.getId()) && getBaseDao().selectById(t.getId()) == null;
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
    public ServiceResult save(T t) {
        ServiceResult serviceResult = checkSave(t);
        if (serviceResult.getStatus().equals(ServiceResult.Status.OK)) {
            return baseSave(t);
        } else {
            return serviceResult;
        }
    }

    @Override
    public ServiceResult baseSaveBatch(T[] arrays) {
        return null;
    }

    @Override
    public ServiceResult saveBatch(T[] arrays) {
        return saveBatch(Arrays.asList(arrays));
    }


    @SuppressWarnings("Duplicates")
    @Override
    public ServiceResult saveBatch(Collection<T> collection) {
        boolean isSave = true;
        StringJoiner stringJoiner = new StringJoiner(",");
        List<ServiceResult> collect = collection.stream().map(this::checkSave).collect(Collectors.toList());
        int i = 0;
        for (ServiceResult serviceResult : collect) {
            ServiceResult.Status status = serviceResult.getStatus();
            String message = serviceResult.getMessage();
            message = message.substring(0, message.lastIndexOf(","));
            if (!status.equals(ServiceResult.Status.OK)) {
                isSave = false;
                stringJoiner.add(String.format("第%d行" + message, ++i));
            }
        }
        if (isSave) {
            return baseSaveBatch(collection);
        } else {
            return ServiceResultUtils.failure(stringJoiner.toString());
        }
    }

    @Override
    public ServiceResult update(T t) {
        ServiceResult serviceResult = checkUpdate(t);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            return baseUpdate(t);
        } else {
            return serviceResult;
        }
    }

    @Override
    public ServiceResult baseUpdateBatch(T[] arrays) {
        return baseUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @SuppressWarnings("Duplicates")
    @Override
    public ServiceResult updateBatch(Collection<T> collection) {
        List<ServiceResult> collect = collection.stream().map(this::checkUpdate).collect(Collectors.toList());
        int i = 0;
        boolean isUpdate = true;
        StringJoiner stringJoiner = new StringJoiner(",");
        for (ServiceResult serviceResult : collect) {
            ServiceResult.Status status = serviceResult.getStatus();
            String message = serviceResult.getMessage();
            message = message.substring(0, message.lastIndexOf(","));
            if (!status.equals(ServiceResult.Status.OK)) {
                isUpdate = false;
                stringJoiner.add(String.format("第%d行" + message, ++i));
            }
        }
        if (isUpdate) {
            return baseUpdateBatch(collection);
        } else {
            return ServiceResultUtils.failure(stringJoiner.toString());
        }
    }

    @Override
    public ServiceResult saveOrUpdate(T t) {
        ServiceResult serviceResult = checkSaveOrUpdate(t);
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            return baseSaveOrUpdate(t);
        } else {
            return serviceResult;
        }
    }

    @Override
    public ServiceResult baseSaveOrUpdateBatch(T[] arrays) {
        return baseSaveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult saveOrUpdateBatch(Collection<T> collection) {
        int i = 0;
        boolean isSave = true;
        StringJoiner joiner = new StringJoiner(",");
        List<ServiceResult> collect = collection.stream().map(this::checkSaveOrUpdate).collect(Collectors.toList());
        for (ServiceResult serviceResult : collect) {
            ServiceResult.Status status = serviceResult.getStatus();
            String message = serviceResult.getMessage();
            message = message.substring(0, message.lastIndexOf(","));
            if (!status.equals(ServiceResult.Status.OK)) {
                isSave = false;
                joiner.add("第" + (++i) + "行" + message);
            }
        }
        if (isSave) {
            return baseSaveOrUpdateBatch(collection);
        } else {
            return ServiceResultUtils.failure(joiner.toString());
        }
    }


    @Override
    public ServiceResult baseSaveOrUpdateBatch(Collection<T> collection) {
        collection.forEach(this::baseSaveOrUpdate);
        return ServiceResultUtils.ok();
    }

    @Override
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
    public ServiceResult delete(T t) {
        baseDao.deleteByMap(t.toParamsMap());
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
        return getBaseDao().selectById(id);
    }

    @Override
    public List<T> findAll() {
        return baseDao.selectList(null);
    }

    @Override
    public List<T> findAll(T t) {
        return baseDao.selectList(new QueryWrapper<>(t));
    }

    @Override
    public IPage<T> findAll(IPage<T> page) {
        return baseDao.selectPage(page, null);
    }

    @Override
    public IPage<T> findAll(T t, IPage<T> page) {
        return baseDao.selectPage(page, new QueryWrapper<>(t));
    }

    @Override
    public ServiceResult baseSave(T t) {
        setId(t);
        setCommonsParameters(t);
        getBaseDao().insert(t);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult baseSaveBatch(Collection<T> collection) {
        collection.forEach(this::baseSave);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult baseUpdate(T t) {
        T db = getBaseDao().selectById(t.getId());
        db.copyFrom(t);
        setCommonsParameters(db);
        getBaseDao().updateById(db);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult baseSaveOrUpdate(T t) {
        if (isNew(t)) {
            return baseSave(t);
        } else {
            return baseUpdate(t);
        }
    }

    @Override
    public ServiceResult baseUpdateBatch(Collection<T> collection) {
        collection.forEach(this::update);
        return ServiceResultUtils.ok();
    }
}
