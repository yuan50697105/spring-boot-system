package com.yuan.springbootwebjpa.commons.repository.impl;

import com.yuan.springbootwebjpa.commons.entity.dto.ArrayQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.CollectionQuery;
import com.yuan.springbootwebjpa.commons.entity.dto.MapQuery;
import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.query.internal.QueryImpl;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 17:09
 **/
@SuppressWarnings({"Duplicates", "unchecked"})
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
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public DSLContext getDslContext() {
        return dslContext;
    }

    @Override
    public void executeBySQL(String sql, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.executeUpdate();
    }

    @Override
    public void executeBySQL(ArrayQuery query) {
        executeBySQL(query.getSql(), query.getObjects());
    }

    @Override
    public void executeBySQL(String sql, Collection collection) {
        executeBySQL(sql, collection.toArray());
    }

    @Override
    public void executeBySQL(CollectionQuery query) {
        executeBySQL(query.getSql(), query.getCollection());
    }

    @Override
    public void executeBySQL(String sql, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.executeUpdate();
    }

    @Override
    public void executeBySQL(MapQuery query) {
        executeBySQL(query.getSql(), query.getMap());
    }

    @Override
    public void executeByDSL(Query query) {
        dslContext.execute(query.getSQL(), query.getBindValues());
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<T> findOneBySQL(String sql, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, entityInformation.getJavaType());
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        return Optional.ofNullable((T) nativeQuery.getSingleResult());
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

    @SuppressWarnings("unchecked")
    @Override
    public Optional<T> findOneBySQL(String sql, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, entityInformation.getJavaType());
        map.forEach(nativeQuery::setParameter);
        return Optional.ofNullable((T) nativeQuery.getSingleResult());
    }

    @Override
    public Optional<T> findOneBySQL(MapQuery query) {
        return findOneBySQL(query.getSql(), query.getMap());
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Object... objects) {
        TypedQuery<T> query = entityManager.createQuery(hql, entityInformation.getJavaType());
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i + 1, objects[i]);
        }
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Optional<T> findOneByHQL(ArrayQuery query) {
        return findOneByHQL(query.getSql(), query.getObjects());
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Collection collection) {
        return findOneByHQL(hql, collection.toArray());
    }

    @Override
    public Optional<T> findOneByHQL(CollectionQuery query) {
        return findOneByHQL(query.getSql(), query.getCollection());
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Map<String, Object> map) {
        TypedQuery<T> query = entityManager.createQuery(hql, entityInformation.getJavaType());
        map.forEach(query::setParameter);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Optional<T> findOneByHQL(MapQuery query) {
        return findOneByHQL(query.getSql(), query.getMap());
    }

    @Override
    public Optional<T> findOneByDSL(SelectQuery<Record> selectQuery) {
        selectQuery = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findOneBySQL(selectQuery.getSQL(), selectQuery.getBindValues());
    }

    @SuppressWarnings("unchecked")
    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, String sql, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, type);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        return Optional.ofNullable(((R) nativeQuery.getSingleResult()));
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, ArrayQuery query) {
        return findOneBySQL(type, query.getSql(), query.getObjects());
    }

    @Override
    public <R> Optional<R> findOneBySQL(Class<R> type, String sql, Collection collection) {
        return findOneBySQL(type, sql, collection.toArray());
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
        selectQuery = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findOneBySQL(type, selectQuery.getSQL(), selectQuery.getBindValues());
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, String hql, Object... objects) {
        TypedQuery<R> query = entityManager.createQuery(hql, type);
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i + 1, objects[i]);
        }
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, ArrayQuery query) {
        return findOneByHQL(type, query.getSql(), query.getObjects());
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, String hql, Collection collection) {
        return findOneByHQL(type, hql, collection.toArray());
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, CollectionQuery query) {
        return findOneByHQL(type, query.getSql(), query.getCollection());
    }

    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, String hql, Map<String, Object> map) {
        TypedQuery<R> query = entityManager.createQuery(hql, type);
        map.forEach(query::setParameter);
        return Optional.ofNullable(query.getSingleResult());
    }


    @Override
    public <R> Optional<R> findOneByHQL(Class<R> type, MapQuery query) {
        return findOneByHQL(type, query.getSql(), query.getMap());
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, String sql, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return Optional.ofNullable(((R) nativeQuery.getSingleResult()));
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, ArrayQuery query) {
        return findOneBySQLToBean(type, query.getSql(), query.getObjects());
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, String sql, Collection collection) {
        return findOneBySQLToBean(type, sql, collection.toArray());
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, CollectionQuery query) {
        return findOneBySQLToBean(type, query.getSql(), query.getCollection());
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, String sql, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return Optional.ofNullable(((R) nativeQuery.getSingleResult()));
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, MapQuery query) {
        return findOneBySQLToBean(type, query.getSql(), query.getMap());
    }

    @Override
    public <R> Optional<R> findOneBySQLToBean(Class<R> type, SelectQuery<Record> selectQuery) {
        selectQuery = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery).asTable()).getQuery();
        return findOneBySQLToBean(type, selectQuery.getSQL(), selectQuery.getBindValues());
    }

    @Override
    public <R> Optional<R> findOneByHQLToBean(Class<R> type, String hql, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createQuery(hql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return Optional.ofNullable(((R) nativeQuery.getSingleResult()));
    }

    @Override
    public <R> Optional<R> findOneByHQLToBean(Class<R> type, ArrayQuery query) {
        return findOneByHQLToBean(type, query.getSql(), query.getObjects());
    }

    @Override
    public <R> Optional<R> findOneByHQLToBean(Class<R> type, String hql, Collection collection) {
        return findOneByHQLToBean(type, hql, collection.toArray());
    }

    @Override
    public <R> Optional<R> findOneByHQLToBean(Class<R> type, CollectionQuery query) {
        return findOneByHQLToBean(type, query.getSql(), query.getCollection());
    }

    @Override
    public <R> Optional<R> findOneByHQLToBean(Class<R> type, String hql, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createQuery(hql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return Optional.ofNullable(((R) nativeQuery.getSingleResult()));
    }

    @Override
    public <R> Optional<R> findOneByHQLToBean(Class<R> type, MapQuery query) {
        return findOneByHQLToBean(type, query.getSql(), query.getMap());
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(String sql, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return Optional.ofNullable((Map<String, Object>) nativeQuery.getSingleResult());
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(ArrayQuery query) {
        return findOneBySQLToMap(query.getSql(), query.getObjects());
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(String sql, Collection collection) {
        return findOneBySQLToMap(sql, collection.toArray());
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(CollectionQuery query) {
        return findOneBySQLToMap(query.getSql(), query.getCollection());
    }


    @SuppressWarnings("unchecked")
    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(String sql, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return Optional.ofNullable((Map<String, Object>) nativeQuery.getSingleResult());
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(MapQuery query) {
        return findOneBySQLToMap(query.getSql(), query.getMap());
    }

    @Override
    public Optional<Map<String, Object>> findOneByDSLToMap(SelectQuery<Record> selectQuery) {
        selectQuery = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findOneBySQLToMap(selectQuery.getSQL(), selectQuery.getBindValues());
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(String hql, Object... objects) {
        javax.persistence.Query query = entityManager.createQuery(hql);
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i + 1, objects[i]);
        }
        query.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return Optional.ofNullable((Map<String, Object>) query.getSingleResult());
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(ArrayQuery query) {
        return findOneByHQLToMap(query.getSql(), query.getObjects());
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(String hql, Collection collection) {
        return findOneByHQLToMap(hql, collection.toArray());
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(CollectionQuery query) {
        return findOneByHQLToMap(query.getSql(), query.getCollection());
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(String hql, Map<String, Object> map) {
        javax.persistence.Query query = entityManager.createQuery(hql);
        map.forEach(query::setParameter);
        query.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return Optional.ofNullable((Map<String, Object>) query.getSingleResult());
    }

    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(MapQuery query) {
        return findOneByHQLToMap(query.getSql(), query.getMap());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAllBySQL(String sql, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, entityInformation.getJavaType());
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        return (List<T>) nativeQuery.getResultList();
    }

    @Override
    public List<T> findAllBySQL(ArrayQuery query) {
        return findAllBySQL(query.getSql(), query.getObjects());
    }

    @Override
    public List<T> findAllBySQL(String sql, Collection collection) {
        return findAllBySQL(sql, collection.toArray());
    }

    @Override
    public List<T> findAllBySQL(CollectionQuery query) {
        return findAllBySQL(query.getSql(), query.getCollection());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAllBySQL(String sql, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, entityInformation.getJavaType());
        map.forEach(nativeQuery::setParameter);
        return (List<T>) nativeQuery.getResultList();
    }

    @Override
    public List<T> findAllBySQL(MapQuery query) {
        return findAllBySQL(query.getSql(), query.getMap());
    }

    @Override
    public List<T> findAllByDSL(SelectQuery<Record> selectQuery) {
        selectQuery = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findAllBySQL(selectQuery.getSQL(), selectQuery.getBindValues());
    }

    @Override
    public List<T> findAllByHQL(String hql, Object... objects) {
        TypedQuery<T> query = entityManager.createQuery(hql, entityInformation.getJavaType());
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i + 1, objects[i]);
        }
        return query.getResultList();
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
        TypedQuery<T> query = entityManager.createQuery(hql, entityInformation.getJavaType());
        map.forEach(query::setParameter);
        return query.getResultList();
    }

    @Override
    public List<T> findAllByHQL(MapQuery query) {
        return findAllByHQL(query.getSql(), query.getMap());
    }

    @SuppressWarnings("unchecked")
    @Override
    public <R> List<R> findAllBySQL(Class<R> type, String sql, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, type);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        return (List<R>) nativeQuery.getResultList();
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
        return findAllBySQL(type, query.getSql(), query.getCollection());
    }

    @Override
    public <R> List<R> findAllBySQL(Class<R> type, String sql, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, type);
        map.forEach(nativeQuery::setParameter);
        return nativeQuery.getResultList();
    }

    @Override
    public <R> List<R> findAllBySQL(Class<R> type, MapQuery query) {
        return findAllBySQL(type, query.getSql(), query.getMap());
    }

    @Override
    public <R> List<R> findAllByDSL(Class<R> type, SelectQuery<Record> selectQuery) {
        selectQuery = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findAllBySQL(type, selectQuery.getSQL(), selectQuery.getBindValues());
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, String hql, Object... objects) {
        TypedQuery<R> query = entityManager.createQuery(hql, type);
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i + 1, objects[i]);
        }
        return query.getResultList();
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, ArrayQuery query) {
        return findAllByHQL(type, query.getSql(), query.getObjects());
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, String hql, Collection collection) {
        return findAllByHQL(type, hql, collection.toArray());
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, CollectionQuery query) {
        return findAllByHQL(type, query.getSql(), query.getCollection());
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, String hql, Map<String, Object> map) {
        TypedQuery<R> query = entityManager.createQuery(hql, type);
        map.forEach(query::setParameter);
        return query.getResultList();
    }

    @Override
    public <R> List<R> findAllByHQL(Class<R> type, MapQuery query) {
        return findAllByHQL(type, query.getSql(), query.getMap());
    }

    @Override
    public <R> List<R> findAllBySQLToBean(Class<R> type, String sql, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }

    @Override
    public <R> List<R> findAllBySQLToBean(Class<R> type, ArrayQuery query) {
        return findAllBySQLToBean(type, query.getSql(), query.getObjects());
    }

    @Override
    public <R> List<R> findAllBySQLToBean(Class<R> type, String sql, Collection collection) {
        return findAllBySQLToBean(type, sql, collection.toArray());
    }

    @Override
    public <R> List<R> findAllBySQLToBean(Class<R> type, CollectionQuery query) {
        return findAllBySQLToBean(type, query.getSql(), query.getCollection());
    }

    @Override
    public <R> List<R> findAllBySQLToBean(Class<R> type, String sql, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }

    @Override
    public <R> List<R> findAllBySQLToBean(Class<R> type, MapQuery query) {
        return findAllBySQLToBean(type, query.getSql(), query.getMap());
    }

    @Override
    public <R> List<R> findAllByHQLToBean(Class<R> type, String hql, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createQuery(hql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }

    @Override
    public <R> List<R> findAllByHQLToBean(Class<R> type, ArrayQuery query) {
        return findAllByHQLToBean(type, query.getSql(), query.getObjects());
    }

    @Override
    public <R> List<R> findAllByHQLToBean(Class<R> type, String hql, Collection collection) {
        return findAllByHQLToBean(type, hql, collection.toArray());
    }

    @Override
    public <R> List<R> findAllByHQLToBean(Class<R> type, CollectionQuery query) {
        return findAllByHQLToBean(type, query.getSql(), query.getCollection());
    }

    @Override
    public <R> List<R> findAllByHQLToBean(Class<R> type, String hql, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createQuery(hql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }

    @Override
    public <R> List<R> findAllByHQLToBean(Class<R> type, MapQuery query) {
        return findAllByHQLToBean(type, query.getSql(), query.getMap());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return (List<Map<String, Object>>) nativeQuery.getResultList();
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(ArrayQuery query) {
        return findAllBySQLToMap(query.getSql(), query.getObjects());
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Collection collection) {
        return findAllBySQLToMap(sql, collection.toArray());
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(CollectionQuery query) {
        return findAllBySQLToMap(query.getSql(), query.getCollection());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return (List<Map<String, Object>>) nativeQuery.getResultList();
    }

    @Override
    public List<Map<String, Object>> findAllBySQLToMap(MapQuery query) {
        return findAllBySQLToMap(query.getSql(), query.getMap());
    }

    @SuppressWarnings({"unchecked", "Duplicates"})
    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, entityInformation.getJavaType());
        javax.persistence.Query nativeQuery1 = entityManager.createNativeQuery(createCountSQL(sql), Long.class);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
            nativeQuery1.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        List<T> resultList = nativeQuery.getResultList();
        Long singleResult = (Long) nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public Page<T> findAllBySQL(ArrayQuery query, Pageable pageable) {
        return findAllBySQL(query.getSql(), pageable, query.getObjects());
    }

    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Collection collection) {
        return findAllBySQL(sql, pageable, collection.toArray());
    }

    @Override
    public Page<T> findAllBySQL(CollectionQuery query, Pageable pageable) {
        return findAllBySQL(query.getSql(), pageable, query.getCollection());
    }

    @SuppressWarnings({"Duplicates", "unchecked"})
    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, entityInformation.getJavaType());
        javax.persistence.Query nativeQuery1 = entityManager.createNativeQuery(createCountSQL(sql), Long.class);
        map.forEach(nativeQuery::setParameter);
        map.forEach(nativeQuery1::setParameter);
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        List<T> resultList = nativeQuery.getResultList();
        Long singleResult = (Long) nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public Page<T> findAllBySQL(MapQuery query, Pageable pageable) {
        return findAllBySQL(query.getSql(), pageable, query.getMap());
    }

    @Override
    public Page<T> findAllByDSL(SelectQuery<Record> selectQuery, Pageable pageable) {
        selectQuery = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findAllBySQL(selectQuery.getSQL(), pageable, selectQuery.getBindValues());
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Page<T> findAllByHQL(String hql, Pageable pageable, Object... objects) {
        javax.persistence.TypedQuery<T> nativeQuery = entityManager.createQuery(hql, entityInformation.getJavaType());
        javax.persistence.TypedQuery<Long> nativeQuery1 = entityManager.createQuery(createCountHQL(hql), Long.class);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
            nativeQuery1.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        List<T> resultList = nativeQuery.getResultList();
        Long singleResult = nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public Page<T> findAllByHQL(ArrayQuery query, Pageable pageable) {
        return findAllByHQL(query.getSql(), pageable, query.getObjects());
    }

    @Override
    public Page<T> findAllByHQL(String hql, Pageable pageable, Collection collection) {
        return findAllByHQL(hql, pageable, collection.toArray());
    }

    @Override
    public Page<T> findAllByHQL(CollectionQuery query, Pageable pageable) {
        return findAllByHQL(query.getSql(), pageable, query.getCollection());
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Page<T> findAllByHQL(String hql, Pageable pageable, Map<String, Object> map) {
        javax.persistence.TypedQuery<T> nativeQuery = entityManager.createQuery(hql, entityInformation.getJavaType());
        javax.persistence.TypedQuery<Long> nativeQuery1 = entityManager.createQuery(createCountHQL(hql), Long.class);
        map.forEach(nativeQuery::setParameter);
        map.forEach(nativeQuery1::setParameter);
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        List<T> resultList = nativeQuery.getResultList();
        Long singleResult = nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public Page<T> findAllByHQL(MapQuery query, Pageable pageable) {
        return findAllByHQL(query.getSql(), pageable, query.getMap());
    }

    @SuppressWarnings({"Duplicates", "unchecked"})
    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, String sql, Pageable pageable, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, type);
        javax.persistence.Query nativeQuery1 = entityManager.createNativeQuery(createCountSQL(sql), Long.class);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
            nativeQuery1.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        List<R> resultList = nativeQuery.getResultList();
        Long singleResult = (Long) nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, ArrayQuery query, Pageable pageable) {
        return findAllBySQL(type, query.getSql(), pageable, query.getObjects());
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, String sql, Pageable pageable, Collection collection) {
        return findAllBySQL(type, sql, pageable, collection.toArray());
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, CollectionQuery query, Pageable pageable) {
        return findAllBySQL(type, query.getSql(), pageable, query.getCollection());
    }

    @SuppressWarnings("unchecked")
    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, String sql, Pageable pageable, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql, type);
        javax.persistence.Query nativeQuery1 = entityManager.createNativeQuery(createCountSQL(sql), Long.class);
        map.forEach(nativeQuery::setParameter);
        map.forEach(nativeQuery1::setParameter);
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        List<R> resultList = nativeQuery.getResultList();
        Long singleResult = (Long) nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public <R> Page<R> findAllBySQL(Class<R> type, MapQuery query, Pageable pageable) {
        return findAllBySQL(type, query.getSql(), pageable, query.getMap());
    }

    @Override
    public <R> Page<R> findAllByDSL(Class<R> type, SelectQuery<Record> selectQuery, Pageable pageable) {
        selectQuery = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findAllBySQL(type, selectQuery.getSQL(), pageable, selectQuery.getBindValues());
    }

    @SuppressWarnings("Duplicates")
    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, String hql, Pageable pageable, Object... objects) {
        TypedQuery<R> nativeQuery = entityManager.createQuery(hql, type);
        javax.persistence.TypedQuery<Long> nativeQuery1 = entityManager.createQuery(createCountHQL(hql), Long.class);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
            nativeQuery1.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        List<R> resultList = nativeQuery.getResultList();
        Long singleResult = nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, ArrayQuery query, Pageable pageable) {
        return findAllByHQL(type, query.getSql(), pageable, query.getObjects());
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, String hql, Pageable pageable, Collection collection) {
        return findAllByHQL(type, hql, pageable, collection.toArray());
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, CollectionQuery query, Pageable pageable) {
        return findAllByHQL(type, query.getSql(), pageable, query.getCollection());
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, String hql, Pageable pageable, Map<String, Object> map) {
        TypedQuery<R> nativeQuery = entityManager.createQuery(hql, type);
        javax.persistence.TypedQuery<Long> nativeQuery1 = entityManager.createQuery(createCountHQL(hql), Long.class);
        map.forEach(nativeQuery::setParameter);
        map.forEach(nativeQuery1::setParameter);
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        List<R> resultList = nativeQuery.getResultList();
        Long singleResult = nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public <R> Page<R> findAllByHQL(Class<R> type, MapQuery query, Pageable pageable) {
        return findAllByHQL(type, query.getSql(), pageable, query.getMap());
    }

    @Override
    public <R> Page<R> findAllBySQLToBean(Class<R> type, String sql, Pageable pageable, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        javax.persistence.Query nativeQuery1 = entityManager.createNativeQuery(createCountSQL(sql), Long.class);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
            nativeQuery1.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        List<R> resultList = nativeQuery.getResultList();
        Long singleResult = (Long) nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public <R> Page<R> findAllBySQLToBean(Class<R> type, ArrayQuery query, Pageable pageable) {
        return findAllBySQLToBean(type, query.getSql(), pageable, query.getObjects());
    }

    @Override
    public <R> Page<R> findAllBySQLToBean(Class<R> type, String sql, Pageable pageable, Collection collection) {
        return findAllBySQLToBean(type, sql, pageable, collection.toArray());
    }

    @Override
    public <R> Page<R> findAllBySQLToBean(Class<R> type, CollectionQuery query, Pageable pageable) {
        return findAllBySQLToBean(type, query.getSql(), pageable, query.getCollection());
    }

    @Override
    public <R> Page<R> findAllBySQLToBean(Class<R> type, String sql, Pageable pageable, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        javax.persistence.Query nativeQuery1 = entityManager.createNativeQuery(createCountSQL(sql), Long.class);
        map.forEach(nativeQuery::setParameter);
        map.forEach(nativeQuery1::setParameter);
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        List<R> resultList = nativeQuery.getResultList();
        Long singleResult = (Long) nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public <R> Page<R> findAllBySQLToBean(Class<R> type, MapQuery query, Pageable pageable) {
        return findAllBySQLToBean(type, query.getSql(), pageable, query.getMap());
    }

    @Override
    public <R> Page<R> findAllByHQLToBean(Class<R> type, String hql, Pageable pageable, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(hql);
        javax.persistence.Query nativeQuery1 = entityManager.createQuery(createCountHQL(hql), Long.class);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
            nativeQuery1.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        List<R> resultList = nativeQuery.getResultList();
        Long singleResult = (Long) nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public <R> Page<R> findAllByHQLToBean(Class<R> type, ArrayQuery query, Pageable pageable) {
        return findAllByHQLToBean(type, query.getSql(), pageable, query.getObjects());
    }

    @Override
    public <R> Page<R> findAllByHQLToBean(Class<R> type, String hql, Pageable pageable, Collection collection) {
        return findAllByHQLToBean(type, hql, pageable, collection.toArray());
    }

    @Override
    public <R> Page<R> findAllByHQLToBean(Class<R> type, CollectionQuery query, Pageable pageable) {
        return findAllByHQLToBean(type, query.getSql(), pageable, query.getCollection());
    }

    @Override
    public <R> Page<R> findAllByHQLToBean(Class<R> type, String hql, Pageable pageable, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createQuery(hql);
        javax.persistence.Query nativeQuery1 = entityManager.createNativeQuery(createCountHQL(hql), Long.class);
        map.forEach(nativeQuery::setParameter);
        map.forEach(nativeQuery1::setParameter);
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        List<R> resultList = nativeQuery.getResultList();
        Long singleResult = (Long) nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public <R> Page<R> findAllByHQLToBean(Class<R> type, MapQuery query, Pageable pageable) {
        return findAllByHQLToBean(type, query.getSql(), pageable, query.getMap());
    }

    @SuppressWarnings({"Duplicates", "unchecked"})
    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        javax.persistence.Query nativeQuery1 = entityManager.createNativeQuery(createCountSQL(sql), Long.class);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
            nativeQuery1.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<Map<String, Object>> resultList = nativeQuery.getResultList();
        Long singleResult = (Long) nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(ArrayQuery query, Pageable pageable) {
        return findAllBySQLToMap(query.getSql(), pageable, query.getObjects());
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Collection collection) {
        return findAllBySQLToMap(sql, pageable, collection.toArray());
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(CollectionQuery query, Pageable pageable) {
        return findAllBySQLToMap(query.getSql(), pageable, query.getCollection());
    }

    @SuppressWarnings({"Duplicates", "unchecked"})
    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(sql);
        javax.persistence.Query nativeQuery1 = entityManager.createNativeQuery(createCountSQL(sql), Long.class);
        map.forEach(nativeQuery::setParameter);
        map.forEach(nativeQuery1::setParameter);
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<Map<String, Object>> resultList = nativeQuery.getResultList();
        Long singleResult = (Long) nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(MapQuery query, Pageable pageable) {
        return findAllBySQLToMap(query.getSql(), pageable, query.getMap());
    }

    @Override
    public Page<Map<String, Object>> findAllByDSLToMap(SelectQuery<Record> selectQuery, Pageable pageable) {
        selectQuery = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery).asTable()).getQuery();
        return findAllBySQLToMap(selectQuery.getSQL(), pageable, selectQuery.getBindValues());
    }

    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(String hql, Pageable pageable, Object... objects) {
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(hql);
        javax.persistence.Query nativeQuery1 = entityManager.createQuery(createCountHQL(hql), Long.class);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
            nativeQuery1.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<Map<String, Object>> resultList = nativeQuery.getResultList();
        Long singleResult = (Long) nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(ArrayQuery query, Pageable pageable) {
        return findAllByHQLToMap(query.getSql(), pageable, query.getObjects());
    }

    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(String hql, Pageable pageable, Collection collection) {
        return findAllByHQLToMap(hql, pageable, collection.toArray());
    }

    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(CollectionQuery query, Pageable pageable) {
        return findAllByHQLToMap(query.getSql(), pageable, query.getCollection());
    }

    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(String hql, Pageable pageable, Map<String, Object> map) {
        javax.persistence.Query nativeQuery = entityManager.createQuery(hql);
        javax.persistence.Query nativeQuery1 = entityManager.createNativeQuery(createCountHQL(hql), Long.class);
        map.forEach(nativeQuery::setParameter);
        map.forEach(nativeQuery1::setParameter);
        nativeQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<Map<String, Object>> resultList = nativeQuery.getResultList();
        Long singleResult = (Long) nativeQuery1.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(MapQuery query, Pageable pageable) {
        return null;
    }

    @Override
    public void executeByStore(String store, Object... objects) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery(store);
        for (int i = 0; i < objects.length; i++) {
            storedProcedureQuery.setParameter(i + i, objects[i]);
        }
        storedProcedureQuery.executeUpdate();
    }

    @Override
    public void executeByStore(String store, Collection collection) {
        executeByStore(store, collection.toArray());
    }

    @Override
    public void executeByStore(String store, Map<String, Object> map) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery(store);
        map.forEach(storedProcedureQuery::setParameter);
        storedProcedureQuery.executeUpdate();
    }

    @Override
    public Optional<Object> findOneByStore(String store, Object... objects) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery(store);
        for (int i = 0; i < objects.length; i++) {
            storedProcedureQuery.setParameter(i + i, objects[i]);
        }
        return Optional.ofNullable(storedProcedureQuery.getSingleResult());
    }

    @Override
    public Optional<Object> findOneByStore(String store, Collection collection) {
        return findOneByStore(store, collection.toArray());
    }

    @Override
    public Optional<Object> findOneByStore(String store, Map<String, Object> map) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery(store);
        map.forEach(storedProcedureQuery::setParameter);
        return Optional.ofNullable(storedProcedureQuery.getSingleResult());
    }

    @Override
    public List findAllByStore(String store, Object... objects) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery(store);
        for (int i = 0; i < objects.length; i++) {
            storedProcedureQuery.setParameter(i + i, objects[i]);
        }
        return storedProcedureQuery.getResultList();
    }

    @Override
    public List findAllByStore(String store, Collection collection) {
        return findAllByStore(store, collection.toArray());
    }

    @Override
    public List findAllByStore(String store, Map<String, Object> map) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery(store);
        map.forEach(storedProcedureQuery::setParameter);
        return storedProcedureQuery.getResultList();
    }

    private String createCountSQL(String sql) {
        return "select count(*) from (" + sql + ") count_table";
    }

    private String createCountHQL(String hql) {
        return "select count(1) from (" + hql + ") count_table";
    }
}
