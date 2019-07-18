package com.yuan.spring.boot.dao.mybatis.mapper.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.dao.mybatis.mapper.dao.MapperDao;
import com.yuan.spring.boot.dao.mybatis.mapper.entity.domain.MapperDomain;
import com.yuan.spring.boot.dao.mybatis.mapper.service.MapperService;
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
 * @date 2019/6/15 23:10
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class MapperServiceImpl<S extends MapperDao<T, ID>, T extends MapperDomain<ID>, ID extends Serializable> implements MapperService<T, ID> {
    @Autowired
    protected S baseDao;

    public S getBaseDao() {
        return baseDao;
    }

    protected abstract T setId(T t);

    protected abstract T setCommonsParameters(T t);

    protected boolean isNew(T t) {
        return ObjectUtil.isEmpty(t.getId()) && get(t.getId()) == null;
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
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
    @Transactional(rollbackFor = Exception.class)
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
        return baseSaveBatch(Arrays.asList(arrays));
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveBatch(T[] arrays) {
        return saveBatch(Arrays.asList(arrays));
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
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
    public ServiceResult checkUpdate(T t) throws CheckNotPassException {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult deleteById(ID id) {
        ServiceResult serviceResult = checkDelete(get(id));
        ServiceResult.Status status = serviceResult.getStatus();
        if (status.equals(ServiceResult.Status.OK)) {
            getBaseDao().deleteByPrimaryKey(id);
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
    public ServiceResult checkDelete(T t) throws CheckNotPassException {
        return null;
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
        return getBaseDao().selectByPrimaryKey(id);
    }

    @Override
    public T findOne(T t) {
        return getBaseDao().selectOne(t);
    }


    @Override
    public PageInfo<T> findAll(IPage page) {
        PageHelper.startPage(page);
        return PageInfo.of(getBaseDao().selectAll());
    }

    @Override
    public PageInfo<T> findAll(T t, IPage page) {
        PageHelper.startPage(page);
        return PageInfo.of(getBaseDao().select(t));
    }

    @Override
    public List<T> findAll() {
        return getBaseDao().selectAll();
    }

    @Override
    public List<T> findAll(T t) {
        return getBaseDao().select(t);
    }

    @Override
    public ServiceResult baseSave(T t) {
        setId(t);
        setCommonsParameters(t);
        baseDao.insert(t);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult baseUpdate(T t) {
        T db = baseDao.selectByPrimaryKey(t.getId());
        if (db != null) {
            db.copyFrom(t);
            setCommonsParameters(db);
            baseDao.updateByPrimaryKey(db);
        }
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
    public ServiceResult baseSaveBatch(Collection<T> collection) {
        collection.forEach(this::baseSave);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult baseUpdateBatch(Collection<T> collection) {
        collection.forEach(this::baseUpdate);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult baseSaveOrUpdateBatch(Collection<T> collection) {
        collection.forEach(this::baseSaveOrUpdate);
        return ServiceResultUtils.ok();
    }

}

