package com.yuan.spring.boot.dao.mybatis.enhance.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.gitee.hengboy.mybatis.pageable.Page;
import com.gitee.hengboy.mybatis.pageable.request.Pageable;
import com.yuan.spring.boot.dao.commons.entity.domain.BaseDomain;
import com.yuan.spring.boot.dao.commons.entity.dto.DtoResult;
import com.yuan.spring.boot.dao.commons.utils.DtoResultUtils;
import com.yuan.spring.boot.dao.mybatis.enhance.dao.BaseDao;
import com.yuan.spring.boot.dao.mybatis.enhance.entity.domain.EnhanceDomain;
import com.yuan.spring.boot.dao.mybatis.enhance.service.EnhanceService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(rollbackFor = Exception.class)
public abstract class EnhanceServiceImpl<T extends EnhanceDomain<ID>, ID extends Serializable, S extends BaseDao<T, ID>> implements EnhanceService<T, ID> {
    protected abstract S getBaseDao();

    protected abstract T setCommonsParmas(T t);

    protected boolean isNew(T t) {
        return StringUtils.isEmpty(t.getId()) && getBaseDao().selectOne(t.getId()) == null;
    }

    @Override
    public DtoResult saveOrUpdate(T t) {
        if (isNew(t)) {
            save(t);
        } else {
            T db = get(t.getId());
            db.copyFrom(t);
            update(db);
        }
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    public DtoResult saveOrUpdateBatch(Collection<T> collection) {
        collection.forEach(this::saveOrUpdate);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult save(T t) {
        getBaseDao().insert(t);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult saveBatch(T[] arrays) {
        getBaseDao().insertArray(arrays);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult saveBatch(Collection<T> collection) {
        collection.forEach(this::save);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult update(T t) {
        T db = get(t.getId());
        db.copyFrom(t);
        getBaseDao().update(db);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @Override
    public DtoResult updateBatch(Collection<T> collection) {
        collection.forEach(this::update);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult deleteById(ID id) {
        getBaseDao().deleteOne(id);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult deleteById(ID[] ids) {
        getBaseDao().deleteArray(ids);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult deleteById(Collection<ID> collection) {
        getBaseDao().deleteCollection(collection);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult delete(T t) {
        getBaseDao().deleteOne(t.getId());
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult delete(T[] arrays) {
        return delete(Arrays.asList(arrays));
    }

    @Override
    public DtoResult delete(Collection<T> collection) {
        getBaseDao().deleteCollection(collection.stream().map(BaseDomain::getId).collect(Collectors.toList()));
        return DtoResultUtils.ok();
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

