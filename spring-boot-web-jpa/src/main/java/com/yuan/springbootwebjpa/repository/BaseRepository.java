package com.yuan.springbootwebjpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/10 22:03
 **/
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    int executeBySQL(String sql, Object... objects);

    int executeBySQL(String sql, Map<String, Object> map);

    int executeByHQL(String sql, Object... objects);

    int executeByHQL(String sql, Map<String, Object> map);

    int execueteByStore(String sql, Object... objects);

    int executeByStore(String sql, Map<String, Object> map);

    Optional<T> findOneBySQL(String sql, Object... objects);

    Optional<T> findOneBySQL(String sql, Map<String, Object> map);

    Optional<T> findOneByHQL(String hql, Object... objects);

    Optional<T> findOneByHQL(String hql, Map<String, Object> map);

    <R> Optional<R> findOneBySQL(String sql, Class<R> type, Object... objects);

    <R> Optional<R> findOneBySQL(String sql, Class<R> type, Map<String, Object> map);

    <R> Optional<R> findOneByHQL(String hql, Class<R> type, Object... objects);

    <R> Optional<R> findOneByHQL(String hql, Class<R> type, Map<String, Object> map);

    Optional<Map<String, Object>> findOneBySQLToMap(String sql, Object... objects);

    Optional<Map<String, Object>> findOneBySQLToMap(String sql, Map<String, Object> map);

    Optional<Map<String, Object>> findOneByHQLToMap(String hql, Object... objects);

    Optional<Map<String, Object>> findOneByHQLToMap(String hql, Map<String, Object> map);

    List<T> findAllBySQL(String sql, Object... objects);

    List<T> findAllBySQL(String sql, Map<String, Object> map);

    List<T> findAllByHQL(String hql, Object... objects);

    List<T> findAllByHQL(String hql, Map<String, Object> map);

    <R> List<R> findAllBySQL(String sql, Class<R> type, Object... objects);

    <R> List<R> findAllBySQL(String sql, Class<R> type, Map<String, Object> map);

    <R> List<R> findAllByHQL(String hql, Class<R> type, Object... objects);

    <R> List<R> findAllByHQL(String hql, Class<R> type, Map<String, Object> map);

    List<Map<String, Object>> findAllBySQLToMap(String sql, Object... objects);

    List<Map<String, Object>> findAllBySQLToMap(String sql, Map<String, Object> map);

    List<Map<String, Object>> findAllByHQLToMap(String hql, Object... objects);

    List<Map<String, Object>> findAllByHQLToMap(String hql, Map<String, Object> map);

    Page<T> findAllBySQL(String sql, Pageable pageable, Object... objects);

    Page<T> findAllBySQL(String sql, Pageable pageable, Map<String, Object> map);

    Page<T> findAllByHQL(String hql, Pageable pageable, Object... objects);

    Page<T> findAllByHQL(String hql, Pageable pageable, Map<String, Object> map);

    <R> Page<R> findAllBySQL(String sql, Class<R> type, Pageable pageable, Object... objects);

    <R> Page<R> findAllBySQL(String sql, Class<R> type, Pageable pageable, Map<String, Object> map);

    <R> Page<R> findAllByHQL(String hql, Class<R> type, Pageable pageable, Object... objects);

    <R> Page<R> findAllByHQL(String hql, Class<R> type, Pageable pageable, Map<String, Object> map);

    Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Object... objects);

    Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Map<String, Object> map);

    Page<Map<String, Object>> findAllByHQLToMap(String hql, Pageable pageable, Object... objects);

    Page<Map<String, Object>> findAllByHQLToMap(String hql, Pageable pageable, Map<String, Object> map);

    Optional<T> findOneByStore(String store, Object... objects);

    Optional<T> findOneByStore(String store, Map<String, Object> map);

    <R> Optional<T> findOneByStore(String store, Class<R> type, Object... objects);

    <R> Optional<T> findOneByStore(String store, Class<R> type, Map<String, Object> map);

    Optional<Map<String, Object>> findOneByStoreToMap(String store, Object... objects);

    Optional<Map<String, Object>> findOneByStoreToMap(String store, Map<String, Object> map);

    List<T> findAllByStore(String store, Object... objects);

    List<T> findAllByStore(String store, Map<String, Object> map);

    <R> List<T> findAllByStore(String store, Class<R> type, Object... objects);

    <R> List<T> findAllByStore(String store, Class<R> type, Map<String, Object> map);

    List<Map<String, Object>> findAllByStoreToMap(String store, Object... objects);

    List<Map<String, Object>> findAllByStoreToMap(String store, Map<String, Object> map);
}
