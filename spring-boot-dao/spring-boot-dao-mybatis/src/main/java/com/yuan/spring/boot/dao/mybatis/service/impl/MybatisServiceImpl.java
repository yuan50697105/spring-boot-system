package com.yuan.spring.boot.dao.mybatis.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.DtoResult;
import com.yuan.spring.boot.dao.commons.utils.DtoResultUtils;
import com.yuan.spring.boot.dao.mybatis.dao.MybatisDao;
import com.yuan.spring.boot.dao.mybatis.entity.domain.MybatisDomain;
import com.yuan.spring.boot.dao.mybatis.service.MybatisService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/10 21:48
 **/

@Transactional(rollbackFor = Exception.class)
public abstract class MybatisServiceImpl<T extends MybatisDomain<ID>, ID extends Serializable, S extends MybatisDao<T, ID>> implements MybatisService<T, ID> {
    protected abstract S getBaseDao();

    protected abstract T setCommonsParameters(T entity);

    protected boolean isNew(T t) {
        return StringUtils.isEmpty(t.getId()) && !getBaseDao().findById(t.getId()).isPresent();
    }

    @Override
    public DtoResult saveOrUpdate(T t) {
        getBaseDao().save(t);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    public DtoResult saveOrUpdateBatch(Collection<T> collection) {
        getBaseDao().saveAll(collection);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult save(T t) {
        getBaseDao().insert(t);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult saveBatch(T[] arrays) {
        return saveBatch(Arrays.asList(arrays));
    }

    @Override
    public DtoResult saveBatch(Collection<T> collection) {
        collection.forEach(getBaseDao()::insert);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult update(T t) {
        getBaseDao().updateIgnoreNull(t);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @Override
    public DtoResult updateBatch(Collection<T> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(getBaseDao()::updateIgnoreNull);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult deleteById(ID id) {
        getBaseDao().deleteById(id);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult deleteById(ID[] ids) {
        return null;
    }

    @Override
    public DtoResult deleteById(Collection<ID> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(getBaseDao()::deleteById);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult delete(T t) {
        getBaseDao().delete(t);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult delete(T[] arrays) {
        return delete(Arrays.asList(arrays));
    }

    @Override
    public DtoResult delete(Collection<T> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(getBaseDao()::delete);
        return DtoResultUtils.ok();
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
    public List<T> findAllById(Collection<ID> iterable) {
        return getBaseDao().findAllById(iterable);
    }


}

