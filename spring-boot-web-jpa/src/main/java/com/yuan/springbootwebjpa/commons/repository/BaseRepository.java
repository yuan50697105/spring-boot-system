package com.yuan.springbootwebjpa.commons.repository;

import com.yuan.springbootwebjpa.commons.entity.dto.ArrayQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.CollectionQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/10 22:03
 **/
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    void executeBySQL(String sql, Object... objects);

    void executeBySQL(ArrayQuery query);

    void executeBySQL(String sql, Collection collection);

    void executeBySQL(CollectionQuery query);

    void executeBySQL(String sql, Map<String, Object> map);

    void executeBySQL(MapQuery query);

    void executeByDSL(Query query);

    Optional<T> findOneBySQL(String sql, Object... objects);

    Optional<T> findOneBySQL(ArrayQuery query);

    Optional<T> findOneBySQL(String sql, Collection collection);

    Optional<T> findOneBySQL(CollectionQuery query);

    Optional<T> findOneBySQL(String sql, Map<String, Object> map);

    Optional<T> findOneBySQL(MapQuery query);

    Optional<T> findOneByHQL(String hql, Object... objects);

    Optional<T> findOneByHQL(ArrayQuery query);

    Optional<T> findOneByHQL(String hql, Collection collection);

    Optional<T> findOneByHQL(CollectionQuery query);

    Optional<T> findOneByHQL(String hql, Map<String, Object> map);

    Optional<T> findOneByHQL(MapQuery query);

    Optional<T> findOneByDSL(SelectQuery<Record> selectQuery);

    <R> Optional<R> findOneBySQL(Class<R> type, String sql, Object... objects);

    <R> Optional<R> findOneBySQL(Class<R> type, ArrayQuery query);

    <R> Optional<R> findOneBySQL(Class<R> type, String sql, Collection collection);

    <R> Optional<R> findOneBySQL(Class<R> type, CollectionQuery query);

    <R> Optional<R> findOneBySQL(Class<R> type, String sql, Map<String, Object> map);

    <R> Optional<R> findOneBySQL(Class<R> type, MapQuery query);

    <R> Optional<R> findOneByDSL(Class<R> type, SelectQuery<Record> selectQuery);

    <R> Optional<R> findOneByHQL(Class<R> type, String hql, Object... objects);

    <R> Optional<R> findOneByHQL(Class<R> type, ArrayQuery query);

    <R> Optional<R> findOneByHQL(Class<R> type, String hql, Collection collection);

    <R> Optional<R> findOneByHQL(Class<R> type, CollectionQuery query);

    <R> Optional<R> findOneByHQL(Class<R> type, String hql, Map<String, Object> map);

    <R> Optional<R> findOneByHQL(Class<R> type, MapQuery query);

    Optional<Map<String, Object>> findOneBySQLToMap(String sql, Object... objects);

    Optional<Map<String, Object>> findOneBySQLToMap(ArrayQuery query);

    Optional<Map<String, Object>> findOneBySQLToMap(String sql, Collection collection);

    Optional<Map<String, Object>> findOneBySQLToMap(CollectionQuery query);

    Optional<Map<String, Object>> findOneBySQLToMap(String sql, Map<String, Object> map);

    Optional<Map<String, Object>> findOneBySQLToMap(MapQuery query);

    Optional<Map<String, Object>> findOneByDSLToMap(SelectQuery<Record> selectQuery);

    Optional<Map<String, Object>> findOneByHQLToMap(String hql, Object... objects);

    Optional<Map<String, Object>> findOneByHQLToMap(ArrayQuery query);

    Optional<Map<String, Object>> findOneByHQLToMap(String hql, Collection collection);

    Optional<Map<String, Object>> findOneByHQLToMap(CollectionQuery query);

    Optional<Map<String, Object>> findOneByHQLToMap(String hql, Map<String, Object> map);

    Optional<Map<String, Object>> findOneByHQLToMap(MapQuery query);

    List<T> findAllBySQL(String sql, Object... objects);

    List<T> findAllBySQL(ArrayQuery query);

    List<T> findAllBySQL(String sql, Collection collection);

    List<T> findAllBySQL(CollectionQuery query);

    List<T> findAllBySQL(String sql, Map<String, Object> map);

    List<T> findAllBySQL(MapQuery query);

    List<T> findAllByDSL(SelectQuery<Record> selectQuery);

    List<T> findAllByHQL(String hql, Object... objects);

    List<T> findAllByHQL(ArrayQuery query);

    List<T> findAllByHQL(String hql, Collection collection);

    List<T> findAllByHQL(CollectionQuery query);

    List<T> findAllByHQL(String hql, Map<String, Object> map);

    List<T> findAllByHQL(MapQuery query);

    <R> List<R> findAllBySQL(Class<R> type, String sql, Object... objects);

    <R> List<R> findAllBySQL(Class<R> type, ArrayQuery query);

    <R> List<R> findAllBySQL(Class<R> type, String sql, Collection collection);

    <R> List<R> findAllBySQL(Class<R> type, CollectionQuery query);


}
