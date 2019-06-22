package com.yuan.springbootwebjpa.commons.repository.impl;

import com.yuan.springbootwebjpa.commons.entity.dto.ArrayQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.CollectionQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 17:09
 **/
@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
    private final EntityManager entityManager;
    private final JpaEntityInformation<T, ?> entityInformation;
    private final DSLContext dslContext;


    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager, DSLContext dslContext) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
        this.dslContext = dslContext;
    }

    @Override
    public void executeBySQL(String sql, Object... objects) {

    }

    @Override
    public void executeBySQL(ArrayQuery query) {
        executeBySQL(query.getSql(), query.getObjects());
    }

    @Override
    public void executeBySQL(String sql, Collection collection) {

    }

    @Override
    public void executeBySQL(CollectionQuery query) {
        executeBySQL(query.getSql(), query.getCollection());
    }

    @Override
    public void executeBySQL(String sql, Map<String, Object> map) {

    }

    @Override
    public void executeBySQL(MapQuery query) {
        executeBySQL(query.getSql(), query.getMap());
    }

    @Override
    public void executeByDSL(Query query) {

    }

    @Override
    public Optional<T> findOneBySQL(String sql, Object... objects) {
        return Optional.empty();
    }

    @Override
    public Optional<T> findOneBySQL(ArrayQuery query) {
        return findOneBySQL(query.getSql(), query.getObjects());
    }

    @Override
    public Optional<T> findOneBySQL(String sql, Collection collection) {
        return findOneBySQL(sql, collection.toArray());
    }


    @Override
    public Optional<T> findOneBySQL(CollectionQuery query) {
        return findOneBySQL(query.getSql(), query.getCollection());
    }

    @Override
    public Optional<T> findOneBySQL(String sql, Map<String, Object> map) {
        return Optional.empty();
    }

    @Override
    public Optional<T> findOneBySQL(MapQuery query) {
        return findOneBySQL(query.getSql(), query.getMap());
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Object... objects) {
        return Optional.empty();
    }

    @Override
    public Optional<T> findOneByHQL(ArrayQuery query) {
        return findOneByHQL(query.getSql(), query.getObjects());
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Collection collection) {
        return Optional.empty();
    }

    @Override
    public Optional<T> findOneByHQL(CollectionQuery query) {
        return findOneByHQL(query.getSql(), query.getCollection());
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Map<String, Object> map) {
        return Optional.empty();
    }

    @Override
    public Optional<T> findOneByHQL(MapQuery query) {
        return findOneByHQL(query.getSql(), query.getMap());
    }

    @Override
    public Optional<T> findOneByDSL(SelectQuery<Record> selectQuery) {
        return Optional.empty();
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, String sql, Object... objects) {
        return Optional.empty();
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, ArrayQuery query) {
        return findOneBySQL(type, query.getSql(), query.getObjects());
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, String sql, Collection collection) {
        return Optional.empty();
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, CollectionQuery query) {
        return findOneBySQL(type, query.getSql(), query.getCollection());
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, String sql, Map<String, Object> map) {
        return Optional.empty();
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, MapQuery query) {
        return findOneBySQL(type, query.getSql(), query.getMap());
    }

    @Override
    public <R> Optional<R> findOneByDSL(Class<R> type, SelectQuery<Record> selectQuery) {
        return Optional.empty();
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, String hql, Object... objects) {
        return Optional.empty();
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, ArrayQuery query) {
        return findOneByHQL(type, query.getSql(), query.getObjects());
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, String hql, Collection collection) {
        return Optional.empty();
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, CollectionQuery query) {
        return findOneByHQL(type, query.getSql(), query.getCollection());
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, String hql, Map<String, Object> map) {
    }


    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, MapQuery query) {
        return findOneByHQL(type, query.getSql(), query.getMap());
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(String sql, Object... objects) {
        return Optional.empty();
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(ArrayQuery query) {
        return findOneBySQLToMap(query.getSql(), query.getObjects());
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(String sql, Collection collection) {
        return Optional.empty();
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(CollectionQuery query) {
        return findOneBySQLToMap(query.getSql(), query.getCollection());
    }


    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(String sql, Map<String, Object> map) {
        return Optional.empty();
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(MapQuery query) {
        return findOneBySQLToMap(query.getSql(), query.getMap());
    }

    @Override
    public Optional<Map<String, Object>> findOneByDSLToMap(SelectQuery<Record> selectQuery) {
        return Optional.empty();
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(String hql, Object... objects) {
        return Optional.empty();
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(ArrayQuery query) {
        return findOneByHQLToMap(query.getSql(), query.getObjects());
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(String hql, Collection collection) {
        return Optional.empty();
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(CollectionQuery query) {
        return findOneByHQLToMap(query.getSql(), query.getCollection());
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(String hql, Map<String, Object> map) {
        return Optional.empty();
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(MapQuery query) {
        return findOneByHQLToMap(query.getSql(), query.getMap());
    }

    @Override
    public List<T> findAllBySQL(String sql, Object... objects) {
        return null;
    }

    @Override
    public List<T> findAllBySQL(ArrayQuery query) {
        return findAllBySQL(query.getSql(), query.getObjects());
    }

    @Override
    public List<T> findAllBySQL(String sql, Collection collection) {
        return null;
    }

    @Override
    public List<T> findAllBySQL(CollectionQuery query) {
        return findAllBySQL(query.getSql(), query.getCollection());
    }

    @Override
    public List<T> findAllBySQL(String sql, Map<String, Object> map) {
        return null;
    }

    @Override
    public List<T> findAllBySQL(MapQuery query) {
        return findAllBySQL(query.getSql(), query.getMap());
    }

    @Override
    public List<T> findAllByDSL(SelectQuery<Record> selectQuery) {
        return null;
    }

    @Override
    public List<T> findAllByHQL(String hql, Object... objects) {
        return null;
    }

    @Override
    public List<T> findAllByHQL(ArrayQuery query) {
        return findAllByHQL(query.getSql(), query.getObjects());
    }

    @Override
    public List<T> findAllByHQL(String hql, Collection collection) {
        return findAllByHQL(hql, collection.toArray());
    }

    @Override
    public List<T> findAllByHQL(CollectionQuery query) {
        return findAllByHQL(query.getSql(), query.getCollection());
    }

    @Override
    public List<T> findAllByHQL(String hql, Map<String, Object> map) {
        return null;
    }

    @Override
    public List<T> findAllByHQL(MapQuery query) {
        return findAllByHQL(query.getSql(), query.getMap());
    }

    @Override
    public <R> List<R> findAllBySQL(Class<R> type, String sql, Object... objects) {
        return null;
    }

    @Override
    public <R> List<R> findAllBySQL(Class<R> type, ArrayQuery query) {
        return findAllBySQL(type, query.getSql(), query.getObjects());
    }

    @Override
    public <R> List<R> findAllBySQL(Class<R> type, String sql, Collection collection) {
        return findAllBySQL(type, sql, collection.toArray());
    }

    @Override
    public <R> List<R> findAllBySQL(Class<R> type, CollectionQuery query) {
        return null;
    }

    @Override
    public <R> List<R> findAllByDSL(Class<R> type, SelectQuery<Record> selectQuery) {
        return null;
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, String hql, Object... objects) {
        return null;
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, ArrayQuery query) {
        return null;
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, String hql, Collection collection) {
        return null;
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, CollectionQuery query) {
        return null;
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, String hql, Map<String, Object> map) {
        return null;
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, MapQuery query) {
        return null;
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Object... objects) {
        return null;
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(ArrayQuery query) {
        return null;
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Collection collection) {
        return null;
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(CollectionQuery query) {
        return null;
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(MapQuery query) {
        return null;
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Object... objects) {
        return null;
    }

    @Override
    public Page<T> findAllBySQL(ArrayQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Collection collection) {
        return null;
    }

    @Override
    public Page<T> findAllBySQL(CollectionQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Map<String, Object> map) {
        return null;
    }

    @Override
    public Page<T> findAllByDSL(SelectQuery<Record> selectQuery, Pageable pageable) {
        return null;
    }

    @Override
    public Page<T> findAllByHQL(String hql, Pageable pageable, Object... objects) {
        return null;
    }

    @Override
    public Page<T> findAllByHQL(ArrayQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public Page<T> findAllByHQL(String hql, Pageable pageable, Collection collection) {
        return null;
    }

    @Override
    public Page<T> findAllByHQL(CollectionQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public Page<T> findAllByHQL(String hql, Pageable pageable, Map<String, Object> map) {
        return null;
    }

    @Override
    public Page<T> findAllByHQL(MapQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, String sql, Pageable pageable, Object... objects) {
        return null;
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, ArrayQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, String sql, Pageable pageable, Collection collection) {
        return null;
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, CollectionQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, String sql, Pageable pageable, Map<String, Object> map) {
        return null;
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, MapQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public <R> Page<R> findAllByDSL(Class<R> type, SelectQuery<Record> selectQuery, Pageable pageable) {
        return null;
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, String hql, Pageable pageable, Object... objects) {
        return null;
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, ArrayQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, String hql, Pageable pageable, Collection collection) {
        return null;
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, CollectionQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, String hql, Pageable pageable, Map<String, Object> map) {
        return null;
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, MapQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Object... objects) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(ArrayQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Collection collection) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(CollectionQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Map<String, Object> map) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(MapQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllByDSLToMap(SelectQuery<Record> selectQuery, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(String sql, Pageable pageable, Object... objects) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(ArrayQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(String hql, Pageable pageable, Collection collection) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(CollectionQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(String hql, Pageable pageable, Map<String, Object> map) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(MapQuery query, Pageable pageable) {
        return null;
    }
}
