package com.yuan.springbootwebjpa.commons.service.impl;

import com.yuan.springbootwebjpa.commons.entity.BaseEntity;
import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import com.yuan.springbootwebjpa.commons.service.BaseSerivce;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/

@Transactional(rollbackFor = Exception.class)
public abstract class BaseSerivceImpl<T extends BaseEntity, ID extends Serializable, S extends BaseRepository<T, ID>> implements BaseSerivce<T, ID> {
    protected abstract S getRepository();

    protected boolean isNotEmpty(Object object) {
        return !StringUtils.isEmpty(object);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T save(T t) {
        return getRepository().save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Iterable<T> saveAll(Iterable<T> ts) {
        return getRepository().saveAll(ts);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID... ids) {
        delete(Arrays.asList(ids));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Iterable<ID> ids) {
        List<T> list = getRepository().findAllById(ids);
        if (list.size() > 0) {
            getRepository().deleteInBatch(list);
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public List<T> findAllById(Iterable<ID> ids) {
        return getRepository().findAllById(ids);
    }

    @Override
    public Optional<T> findOneByExample(T t) {
        return getRepository().findOne(Example.of(t));
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<T> findAll(T t) {
        return getRepository().findAll(Example.of(t));
    }

    @Override
    public List<T> findAll(T t, Sort sort) {
        return getRepository().findAll(Example.of(t), sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public Page<T> findAll(T t, Pageable pageable) {
        return getRepository().findAll(Example.of(t), pageable);
    }
}
