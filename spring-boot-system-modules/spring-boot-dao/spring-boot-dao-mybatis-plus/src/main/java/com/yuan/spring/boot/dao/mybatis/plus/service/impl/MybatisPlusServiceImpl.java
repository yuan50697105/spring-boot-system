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
        String code = serviceResult.getCode();
        if ("ok".equals(code)) {
            setId(t);
            setCommonsParameters(t);
            getBaseDao().insert(t);
            return ServiceResultUtils.ok();
        } else {
            return serviceResult;
        }
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
    public ServiceResult update(T t) {
        ServiceResult serviceResult = checkUpdate(t);
        String code = serviceResult.getCode();
        if ("ok".equals(code)) {
            T db = getBaseDao().selectById(t.getId());
            db.copyFrom(t);
            setCommonsParameters(db);
            getBaseDao().updateById(db);
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
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(this::saveOrUpdate);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult deleteById(ID id) {
        ServiceResult serviceResult = checkDelete(get(id));
        String code = serviceResult.getCode();
        if ("ok".equals(code)) {
            checkDelete(get(id));
            getBaseDao().deleteById(id);
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
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(this::deleteById);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult delete(T t) {
        ServiceResult serviceResult = checkDelete(t);
        String code = serviceResult.getCode();
        if ("ok".equals(code)) {
            checkDelete(t);
            getBaseDao().deleteByMap(t.toParamsMap());
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
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(this::delete);
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
}
