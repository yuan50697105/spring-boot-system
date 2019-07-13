package com.yuan.spring.boot.dao.mybatis.plus.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.dao.mybatis.plus.dao.MybatisPlusDao;
import com.yuan.spring.boot.dao.mybatis.plus.entity.domain.MybatisPlusDomain;
import com.yuan.spring.boot.dao.mybatis.plus.service.MybatisPlusService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author yuane
 * @date 2019/6/15 23:30
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class MybatisPlusServiceImpl<M extends MybatisPlusDao<T, ID>, T extends MybatisPlusDomain<ID>, ID extends Serializable> implements MybatisPlusService<T, ID> {

    protected abstract M getBaseDao();

    protected abstract T setCommonsParameters(T entity);

    protected boolean isNew(T t) {
        return StringUtils.isEmpty(t.getId()) && getBaseDao().selectById(t.getId()) == null;
    }

    @Override
    public ServiceResult save(T t) {
        setCommonsParameters(t);
        getBaseDao().insert(t);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult saveBatch(T[] arrays) {
        return saveBatch(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult saveBatch(Collection<T> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(this::save);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult update(T t) {
        T db = getBaseDao().selectById(t.getId());
        db.copyFrom(t);
        setCommonsParameters(db);
        getBaseDao().updateById(db);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult updateBatch(Collection<T> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(this::update);
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
        getBaseDao().deleteById(id);
        return ServiceResultUtils.ok();
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
        getBaseDao().deleteByMap(t.toParamsMap());
        return ServiceResultUtils.ok();
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
}
