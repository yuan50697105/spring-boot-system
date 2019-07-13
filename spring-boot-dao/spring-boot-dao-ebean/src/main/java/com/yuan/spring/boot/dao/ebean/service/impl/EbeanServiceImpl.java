package com.yuan.spring.boot.dao.ebean.service.impl;

import com.yuan.spring.boot.dao.commons.entity.dto.DtoResult;
import com.yuan.spring.boot.dao.commons.utils.DtoResultUtils;
import com.yuan.spring.boot.dao.ebean.dao.EbeanDao;
import com.yuan.spring.boot.dao.ebean.entity.domain.EbeanDomain;
import com.yuan.spring.boot.dao.ebean.service.EbeanService;
import org.springframework.data.domain.*;
import org.springframework.data.ebean.querychannel.EbeanQueryChannelService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/13 12:37
 **/
public abstract class EbeanServiceImpl<S extends EbeanDao<T, ID>, T extends EbeanDomain<ID>, ID extends Serializable> extends EbeanQueryChannelService implements EbeanService<T, ID> {
    protected abstract S getBaseDao();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult saveOrUpdate(T t) {
        getBaseDao().save(t);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult saveOrUpdateBatch(Collection<T> collection) {
        getBaseDao().saveAll(collection);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult save(T t) {
        getBaseDao().save(t);
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
        getBaseDao().saveAll(collection);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult update(T t) {
        getBaseDao().save(t);
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
        getBaseDao().saveAll(collection);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult deleteById(ID id) {
        getBaseDao().deleteById(id);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DtoResult deleteById(ID[] ids) {
        Arrays.stream(ids).forEach(this::deleteById);
        return DtoResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
    @Transactional(rollbackFor = Exception.class)
    public DtoResult delete(T[] arrays) {
        Arrays.stream(arrays).forEach(this::delete);
        return DtoResultUtils.ok();
    }

    @Override
    public DtoResult delete(Collection<T> collection) {
        collection.forEach(this::delete);
        return DtoResultUtils.ok();
    }

    @Override
    public T get(ID id) {
        return getBaseDao().findById(id).orElse(null);
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return getBaseDao().findAllById(Arrays.asList(ids));
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return getBaseDao().findAllById(collection);
    }

    @Override
    public T findOne(T t) {
        return getBaseDao().findOne(Example.of(t)).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return getBaseDao().findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return getBaseDao().findAll(sort);
    }

    @Override
    public List<T> findAll(T t) {
        return getBaseDao().findAll(Example.of(t, ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)));
    }

    @Override
    public List<T> findAll(T t, Sort sort) {
        return getBaseDao().findAll(Example.of(t, ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)), sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getBaseDao().findAll(pageable);
    }

    @Override
    public Page<T> findAll(T t, Pageable pageable) {
        return getBaseDao().findAll(Example.of(t, ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)), pageable);
    }
}
