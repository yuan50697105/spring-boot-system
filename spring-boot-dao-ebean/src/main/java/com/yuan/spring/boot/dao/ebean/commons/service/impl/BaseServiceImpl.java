package com.yuan.spring.boot.dao.ebean.commons.service.impl;

import com.yuan.spring.boot.dao.ebean.commons.dao.BaseDao;
import com.yuan.spring.boot.dao.ebean.commons.entity.po.BasePo;
import com.yuan.spring.boot.dao.ebean.commons.service.BaseService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.ebean.querychannel.EbeanQueryChannelService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BasePo<ID>, ID, S extends BaseDao<T, ID>> extends EbeanQueryChannelService implements BaseService<T, ID> {
    protected abstract S getBaseDao();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(T t) {
        getBaseDao().save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(T[] arrays) {
        getBaseDao().saveAll(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(Iterable<T> iterable) {
        getBaseDao().saveAll(iterable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID id) {
        getBaseDao().deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID[] ids) {
        getBaseDao().findAllById(Arrays.asList(ids)).forEach(getBaseDao()::delete);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Iterable<ID> iterable) {
        getBaseDao().findAllById(iterable).forEach(getBaseDao()::delete);
    }

    @Override
    public Optional<T> findById(ID id) {
        return getBaseDao().findById(id);
    }

    @Override
    public Optional<T> findOne(T t) {
        return getBaseDao().findOne(Example.of(t));
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return getBaseDao().findAllById(Arrays.asList(ids));
    }

    @Override
    public List<T> findAll() {
        return getBaseDao().findAll();
    }

    @Override
    public List<T> findAll(T t) {
        return getBaseDao().findAll(Example.of(t));
    }

    @Override
    public List<T> findAll(T t, Sort sort) {
        return getBaseDao().findAll(Example.of(t), sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getBaseDao().findAll(pageable);
    }

    @Override
    public Page<T> findAll(T t, Pageable pageable) {
        return getBaseDao().findAll(Example.of(t), pageable);
    }

    protected boolean isNew(T t) {
        Optional<T> optional = getBaseDao().findById(t.getId());
        return optional.isPresent();
    }
}
