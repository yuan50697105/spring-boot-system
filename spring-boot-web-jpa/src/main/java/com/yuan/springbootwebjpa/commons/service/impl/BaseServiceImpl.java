package com.yuan.springbootwebjpa.commons.service.impl;

import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import com.yuan.springbootwebjpa.commons.service.BaseSerivce;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BasePo, ID extends Serializable, S extends BaseRepository<T, ID>> implements BaseSerivce<T, ID> {
    protected abstract S getRepository();

    protected boolean isNotEmpty(Object object) {
        return !StringUtils.isEmpty(object);
    }

    protected abstract void beforeSave(T t) throws RuntimeException;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(T t) {
        beforeSave(t);
        getRepository().save(t);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(T[] ts) {
        Arrays.stream(ts).forEach(this::beforeSave);
        saveAll(Arrays.asList(ts));
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(Iterable<T> iterable) {
        iterable.forEach(this::beforeSave);
        saveAll(iterable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ID[] ids) {
        delete(Arrays.asList(ids));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Collection<ID> collection) {
        getRepository().findAllById(collection).forEach(getRepository()::delete);
    }

    @Override
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public List<T> findAllById(ID[] ids) {
        return findAllById(Arrays.asList(ids));
    }

    @Override
    public List<T> findAllById(Collection<ID> collection) {
        return getRepository().findAllById(collection);
    }

    @Override
    public Optional<T> findOne(T t) {
        return getRepository().findOne(Example.of(t));
    }

    @Override
    public Optional<T> findOne(Specification<T> specification) {
        return getRepository().findOne(specification);
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
    public List<T> findAll(Specification<T> specification) {
        return getRepository().findAll(specification);
    }

    @Override
    public List<T> findAll(Specification<T> specification, Sort sort) {
        return getRepository().findAll(specification, sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public Page<T> findAll(T t, Pageable pageable) {
        return getRepository().findAll(Example.of(t), pageable);
    }

    @Override
    public Page<T> findAll(Specification<T> specification, Pageable pageable) {
        return getRepository().findAll(specification, pageable);
    }

}
