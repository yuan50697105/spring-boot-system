package com.yuan.spring.boot.dao.mybatis.plus.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.DtoResult;
import com.yuan.spring.boot.dao.commons.utils.DtoResultUtils;
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
    public DtoResult save(T t) {
        setCommonsParameters(t);
        getBaseDao().insert(t);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult saveBatch(T[] arrays) {
        return saveBatch(Arrays.asList(arrays));
    }

    @Override
    public DtoResult saveBatch(Collection<T> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(this::save);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult update(T t) {
        T db = getBaseDao().selectById(t.getId());
        db.copyFrom(t);
        setCommonsParameters(db);
        getBaseDao().updateById(db);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @Override
    public DtoResult updateBatch(Collection<T> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(this::update);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult saveOrUpdate(T t) {
        if (isNew(t)) {
            return save(t);
        } else {
            return update(t);
        }
    }

    @Override
    public DtoResult saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    public DtoResult saveOrUpdateBatch(Collection<T> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(this::saveOrUpdate);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult deleteById(ID id) {
        getBaseDao().deleteById(id);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult deleteById(ID[] ids) {
        return deleteById(Arrays.asList(ids));
    }

    @Override
    public DtoResult deleteById(Collection<ID> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(this::deleteById);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult delete(T t) {
        getBaseDao().deleteByMap(t.toParamsMap());
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult delete(T[] arrays) {
        return delete(Arrays.asList(arrays));
    }

    @Override
    public DtoResult delete(Collection<T> collection) {
        collection.stream().filter(ObjectUtil::isNotEmpty).forEach(this::delete);
        return DtoResultUtils.ok();
    }

    @Override
    public T get(ID id) {
        return getBaseDao().selectById(id);
    }
}
