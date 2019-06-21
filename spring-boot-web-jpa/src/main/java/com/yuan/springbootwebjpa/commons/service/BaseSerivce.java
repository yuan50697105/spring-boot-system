package com.yuan.springbootwebjpa.commons.service;

import com.yuan.springbootwebjpa.commons.entity.bo.BaseQueryParam;
import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    List<T> findAllById(Iterable<ID> ids);

    Optional<T> findOneByExample(T t);

    List<T> findAll();

    List<T> findAll(T t);

    List<T> findAll(T t, Sort sort);

    Page<T> findAll(Pageable pageable);

    Page<T> findAll(T t, Pageable pageable);

    Optional<T> findOneBySQL(BaseQueryParam queryParam, BaseQueryParam.QueryType queryType);

    List<T> findAllBySQL(BaseQueryParam queryParam, BaseQueryParam.QueryType queryType);

    Page<T> findAllBySQL(BaseQueryParam queryParam, Pageable pageable, BaseQueryParam.QueryType queryType);

    Optional<Map<String, Object>> findOneBySQLToMap(BaseQueryParam queryParam, BaseQueryParam.QueryType queryType);

    List<Map<String, Object>> findAllBySQLToMap(BaseQueryParam queryParam, BaseQueryParam.QueryType queryType);

    Page<Map<String, Object>> findAllBySQLToMap(BaseQueryParam queryParam, Pageable pageable, BaseQueryParam.QueryType queryType);

    Optional<T> findOneBySQL(String sql, Object... objects);

    Optional<T> findOneBySQL(String sql, Collection collection);

    Optional<T> findOneBySQL(String sql, Map<String, Object> map);

    Optional<T> findOneByHQL(String hql, Object... objects);

    List<T> findAllBySQL(String sql, Object... objects);

    Page<T> findAllBySQL(String sql, Pageable pageable, Object... objects);

    List<T> findAllBySQL(String sql, Collection collections);

    Page<T> findAllBySQL(String sql, Pageable pageable, Collection collections);

    List<T> findAllBySQL(String sql, Map<String, Object> map);

    Page<T> findAllBySQL(String sql, Pageable pageable, Map<String, Object> map);
}
