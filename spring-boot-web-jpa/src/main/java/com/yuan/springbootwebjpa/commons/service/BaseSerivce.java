package com.yuan.springbootwebjpa.commons.service;

import com.querydsl.core.types.Predicate;
import com.yuan.springbootwebjpa.commons.entity.dto.ArrayQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.CollectionQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/
public interface BaseSerivce<T extends BasePo, ID extends Serializable> {
    @Transactional
    T save(T t);

    Iterable<T> saveAll(Iterable<T> ts);

    void delete(ID id);

    @Transactional
    void delete(ID... ids);

    @Transactional
    void delete(Iterable<ID> ids);

    Optional<T> findById(ID id);

    Optional<T> findOneByQuery(ArrayQuery query);

    Optional<T> findOneByQuery(CollectionQuery query);

    Optional<T> findOneByQuery(MapQuery query);

    List<T> findAllById(Iterable<ID> ids);

    Optional<T> findOne(T t);

    Optional<T> findOne(Specification<T> specification);

    Optional<T> findOne(Predicate predicate);

    Optional<T> findOneBySQL(String sql, Object... objects);

    Optional<T> findOneBySQL(String sql, Collection collection);

    Optional<T> findOneBySQL(String sql, Map<String, Object> map);

    Optional<T> findOneByHQL(String hql, Object... objects);

    Optional<T> findOneByHQL(String hql, Collection collection);

    Optional<T> findOneByHQL(String hql, Map<String, Object> map);

    Optional<T> findOneByDSLQuery(SelectQuery<Record> selectQuery);

    Optional<T> findOneBySQLQuery(MapQuery query);

    Optional<T> findOneBySQLQuery(ArrayQuery query);

    Optional<T> findOneBySQLQuery(CollectionQuery query);

    List<T> findAll();

    List<T> findAll(T t);

    List<T> findAll(T t, Sort sort);

    List<T> findAll(Specification<T> specification);

    List<T> findAll(Specification<T> specification, Sort sort);

    List<T> findAll(Predicate predicate);

    List<T> findAllBySQL(String sql, Object... objects);

    List<T> findAllBySQL(String sql, Collection collections);

    List<T> findAllBySQL(String sql, Map<String, Object> map);

    List<T> findAllByHQL(String hql, Object... objects);

    List<T> findAllByHQL(String hql, Collection collection);

    List<T> findAllByHQL(String hql, Map<String, Object> map);

    List<T> findAllByDSLQuery(SelectQuery<Record> selectQuery);

    List<T> findAllBySQLQuery(ArrayQuery query);

    List<T> findAllBySQLQuery(CollectionQuery query);

    List<T> findAllBySQLQuery(MapQuery query);

    List<T> findAllByQuery(ArrayQuery query);

    List<T> findAllByQuery(CollectionQuery query);

    List<T> findAllByQuery(MapQuery query);

    Page<T> findAll(Pageable pageable);

    Page<T> findAll(T t, Pageable pageable);

    Page<T> findAll(Specification<T> specification, Pageable pageable);

    Page<T> findAll(Predicate predicate, Pageable pageable);

    Page<T> findAllBySQL(String sql, Pageable pageable, Object... objects);

    Page<T> findAllBySQL(String sql, Pageable pageable, Collection collections);

    Page<T> findAllBySQL(String sql, Pageable pageable, Map<String, Object> map);

    Page<T> findAllByHQL(String hql, Pageable pageable, Object... objects);

    Page<T> findAllByHQL(String hql, Pageable pageable, Collection collection);

    Page<T> findAllByDSLQuery(SelectQuery<Record> selectQuery, Pageable pageable);

    Page<T> findAllBySQLQuery(MapQuery query, Pageable pageable);

    Page<T> findAllBySQLQuery(ArrayQuery query, Pageable pageable);

    Page<T> findAllBySQLQuery(CollectionQuery query, Pageable pageable);

    Optional<Map<String, Object>> findOneBySQLToMap(String sql, Object... objects);

    Optional<Map<String, Object>> findOneBySQLToMap(String sql, Collection collection);

    Optional<Map<String, Object>> findOneBySQLToMap(String sql, Map<String, Object> map);

    Optional<Map<String, Object>> findOneByDSLQueryToMap(SelectQuery<Record> selectQuery);

    Optional<Map<String, Object>> findOneBySQLQueryToMap(ArrayQuery query);

    Optional<Map<String, Object>> findOneBySQLQueryToMap(CollectionQuery query);

    Optional<Map<String, Object>> findOneBySQLQueryToMap(MapQuery query);

    List<Map<String, Object>> findAllBySQLToMap(String sql, Object... objects);

    List<Map<String, Object>> findAllBySQLToMap(String sql, Collection collection);

    List<Map<String, Object>> findAllBySQLToMap(String sql, Map<String, Object> map);

    List<Map<String, Object>> findAllByDSLQueryToMap(SelectQuery<Record> selectQuery);

    List<Map<String, Object>> findAllBySQLQueryToMap(ArrayQuery query);

    List<Map<String, Object>> findAllBySQLQueryToMap(CollectionQuery query);

    List<Map<String, Object>> findAllBySQLQueryToMap(MapQuery query);

    Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Object... objects);

    Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Collection collection);

    Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Map<String, Object> map);

    Page<Map<String, Object>> findAllByDSLQueryToMap(SelectQuery<Record> selectQuery, Pageable pageable);

    Page<Map<String, Object>> findAllBySQLQueryToMap(ArrayQuery query, Pageable pageable);

    Page<Map<String, Object>> findAllBySQLQueryToMap(CollectionQuery query, Pageable pageable);

    Page<Map<String, Object>> findAllBySQLQueryToMap(MapQuery query, Pageable pageable);
}
