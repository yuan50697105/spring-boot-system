package com.yuan.springbootwebjpa.commons.service.impl;

import com.yuan.springbootwebjpa.commons.entity.dto.ArrayQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.CollectionQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import com.yuan.springbootwebjpa.commons.service.BaseSerivce;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.*;

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
        getRepository().findAllById(ids).forEach(getRepository()::delete);
    }

    @Override
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
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
    public Optional<T> findOneByDSLQuery(SelectQuery<Record> selectQuery) {
        return getRepository().findOneByQuery(selectQuery);
    }


    @Override
    public Optional<T> findOneBySQLQuery(MapQuery query) {
        return findOneBySQL(query.getSql(), query.getMap());
    }

    @Override
    public Optional<T> findOneBySQLQuery(ArrayQuery query) {
        return findOneBySQL(query.getSql(), query.getObjects());
    }

    @Override
    public Optional<T> findOneBySQLQuery(CollectionQuery query) {
        return getRepository().findOneBySQL(query.getSql(), query.getCollection());
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Object... objects) {
        return getRepository().findOneByHQL(hql, objects);
    }

    @Override
    public List<T> findAllById(Iterable<ID> ids) {
        return getRepository().findAllById(ids);
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
    public List<T> findAllByDSLQuery(SelectQuery<Record> selectQuery) {
        return getRepository().findAllByQuery(selectQuery);
    }

    @Override
    public List<T> findAllBySQLQuery(MapQuery query) {
        return findAllBySQL(query.getSql(), query.getMap());
    }

    @Override
    public List<T> findAllBySQLQuery(ArrayQuery query) {
        return findAllBySQL(query.getSql(), query.getObjects());
    }

    @Override
    public List<T> findAllBySQLQuery(CollectionQuery query) {
        return findAllBySQL(query.getSql(), query.getCollection());
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

    @Override
    public Page<T> findAllByDSLQuery(SelectQuery<Record> selectQuery, Pageable pageable) {
        return getRepository().findAllByQuery(selectQuery, pageable);
    }

    @Override
    public Page<T> findAllBySQLQuery(MapQuery query, Pageable pageable) {
        return findAllBySQL(query.getSql(), pageable, query.getMap());
    }

    @Override
    public Page<T> findAllBySQLQuery(ArrayQuery query, Pageable pageable) {
        return findAllBySQL(query.getSql(), pageable, query.getObjects());
    }

    @Override
    public Page<T> findAllBySQLQuery(CollectionQuery query, Pageable pageable) {
        return findAllBySQL(query.getSql(), pageable, query.getCollection());
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(String sql, Object... objects) {
        return getRepository().findOneBySQLToMap(sql, objects);
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(String sql, Collection collection) {
        return getRepository().findOneBySQLToMap(sql, collection);
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(String sql, Map<String, Object> map) {
        return getRepository().findOneBySQLToMap(sql, map);
    }

    @Override
    public Optional<Map<String, Object>> findOneByDSLQueryToMap(SelectQuery<Record> selectQuery) {
        return getRepository().findOneByQueryToMap(selectQuery);
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLQueryToMap(MapQuery query) {
        return findOneBySQLToMap(query.getSql(), query.getMap());
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLQueryToMap(ArrayQuery query) {
        return findOneBySQLToMap(query.getSql(), query.getObjects());
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLQueryToMap(CollectionQuery query) {
        return findOneBySQLToMap(query.getSql(), query.getCollection());
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Object... objects) {
        return getRepository().findAllBySQLToMap(sql, objects);
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Collection collection) {
        return getRepository().findAllBySQLToMap(sql, collection);
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Map<String, Object> map) {
        return getRepository().findAllBySQLToMap(sql, map);
    }

    @Override
    public List<Map<String, Object>> findAllByDSLQueryToMap(SelectQuery<Record> selectQuery) {
        return getRepository().findAllByQueryToMap(selectQuery);
    }

    @Override
    public List<Map<String, Object>> findAllBySQLQueryToMap(MapQuery query) {
        return findAllBySQLToMap(query.getSql(), query.getMap());
    }

    @Override
    public List<Map<String, Object>> findAllBySQLQueryToMap(ArrayQuery query) {
        return findAllBySQLToMap(query.getSql(), query.getObjects());
    }

    @Override
    public List<Map<String, Object>> findAllBySQLQueryToMap(CollectionQuery query) {
        return findAllBySQLToMap(query.getSql(), query.getCollection());
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Object... objects) {
        return getRepository().findAllBySQLToMap(sql, pageable, objects);
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Collection collection) {
        return getRepository().findAllBySQLToMap(sql, pageable, collection);
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Map<String, Object> map) {
        return getRepository().findAllBySQLToMap(sql, pageable, map);
    }

    @Override
    public Page<Map<String, Object>> findAllByDSLQueryToMap(SelectQuery<Record> selectQuery, Pageable pageable) {
        return getRepository().findAllByQueryToMap(selectQuery, pageable);
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLQueryToMap(MapQuery query, Pageable pageable) {
        return findAllBySQLToMap(query.getSql(), pageable, query.getMap());
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLQueryToMap(ArrayQuery query, Pageable pageable) {
        return findAllBySQLToMap(query.getSql(), pageable, query.getObjects());
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLQueryToMap(CollectionQuery query, Pageable pageable) {
        return findAllBySQLToMap(query.getSql(), pageable, query.getCollection());
    }


}
