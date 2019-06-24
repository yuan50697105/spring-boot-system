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

@SuppressWarnings({"unchecked", "InfiniteRecursion"})
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BasePo, ID extends Serializable, S extends BaseRepository<T, ID>> implements BaseSerivce<T, ID> {
    protected abstract S getRepository();

    protected boolean isNotEmpty(Object object) {
        return !StringUtils.isEmpty(object);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(T t) {
        getRepository().save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(T[] ts) {
        saveAll(Arrays.asList(ts));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(Collection<T> collection) {
        saveAll(collection);
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


    @Override
    public Optional<T> findOneBySQL(String sql, Object... objects) {
        return getRepository().findOneBySQL(sql, objects);
    }

    @Override
    public Optional<T> findOneBySQL(String sql, Collection collection) {
        return getRepository().findOneBySQL(sql, collection);
    }

    @Override
    public Optional<T> findOneBySQL(String sql, Map<String, Object> map) {
        return getRepository().findOneBySQL(sql, map);
    }

    @Override
    public Optional<T> findOneBySQL(ArrayQuery query) {
        return getRepository().findOneBySQL(query);
    }

    @Override
    public Optional<T> findOneBySQL(CollectionQuery query) {
        return getRepository().findOneBySQL(query);
    }

    @Override
    public Optional<T> findOneBySQL(MapQuery query) {
        return getRepository().findOneBySQL(query);
    }

    @Override
    public Optional<T> findOneByDSL(SelectQuery<Record> selectQuery) {
        return getRepository().findOneByDSL(selectQuery);
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Object... objects) {
        return getRepository().findOneByHQL(hql, objects);
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Collection collection) {
        return getRepository().findOneByHQL(hql, collection);
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Map<String, Object> map) {
        return getRepository().findOneByHQL(hql, map);
    }

    @Override
    public Optional<T> findOneByHQL(ArrayQuery query) {
        return getRepository().findOneByHQL(query);
    }

    @Override
    public Optional<T> findOneByHQL(CollectionQuery query) {
        return getRepository().findOneByHQL(query);
    }

    @Override
    public Optional<T> findOneByHQL(MapQuery query) {
        return getRepository().findOneByHQL(query);
    }

    @Override
    public List<T> findAllBySQL(String sql, Object... objects) {
        return getRepository().findAllBySQL(sql, objects);
    }

    @Override
    public List<T> findAllBySQL(String sql, Collection collection) {
        return getRepository().findAllBySQL(sql, collection);
    }

    @Override
    public List<T> findAllBySQL(String sql, Map<String, Object> map) {
        return getRepository().findAllBySQL(sql, map);
    }

    @Override
    public List<T> findAllBySQL(ArrayQuery query) {
        return getRepository().findAllBySQL(query);
    }

    @Override
    public List<T> findAllBySQL(CollectionQuery query) {
        return getRepository().findAllBySQL(query);
    }

    @Override
    public List<T> findAllBySQL(MapQuery query) {
        return getRepository().findAllBySQL(query);
    }

    @Override
    public List<T> findAllByDSL(SelectQuery<Record> selectQuery) {
        return getRepository().findAllByDSL(selectQuery);
    }

    @Override
    public List<T> findAllByHQL(String hql, Object... objects) {
        return getRepository().findAllByHQL(hql, objects);
    }

    @Override
    public List<T> findAllByHQL(String hql, Collection collection) {
        return getRepository().findAllByHQL(hql, collection);
    }

    @Override
    public List<T> findAllByHQL(String hql, Map<String, Object> map) {
        return getRepository().findAllByHQL(hql, map);
    }

    @Override
    public List<T> findAllByHQL(ArrayQuery query) {
        return getRepository().findAllByHQL(query);
    }

    @Override
    public List<T> findAllByHQL(CollectionQuery query) {
        return getRepository().findAllByHQL(query);
    }

    @Override
    public List<T> findAllByHQL(MapQuery query) {
        return getRepository().findAllByHQL(query);
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Object... objects) {
        return getRepository().findAllBySQL(sql, pageable, objects);
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Collection collection) {
        return getRepository().findAllBySQL(sql, pageable, collection);
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Map<String, Object> map) {
        return getRepository().findAllBySQL(sql, pageable, map);
    }

    @Override
    public Page<T> findAllByDSL(SelectQuery<Record> selectQuery, Pageable pageable) {
        return getRepository().findAllByDSL(selectQuery, pageable);
    }

    @Override
    public Page<T> findAllBySQL(ArrayQuery query, Pageable pageable) {
        return getRepository().findAllBySQL(query, pageable);
    }

    @Override
    public Page<T> findAllBySQL(CollectionQuery query, Pageable pageable) {
        return getRepository().findAllBySQL(query, pageable);
    }

    @Override
    public Page<T> findAllBySQL(MapQuery query, Pageable pageable) {
        return getRepository().findAllBySQL(query, pageable);
    }

    @Override
    public Page<T> findAllByHQL(String hql, Pageable pageable, Object... objects) {
        return getRepository().findAllByHQL(hql, pageable, objects);
    }

    @Override
    public Page<T> findAllByHQL(String hql, Pageable pageable, Collection collection) {
        return getRepository().findAllByHQL(hql, pageable, collection);
    }

    @Override
    public Page<T> findAllByHQL(String hql, Pageable pageable, Map<String, Object> map) {
        return getRepository().findAllByHQL(hql, pageable, map);
    }

    @Override
    public Page<T> findAllByHQL(ArrayQuery query, Pageable pageable) {
        return getRepository().findAllByHQL(query, pageable);
    }

    @Override
    public Page<T> findAllByHQL(CollectionQuery query, Pageable pageable) {
        return getRepository().findAllByHQL(query, pageable);
    }

    @Override
    public Page<T> findAllByHQL(MapQuery query, Pageable pageable) {
        return getRepository().findAllByHQL(query, pageable);
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, String sql, Object... objects) {
        return getRepository().findOneBySQL(type, sql, objects);
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, String sql, Collection collection) {
        return getRepository().findOneBySQL(type, sql, collection);
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, String sql, Map<String, Object> map) {
        return getRepository().findOneBySQL(type, sql, map);
    }

    @Override
    public <R> Optional<R> findOneByDSL(Class<R> type, SelectQuery<Record> selectQuery) {
        return getRepository().findOneByDSL(type, selectQuery);
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, ArrayQuery query) {
        return getRepository().findOneBySQL(type, query);
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, CollectionQuery query) {
        return getRepository().findOneBySQL(type, query);
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, MapQuery query) {
        return getRepository().findOneBySQL(type, query);
    }

    @Override
    public <R> Optional<R> findByOneHQL(Class<R> type, String hql, Object... objects) {
        return getRepository().findOneBySQL(type, hql, objects);
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, String hql, Collection collection) {
        return getRepository().findOneBySQL(type, hql, collection);
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, String hql, Map<String, Object> map) {
        return getRepository().findOneBySQL(type, hql, map);
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, ArrayQuery query) {
        return getRepository().findOneByHQL(type, query);
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, CollectionQuery query) {
        return getRepository().findOneByHQL(type, query);
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, MapQuery query) {
        return getRepository().findOneByHQL(type, query);
    }

    @Override
    public <R> List<R> findAllBySQL(Class<R> type, String sql, Object... objects) {
        return getRepository().findAllBySQL(type, sql, objects);
    }

    @Override
    public <R> List<R> findAllBySQL(Class<R> type, String sql, Collection collection) {
        return getRepository().findAllBySQL(type, sql, collection);
    }

    @Override
    public <R> List<R> findAllBySQL(Class<R> type, String sql, Map<String, Object> map) {
        return getRepository().findAllBySQL(type, sql, map);
    }

    @Override
    public <R> List<R> findAllByDSL(Class<R> type, SelectQuery<Record> selectQuery) {
        return getRepository().findAllByDSL(type, selectQuery);
    }

    @Override
    public <R> List<R> findAllBySQL(Class<R> type, ArrayQuery query) {
        return getRepository().findAllBySQL(type, query);
    }

    @Override
    public <R> List<R> findAllBySQL(Class<R> type, CollectionQuery query) {
        return getRepository().findAllBySQL(type, query);
    }

    @Override
    public <R> List<R> findAllBySQL(Class<R> type, MapQuery query) {
        return getRepository().findAllBySQL(type, query);
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, String hql, Object... objects) {
        return getRepository().findAllByHQL(type, hql, objects);
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, String hql, Collection collection) {
        return getRepository().findAllByHQL(type, hql, collection);
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, String hql, Map<String, Object> map) {
        return getRepository().findAllByHQL(type, hql, map);
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, ArrayQuery query) {
        return getRepository().findAllByHQL(type, query);
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, CollectionQuery query) {
        return getRepository().findAllByHQL(type, query);
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, MapQuery query) {
        return getRepository().findAllByHQL(type, query);
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, String sql, Pageable pageable, Object... objects) {
        return getRepository().findAllBySQL(type, sql, pageable, objects);
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, String sql, Pageable pageable, Collection collection) {
        return getRepository().findAllBySQL(type, sql, pageable, collection);
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, String sql, Pageable pageable, Map<String, Object> map) {
        return getRepository().findAllBySQL(type, sql, pageable, map);
    }

    @Override
    public <R> Page<R> findAllByDSL(Class<R> type, SelectQuery<Record> selectQuery, Pageable pageable) {
        return getRepository().findAllByDSL(type, selectQuery, pageable);
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, ArrayQuery query, Pageable pageable) {
        return getRepository().findAllBySQL(type, query, pageable);
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, CollectionQuery query, Pageable pageable) {
        return getRepository().findAllBySQL(type, query, pageable);
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, MapQuery query, Pageable pageable) {
        return getRepository().findAllBySQL(type, query, pageable);
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, String hql, Pageable pageable, Object... objects) {
        return getRepository().findAllByHQL(type, hql, pageable, objects);
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, String hql, Pageable pageable, Collection collection) {
        return getRepository().findAllByHQL(type, hql, pageable, collection);
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, String hql, Pageable pageable, Map<String, Object> map) {
        return getRepository().findAllByHQL(type, hql, pageable, map);
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, ArrayQuery query, Pageable pageable) {
        return getRepository().findAllByHQL(type, query, pageable);
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, CollectionQuery query, Pageable pageable) {
        return getRepository().findAllByHQL(type, query, pageable);
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, MapQuery query, Pageable pageable) {
        return getRepository().findAllByHQL(type, query, pageable);
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, String sql, Object... objects) {
        return getRepository().findOneBySQLToBean(type, sql, objects);
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, String sql, Collection collection) {
        return getRepository().findOneBySQLToBean(type, sql, collection);
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, String sql, Map<String, Object> map) {
        return getRepository().findOneBySQLToBean(type, sql, map);
    }

    @Override
    public <R> Optional<R> findOneByDSLToBean(Class<R> type, SelectQuery<Record> selectQuery) {
        return getRepository().findOneBySQLToBean(type, selectQuery);
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, ArrayQuery query) {
        return getRepository().findOneBySQLToBean(type, query);
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, CollectionQuery query) {
        return getRepository().findOneBySQLToBean(type, query);
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, MapQuery query) {
        return getRepository().findOneBySQLToBean(type, query);
    }

    @Override
    public <R> Optional<R> findOneByHQLToBean(Class<R> type, String hql, Object... objects) {
        return getRepository().findOneByHQLToBean(type, hql, objects);
    }

    @Override
    public <R> Optional<R> findOneByHQLToBean(Class<R> type, String hql, Collection collection) {
        return getRepository().findOneByHQLToBean(type, hql, collection);
    }

    @Override
    public <R> Optional<R> findOneByHQLToBean(Class<R> type, String hql, Map<String, Object> map) {
        return getRepository().findOneByHQLToBean(type, hql, map);
    }

    @Override
    public <R> Optional<R> findOneByHQLToBean(Class<R> type, ArrayQuery query) {
        return getRepository().findOneBySQLToBean(type, query);
    }

    @Override
    public <R> Optional<R> findOneByHQLToBean(Class<R> type, CollectionQuery query) {
        return getRepository().findOneBySQLToBean(type, query);
    }

    @Override
    public <R> Optional<R> findOneByHQLToBean(Class<R> type, MapQuery query) {
        return getRepository().findOneBySQLToBean(type, query);
    }

    @Override
    public <R> List<R> findAllBySQLToBean(Class<R> type, String sql, Object... objects) {
        return getRepository().findAllBySQLToBean(type, sql, objects);
    }

    @Override
    public <R> List<R> findAllBySQLToBean(Class<R> type, String sql, Collection collection) {
        return getRepository().findAllBySQLToBean(type, sql, collection);
    }

    @Override
    public <R> List<R> findAllBySQLToBean(Class<R> type, String sql, Map<String, Object> map) {
        return getRepository().findAllBySQLToBean(type, sql, map);
    }

    @Override
    public <R> List<R> findAllByDSLToBean(Class<R> type, SelectQuery<Record> selectQuery) {
        return getRepository().findAllByDSLToBean(type, selectQuery);
    }

    @Override
    public <R> List<R> findAllBySQLToBean(Class<R> type, ArrayQuery query) {
        return getRepository().findAllBySQLToBean(type, query);
    }

    @Override
    public <R> List<R> findAllBySQLToBean(Class<R> type, CollectionQuery query) {
        return getRepository().findAllBySQLToBean(type, query);
    }

    @Override
    public <R> List<R> findAllBySQLToBean(Class<R> type, MapQuery query) {
        return getRepository().findAllBySQLToBean(type, query);
    }

    @Override
    public <R> List<R> findAllByHQLToBean(Class<R> type, String hql, Object... objects) {
        return getRepository().findAllBySQLToBean(type, hql, objects);
    }

    @Override
    public <R> List<R> findAllByHQLToBean(Class<R> type, String hql, Collection collection) {
        return getRepository().findAllBySQLToBean(type, hql, collection);
    }

    @Override
    public <R> List<R> findAllByHQLToBean(Class<R> type, String hql, Map<String, Object> map) {
        return getRepository().findAllBySQLToBean(type, hql, map);
    }

    @Override
    public <R> Page<R> findAllBySQLToBean(Class<R> type, String sql, Pageable pageable, Object... objects) {
        return getRepository().findAllBySQLToBean(type, sql, pageable, objects);
    }

    @Override
    public <R> Page<R> findAllBySQLToBean(Class<R> type, String sql, Pageable pageable, Collection collection) {
        return getRepository().findAllBySQLToBean(type, sql, pageable, collection);
    }

    @Override
    public <R> Page<R> findAllBySQLToBean(Class<R> type, String sql, Pageable pageable, Map<String, Object> map) {
        return getRepository().findAllBySQLToBean(type, sql, pageable, map);
    }

    @Override
    public <R> Page<R> findAllByDSLToBean(Class<R> type, SelectQuery<Record> selectQuery, Pageable pageable) {
        return getRepository().findAllByDSLToBean(type, selectQuery, pageable);
    }

    @Override
    public <R> Page<R> findAllBySQLToBean(Class<R> type, ArrayQuery query, Pageable pageable) {
        return getRepository().findAllBySQLToBean(type, query, pageable);
    }

    @Override
    public <R> Page<R> findAllBySQLToBean(Class<R> type, CollectionQuery query, Pageable pageable) {
        return getRepository().findAllBySQLToBean(type, query, pageable);
    }

    @Override
    public <R> Page<R> findAllBySQLToBean(Class<R> type, MapQuery query, Pageable pageable) {
        return getRepository().findAllBySQLToBean(type, query, pageable);
    }

    @Override
    public <R> Page<R> findAllByHQLToBean(Class<R> type, String hql, Pageable pageable, Object... objects) {
        return getRepository().findAllByHQLToBean(type, hql, pageable, objects);
    }

    @Override
    public <R> Page<R> findAllByHQLToBean(Class<R> type, String hql, Pageable pageable, Collection collection) {
        return getRepository().findAllByHQLToBean(type, hql, pageable, collection);
    }

    @Override
    public <R> Page<R> findAllByHQLToBean(Class<R> type, String hql, Pageable pageable, Map<String, Object> map) {
        return getRepository().findAllByHQLToBean(type, hql, pageable, map);
    }

    @Override
    public <R> Page<R> findAllByHQLToBean(Class<R> type, ArrayQuery query, Pageable pageable) {
        return getRepository().findAllByHQLToBean(type, query, pageable);
    }

    @Override
    public <R> Page<R> findAllByHQLToBean(Class<R> type, CollectionQuery query, Pageable pageable) {
        return getRepository().findAllByHQLToBean(type, query, pageable);
    }

    @Override
    public <R> Page<R> findAllByHQLToBean(Class<R> type, MapQuery query, Pageable pageable) {
        return getRepository().findAllByHQLToBean(type, query, pageable);
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
    public Optional<Map<String, Object>> findOneByDSLToMap(SelectQuery<Record> selectQuery) {
        return getRepository().findOneByDSLToMap(selectQuery);
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(ArrayQuery query) {
        return getRepository().findOneBySQLToMap(query);
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(CollectionQuery query) {
        return getRepository().findOneBySQLToMap(query);
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(MapQuery query) {
        return getRepository().findOneBySQLToMap(query);
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(String sql, Object... objects) {
        return getRepository().findOneByHQLToMap(sql, objects);
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(String sql, Collection collection) {
        return getRepository().findOneByHQLToMap(sql, collection);
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(String sql, Map<String, Object> map) {
        return getRepository().findOneByHQLToMap(sql, map);
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(ArrayQuery query) {
        return getRepository().findOneByHQLToMap(query);
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(CollectionQuery query) {
        return getRepository().findOneByHQLToMap(query);
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(MapQuery query) {
        return getRepository().findOneByHQLToMap(query);
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Object... objects) {
        return getRepository().findAllBySQLToMap(sql, objects);
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Collection objects) {
        return getRepository().findAllBySQLToMap(sql, objects);
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Map<String, Object> objects) {
        return getRepository().findAllBySQLToMap(sql, objects);
    }

    @Override
    public List<Map<String, Object>> findAllByDSLToMap(SelectQuery<Record> selectQuery) {
        return getRepository().findAllByDSLToMap(selectQuery);
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(ArrayQuery query) {
        return getRepository().findAllBySQLToMap(query);
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(CollectionQuery query) {
        return getRepository().findAllBySQLToMap(query);
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(MapQuery query) {
        return getRepository().findAllBySQLToMap(query);
    }

    @Override
    public List<Map<String, Object>> findAllByHQLToMap(String hql, Object... objects) {
        return getRepository().findAllByHQLToMap(hql, objects);
    }

    @Override
    public List<Map<String, Object>> findAllByHQLToMap(String hql, Collection objects) {
        return getRepository().findAllByHQLToMap(hql, objects);
    }

    @Override
    public List<Map<String, Object>> findAllByHQLToMap(String hql, Map<String, Object> objects) {
        return getRepository().findAllByHQLToMap(hql, objects);
    }

    @Override
    public List<Map<String, Object>> findAllByHQLToMap(ArrayQuery query) {
        return getRepository().findAllByHQLToMap(query);
    }


}
