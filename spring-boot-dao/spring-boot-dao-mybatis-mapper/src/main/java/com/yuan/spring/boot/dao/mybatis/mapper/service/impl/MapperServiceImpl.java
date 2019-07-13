package com.yuan.spring.boot.dao.mybatis.mapper.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.spring.boot.dao.commons.entity.dto.DtoResult;
import com.yuan.spring.boot.dao.commons.utils.DtoResultUtils;
import com.yuan.spring.boot.dao.mybatis.mapper.dao.MapperDao;
import com.yuan.spring.boot.dao.mybatis.mapper.entity.domain.MapperDomain;
import com.yuan.spring.boot.dao.mybatis.mapper.service.MapperService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuane
 * @date 2019/6/15 23:10
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class MapperServiceImpl<T extends MapperDomain<ID>, ID extends Serializable, S extends MapperDao<T, ID>> implements MapperService<T, ID> {
    public abstract S getBaseDao();

    protected abstract T setCommonsParameters(T t);

    protected boolean isNew(T t) {
        return StringUtils.isEmpty(t.getId()) && get(t.getId()) == null;
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
    @Transactional(rollbackFor = Exception.class)
    public DtoResult saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult saveOrUpdateBatch(Collection<T> collection) {
        collection.forEach(this::saveOrUpdate);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult save(T t) {
        setCommonsParameters(t);
        getBaseDao().insert(t);
        return DtoResultUtils.ok();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult saveBatch(T[] arrays) {
        return saveBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult saveBatch(Collection<T> collection) {
        collection.forEach(this::save);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult update(T t) {
        setCommonsParameters(t);
        getBaseDao().updateByPrimaryKeySelective(t);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult updateBatch(Collection<T> collection) {
        collection.forEach(this::update);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult deleteById(ID id) {
        getBaseDao().deleteByPrimaryKey(id);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult deleteById(ID[] ids) {
        return deleteById(Arrays.asList(ids));
    }

    @Override
    public DtoResult deleteById(Collection<ID> collection) {
        collection.stream().forEach(this::deleteById);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
        collection.forEach(this::delete);
        return DtoResultUtils.ok();
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


}

