package com.yuan.springbootwebjpa.commons.repository;

import com.yuan.springbootwebjpa.commons.entity.dto.ArrayQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/10 22:03
 * ToMap 是结果集为map，ToBean是用于VO实体，其他的都是针对持久类实体与基础类型
 **/
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    EntityManager getEntityManager();

    DSLContext getDslContext();

    Optional<T> findOne(SelectQuery<Record> selectQuery);

    <R> Optional<R> findOne(Class<R> type, SelectQuery<Record> selectQuery);

    Optional<Map<String, Object>> findOneToMap(SelectQuery<Record> selectQuery);

    <R> Optional<R> findOneToBean(Class<R> type, SelectQuery<Record> selectQuery);

    List<T> findAll(SelectQuery<Record> selectQuery);

    <R> List<R> findAll(Class<R> type, SelectQuery<Record> selectQuery);

    List<Map<String, Object>> findAllToMap(SelectQuery<Record> selectQuery);

    <R> List<R> findAllToBean(Class<R> type, SelectQuery<Record> selectQuery);

    Page<T> findAll(SelectQuery<Record> selectQuery, Pageable pageable);

    <R> Page<R> findAll(Class<R> type, SelectQuery<Record> selectQuery, Pageable pageable);

    Page<Map<String, Object>> findAllToMap(SelectQuery<Record> selectQuery, Pageable pageable);

    <R> Page<R> findAllToBean(Class<R> type, SelectQuery<Record> selectQuery, Pageable pageable);

    Optional<T> findOneByQuery(ArrayQuery query);

    <R> Optional<R> findOneByQuery(Class<R> type, ArrayQuery query);

    Optional<Map<String, Object>> findOneByQueryToMap(ArrayQuery query);

    <R> Optional<R> findOneByQueryToBean(Class<R> type, ArrayQuery query);

    Optional<T> findOneByQuery(MapQuery query);

    <R> Optional<R> findOneByQuery(Class<R> type, MapQuery query);

    Optional<Map<String, Object>> findOneByQueryToMap(MapQuery query);

    <R> Optional<R> findOneByQueryToBean(Class<R> type, MapQuery query);

    List<T> findAllByQuery(ArrayQuery query);

    <R> List<R> findAllByQuery(Class<R> type, ArrayQuery query);

    List<Map<String, Object>> findAllByQueryToMap(ArrayQuery query);

    <R> List<R> findAllByQueryToBean(Class<R> type, ArrayQuery query);

    List<T> findAllByQuery(MapQuery query);

    <R> List<R> findAllByQuery(Class<R> type, MapQuery query);

    List<Map<String, Object>> findAllByQueryToMap(MapQuery query);

    <R> List<R> findAllByQueryToBean(Class<R> type, MapQuery query);

    Page<T> findAllByQuery(ArrayQuery query, Pageable pageable);

    <R> Page<R> findAllByQuery(Class<R> type, ArrayQuery query, Pageable pageable);

    Page<Map<String, Object>> findAllByQueryToMap(ArrayQuery query, Pageable pageable);

    <R> Page<R> findAllByQueryToBean(Class<R> type, ArrayQuery query, Pageable pageable);

    Page<T> findAllByQuery(MapQuery query, Pageable pageable);

    <R> Page<R> findAllByQuery(Class<R> type, MapQuery query, Pageable pageable);

    Page<Map<String, Object>> findAllByQueryToMap(MapQuery query, Pageable pageable);

    <R> Page<R> findAllByQueryToBean(Class<R> type, MapQuery query, Pageable pageable);

    Optional<T> findOneBySQLQuery(ArrayQuery query);

    <R> Optional<R> findOneBySQLQuery(Class<R> type, ArrayQuery query);

    Optional<Map<String, Object>> findOneBySQLQueryToMap(ArrayQuery query);

    <R> Optional<R> findOneBySQLQueryToBean(Class<R> type, ArrayQuery query);

    Optional<T> findOneBySQLQuery(MapQuery query);

    <R> Optional<R> findOneBySQLQuery(Class<R> type, MapQuery query);

    Optional<Map<String, Object>> findOneBySQLQueryToMap(MapQuery query);

    <R> Optional<R> findOneBySQLQueryToBean(Class<R> type, MapQuery query);

    List<T> findAllBySQLQuery(ArrayQuery query);

    <R> List<R> findAllBySQLQuery(Class<R> type, ArrayQuery query);

    List<Map<String, Object>> findAllBySQLQueryToMap(ArrayQuery query);

    <R> List<R> findAllBySQLQueryToBean(Class<R> type, ArrayQuery query);

    List<T> findAllBySQLQuery(MapQuery query);

    <R> List<R> findAllBySQLQuery(Class<R> type, MapQuery query);

    List<Map<String, Object>> findAllBySQLQueryToMap(MapQuery query);

    <R> List<R> findAllBySQLQueryToBean(Class<R> type, MapQuery query);

    Page<T> findAllBySQLQuery(ArrayQuery query, Pageable pageable);

    <R> Page<R> findAllBySQLQuery(Class<R> type, ArrayQuery query, Pageable pageable);

    Page<Map<String, Object>> findAllBySQLQueryToMap(ArrayQuery query, Pageable pageable);

    <R> Page<R> findAllBySQLQueryToBean(Class<R> type, ArrayQuery query, Pageable pageable);

    Page<T> findAllBySQLQuery(MapQuery query, Pageable pageable);

    <R> Page<R> findAllBySQLQuery(Class<R> type, MapQuery query, Pageable pageable);

    Page<Map<String, Object>> findAllBySQLQueryToMap(MapQuery query, Pageable pageable);

    <R> Page<R> findAllBySQLQueryToBean(Class<R> type, MapQuery query, Pageable pageable);
}
