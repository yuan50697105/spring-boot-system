package com.yuan.springbootwebjpa.commons.service.impl;

import com.google.common.collect.ImmutableList;
import com.yuan.springbootwebjpa.commons.entity.bo.BaseQueryParam;
import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import com.yuan.springbootwebjpa.commons.service.BaseSerivce;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.*;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/

@Transactional(rollbackFor = Exception.class)
public abstract class BaseSerivceImpl<T extends BasePo, ID extends Serializable, S extends BaseRepository<T, ID>> implements BaseSerivce<T, ID> {
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

    @Override
    public Optional<T> findOneBySQL(BaseQueryParam queryParam, BaseQueryParam.QueryType queryType) {
        Optional<T> optional = Optional.empty();

        return optional;
    }

    @Override
    public List<T> findAllBySQL(BaseQueryParam queryParam, BaseQueryParam.QueryType queryType) {
        List<T> list = ImmutableList.of();
        return list;
    }

    @Override
    public Page<T> findAllBySQL(BaseQueryParam queryParam, Pageable pageable, BaseQueryParam.QueryType queryType) {
        Page<T> page = Page.empty();
        return page;
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(BaseQueryParam queryParam, BaseQueryParam.QueryType queryType) {
        Optional<Map<String, Object>> optional = Optional.empty();
        return optional;
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(BaseQueryParam queryParam, BaseQueryParam.QueryType queryType) {
        List<Map<String, Object>> list = null;
        return list;
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(BaseQueryParam queryParam, Pageable pageable, BaseQueryParam.QueryType queryType) {
        Page<Map<String, Object>> list = Page.empty();
        return list;
    }

    @Override
    public Optional<T> findOneBySQL(String sql, Object... objects) {
        return getRepository().findOneBySQL(sql, objects);
    }

    @Override
    public Optional<T> findOneBySQL(String sql, Collection collection) {
        return getRepository().findOneBySQL(sql, collection.toArray());
    }

    @Override
    public Optional<T> findOneBySQL(String sql, Map<String, Object> map) {
        return getRepository().findOneBySQL(sql, map);
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Object... objects) {
        return getRepository().findOneByHQL(hql, objects);
    }


    @Override
    public List<T> findAllBySQL(String sql, Object... objects) {
        return getRepository().findAllBySQL(sql, objects);
    }

    @Override
    public List<T> findAllBySQL(String sql, Collection collections) {
        return getRepository().findAllBySQL(sql, collections.toArray());
    }

    @Override
    public List<T> findAllBySQL(String sql, Map<String, Object> map) {
        return getRepository().findAllBySQL(sql, map);
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Object... objects) {
        return getRepository().findAllBySQL(sql, pageable, objects);
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Collection collections) {
        return getRepository().findAllBySQL(sql, pageable, collections.toArray());
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Map<String, Object> map) {
        return getRepository().findAllBySQL(sql, pageable, map);
    }

}
