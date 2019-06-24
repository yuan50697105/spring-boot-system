package com.yuan.springbootwebjpa.commons.service;

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

    void save(T t);

    void saveAll(T[] ts);

    void saveAll(Collection<T> collection);

    void delete(ID id);

    void delete(ID[] ids);

    void delete(Collection<ID> collection);

    Optional<T> findById(ID id);

    List<T> findAllById(ID[] ids);

    List<T> findAllById(Collection<ID> collection);

    Optional<T> findOne(T t);

    Optional<T> findOne(Specification<T> specification);

    List<T> findAll();

    List<T> findAll(T t);

    List<T> findAll(T t, Sort sort);

    List<T> findAll(Specification<T> specification);

    List<T> findAll(Specification<T> specification, Sort sort);

    Page<T> findAll(Pageable pageable);

    Page<T> findAll(T t, Pageable pageable);

    Page<T> findAll(Specification<T> specification, Pageable pageable);

    <R> Optional<R> findOneBySQL(String sql, Object... objects);

    Optional<T> findOneBySQL(String sql, Collection collection);

    Optional<T> findOneBySQL(String sql, Map<String, Object> map);

    Optional<T> findOneBySQL(ArrayQuery query);

    Optional<T> findOneBySQL(CollectionQuery query);

    Optional<T> findOneBySQL(MapQuery query);

    Optional<T> findOneByDSL(SelectQuery<Record> selectQuery);

    Optional<T> findOneByHQL(String hql, Object... objects);

    Optional<T> findOneByHQL(String hql, Collection collection);

    Optional<T> findOneByHQL(String hql, Map<String, Object> map);

    Optional<T> findOneByHQL(ArrayQuery query);

    Optional<T> findOneByHQL(CollectionQuery query);

    Optional<T> findOneByHQL(MapQuery query);

    List<T> findAllBySQL(String sql, Object... objects);

    List<T> findAllBySQL(String sql, Collection collection);

    List<T> findAllBySQL(String sql, Map<String, Object> map);

    List<T> findAllBySQL(ArrayQuery query);

    List<T> findAllBySQL(CollectionQuery query);

    List<T> findAllBySQL(MapQuery query);

    List<T> findAllByDSL(SelectQuery<Record> selectQuery);

    List<T> findAllByHQL(String hql, Object... objects);

    List<T> findAllByHQL(String hql, Collection collection);

    List<T> findAllByHQL(String hql, Map<String, Object> map);

    List<T> findAllByHQL(ArrayQuery query);

    List<T> findAllByHQL(CollectionQuery query);

    List<T> findAllByHQL(MapQuery query);

    Page<T> findAllBySQL(String sql, Pageable pageable, Object... objects);

    Page<T> findAllBySQL(String sql, Pageable pageable, Collection collection);

    Page<T> findAllBySQL(String sql, Pageable pageable, Map<String, Object> map);

    Page<T> findAllByDSL(SelectQuery<Record> selectQuery, Pageable pageable);

    Page<T> findAllBySQL(ArrayQuery query, Pageable pageable);

    Page<T> findAllBySQL(CollectionQuery query, Pageable pageable);

    Page<T> findAllBySQL(MapQuery query, Pageable pageable);

    Page<T> findAllByHQL(String hql, Pageable pageable, Object... objects);

    Page<T> findAllByHQL(String hql, Pageable pageable, Collection collection);

    Page<T> findAllByHQL(String hql, Pageable pageable, Map<String, Object> map);

    Page<T> findAllByHQL(ArrayQuery query, Pageable pageable);

    Page<T> findAllByHQL(CollectionQuery query, Pageable pageable);

    Page<T> findAllByHQL(MapQuery query, Pageable pageable);

    <R> Optional<R> findOneBySQL(Class<R> type, String sql, Object... objects);

    <R> Optional<R> findOneBySQL(Class<R> type, String sql, Collection collection);

    <R> Optional<R> findOneBySQL(Class<R> type, String sql, Map<String, Object> map);

    <R> Optional<R> findOneByDSL(Class<R> type, SelectQuery<Record> selectQuery);

    <R> Optional<R> findOneBySQL(Class<R> type, ArrayQuery query);

    <R> Optional<R> findOneBySQL(Class<R> type, CollectionQuery query);

    <R> Optional<R> findOneBySQL(Class<R> type, MapQuery query);

    <R> Optional<R> findByOneHQL(Class<R> type, String hql, Object... objects);

    <R> Optional<R> findOneByHQL(Class<R> type, String hql, Collection collection);

    <R> Optional<R> findOneByHQL(Class<R> type, String hql, Map<String, Object> map);

    <R> Optional<R> findOneByHQL(Class<R> type, ArrayQuery query);

    <R> Optional<R> findOneByHQL(Class<R> type, CollectionQuery query);

    <R> Optional<R> findOneByHQL(Class<R> type, MapQuery query);

    <R> List<R> findAllBySQL(Class<R> type, String sql, Object... objects);

    <R> List<R> findAllBySQL(Class<R> type, String sql, Collection collection);

    <R> List<R> findAllBySQL(Class<R> type, String sql, Map<String, Object> map);

    <R> List<R> findAllByDSL(Class<R> type, SelectQuery<Record> selectQuery);

    <R> List<R> findAllBySQL(Class<R> type, ArrayQuery query);

    <R> List<R> findAllBySQL(Class<R> type, CollectionQuery query);

    <R> List<R> findAllBySQL(Class<R> type, MapQuery query);

    <R> List<R> findAllByHQL(Class<R> type, String hql, Object... objects);

    <R> List<R> findAllByHQL(Class<R> type, String hql, Collection collection);

    <R> List<R> findAllByHQL(Class<R> type, String hql, Map<String, Object> map);

    <R> List<R> findAllByHQL(Class<R> type, ArrayQuery query);

    <R> List<R> findAllByHQL(Class<R> type, CollectionQuery query);

    <R> List<R> findAllByHQL(Class<R> type, MapQuery query);

    <R> List<R> findAllBySQL(Class<R> type, String sql, Object... objects);

    <R> Page<R> findAllBySQL(Class<R> type, String sql, Pageable pageable, Object... objects);

    <R> Page<R> findAllBySQL(Class<R> type, String sql, Pageable pageable, Collection collection);

    <R> Page<R> findAllBySQL(Class<R> type, String sql, Pageable pageable, Map<String, Object> map);

    <R> Page<R> findAllByDSL(Class<R> type, SelectQuery<Record> selectQuery, Pageable pageable);

    <R> Page<R> findAllBySQL(Class<R> type, ArrayQuery query, Pageable pageable);

    <R> Page<R> findAllBySQL(Class<R> type, CollectionQuery query, Pageable pageable);

    <R> Page<R> findAllBySQL(Class<R> type, MapQuery query, Pageable pageable);

    <R> Page<R> findAllByHQL(Class<R> type, String hql, Pageable pageable, Object... objects);

    <R> Page<R> findAllByHQL(Class<R> type, String hql, Pageable pageable, Collection collection);

    <R> Page<R> findAllByHQL(Class<R> type, String hql, Pageable pageable, Map<String, Object> map);

    <R> Page<R> findAllByHQL(Class<R> type, ArrayQuery query, Pageable pageable);

    <R> Page<R> findAllByHQL(Class<R> type, CollectionQuery query, Pageable pageable);

    <R> Page<R> findAllByHQL(Class<R> type, MapQuery query, Pageable pageable);

    <R> Optional<R> findOneBySQLToBean(Class<R> type, String sql, Object... objects);

    <R> Optional<R> findOneBySQLToBean(Class<R> type, String sql, Collection collection);

    <R> Optional<R> findOneBySQLToBean(Class<R> type, String sql, Map<String, Object> map);

    <R> Optional<R> findOneByDSLToBean(Class<R> type, SelectQuery<Record> selectQuery);

    <R> Optional<R> findOneBySQLToBean(Class<R> type, ArrayQuery query);

    <R> Optional<R> findOneBySQLToBean(Class<R> type, CollectionQuery query);

    <R> Optional<R> findOneBySQLToBean(Class<R> type, MapQuery query);

    <R> Optional<R> findOneByHQLToBean(Class<R> type, String hql, Object... objects);

    <R> Optional<R> findOneByHQLToBean(Class<R> type, String hql, Collection collection);

    <R> Optional<R> findOneByHQLToBean(Class<R> type, String hql, Map<String, Object> map);

    <R> Optional<R> findOneByHQLToBean(Class<R> type, ArrayQuery query);

    <R> Optional<R> findOneByHQLToBean(Class<R> type, CollectionQuery query);

    <R> Optional<R> findOneByHQLToBean(Class<R> type, MapQuery query);

    <R> List<R> findAllBySQLToBean(Class<R> type, String sql, Object... objects);

    <R> List<R> findAllBySQLToBean(Class<R> type, String sql, Collection collection);

    <R> List<R> findAllBySQLToBean(Class<R> type, String sql, Map<String, Object> map);

    <R> List<R> findAllByDSLToBean(Class<R> type, SelectQuery<Record> selectQuery);

    <R> List<R> findAllBySQLToBean(Class<R> type, ArrayQuery query);

    <R> List<R> findAllBySQLToBean(Class<R> type, CollectionQuery query);

    <R> List<R> findAllBySQLToBean(Class<R> type, MapQuery query);

    <R> List<R> findAllByHQLToBean(Class<R> type, String hql, Object... objects);

    <R> List<R> findAllByHQLToBean(Class<R> type, String hql, Collection collection);

    <R> List<R> findAllByHQLToBean(Class<R> type, String hql, Map<String, Object> map);

    <R> Page<R> findAllBySQLToBean(Class<R> type, String sql, Pageable pageable, Object... objects);

    <R> Page<R> findAllBySQLToBean(Class<R> type, String sql, Pageable pageable, Collection collection);

    <R> Page<R> findAllBySQLToBean(Class<R> type, String sql, Pageable pageable, Map<String, Object> map);

    <R> Page<R> findAllByDSLToBean(Class<R> type, SelectQuery<Record> selectQuery, Pageable pageable);

    <R> List<R> findAllByHQLToBean(Class<R> type, ArrayQuery query);

    <R> List<R> findAllByHQLToBean(Class<R> type, CollectionQuery query);

    <R> Page<R> findAllByHQLToBean(Class<R> type, MapQuery query);

    <R> Page<R> findAllBySQLToBean(Class<R> type, MapQuery query, Pageable pageable);

    <R> Page<R> findAllByHQLToBean(Class<R> type, String hql, Pageable pageable, Object... objects);

    <R> Page<R> findAllByHQLToBean(Class<R> type, String hql, Pageable pageable, Collection collection);

    <R> Page<R> findAllByHQLToBean(Class<R> type, String hql, Pageable pageable, Map<String, Object> map);

    <R> Page<R> findAllBySQLToBean(Class<R> type, ArrayQuery query, Pageable pageable);

    <R> Page<R> findAllBySQLToBean(Class<R> type, CollectionQuery query, Pageable pageable);

    <R> Page<R> findAllByHQLToBean(Class<R> type, ArrayQuery query, Pageable pageable);

    <R> Page<R> findAllByHQLToBean(Class<R> type, CollectionQuery query, Pageable pageable);

    <R> Page<R> findAllByHQLToBean(Class<R> type, MapQuery query, Pageable pageable);

    Optional<Map<String, Object>> findOneBySQLToMap(String sql, Object... objects);

    Optional<Map<String, Object>> findOneBySQLToMap(String sql, Collection collection);

    Optional<Map<String, Object>> findOneBySQLToMap(String sql, Map<String, Object> map);

    Optional<Map<String, Object>> findOneByDSLToMap(SelectQuery<Record> selectQuery);

    Optional<Map<String, Object>> findOneBySQLToMap(ArrayQuery query);

    Optional<Map<String, Object>> findOneBySQLToMap(CollectionQuery query);

    Optional<Map<String, Object>> findOneBySQLToMap(MapQuery query);

    Optional<Map<String, Object>> findOneByHQLToMap(String sql, Object... objects);

    Optional<Map<String, Object>> findOneByHQLToMap(String sql, Collection collection);

    Optional<Map<String, Object>> findOneByHQLToMap(String sql, Map<String, Object> map);

    Optional<Map<String, Object>> findOneByHQLToMap(ArrayQuery query);

    Optional<Map<String, Object>> findOneByHQLToMap(CollectionQuery query);

    Optional<Map<String, Object>> findOneByHQLToMap(MapQuery query);

    List<Map<String, Object>> findAllBySQLToMap(String sql, Object... objects);

    List<Map<String, Object>> findAllBySQLToMap(String sql, Collection objects);

    List<Map<String, Object>> findAllBySQLToMap(String sql, Map<String, Object> objects);

    List<Map<String, Object>> findAllByDSLToMap(SelectQuery<Record> selectQuery);

    List<Map<String, Object>> findAllBySQLToMap(ArrayQuery query);

    List<Map<String, Object>> findAllBySQLToMap(CollectionQuery query);

    List<Map<String, Object>> findAllBySQLToMap(MapQuery query);

    List<Map<String, Object>> findAllByHQLToMap(String hql, Object... objects);

    List<Map<String, Object>> findAllByHQLToMap(String hql, Collection objects);

    List<Map<String, Object>> findAllByHQLToMap(String hql, Map<String, Object> objects);

    List<Map<String, Object>> findAllByHQLToMap(ArrayQuery query);
}
