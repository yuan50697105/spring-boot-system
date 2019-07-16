package com.yuan.spring.boot.dao.hibernate.dao.impl;

import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yuan.spring.boot.dao.hibernate.dao.HibernateDao;
import com.yuan.spring.boot.dao.hibernate.entity.domain.HibernateDomain;
import com.yuan.spring.boot.dao.hibernate.entity.dto.ArrayQuery;
import com.yuan.spring.boot.dao.hibernate.entity.dto.MapQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.query.internal.QueryImpl;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 17:09
 **/
@SuppressWarnings({"Duplicates", "unchecked"})
@NoRepositoryBean
public class HibernateDaoImpl<T extends HibernateDomain<ID>, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements HibernateDao<T, ID> {
    private final EntityManager entityManager;
    private final JpaEntityInformation<T, ?> entityInformation;
    private DSLContext dslContext;
    private JPQLQueryFactory jpqlQueryFactory;

    public HibernateDaoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
        jpqlQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Autowired
    public void setDslContext(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public JPQLQueryFactory getJpqlQueryFactory() {
        return jpqlQueryFactory;
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
    public boolean isNew(T t) {
        return entityInformation.isNew(t);
    }

    @Override
    public Optional<T> findOne(SelectQuery<Record> selectQuery) {
        selectQuery = getDslQuery(selectQuery);
        return getSQLQueryBaseResult(entityInformation.getJavaType(), selectQuery.getSQL(), selectQuery.getBindValues().toArray());
    }

    @Override
    public <R> Optional<R> findOne(Class<R> type, SelectQuery<Record> selectQuery) {
        selectQuery = getDslQuery(selectQuery);
        return getSQLQueryBaseResult(type, selectQuery.getSQL(), selectQuery.getBindValues().toArray());
    }

    @Override
    public Optional<Map<String, Object>> findOneToMap(SelectQuery<Record> selectQuery) {
        selectQuery = getDslQuery(selectQuery);
        return getSQLQueryMap(selectQuery.getSQL(), selectQuery.getBindValues().toArray());
    }

    @Override
    public <R> Optional<R> findOneToBean(Class<R> type, SelectQuery<Record> selectQuery) {
        selectQuery = getDslQuery(selectQuery);
        return getSQLQueryBean(type, selectQuery.getSQL(), selectQuery.getBindValues().toArray());
    }

    @Override
    public List<T> findAll(SelectQuery<Record> selectQuery) {
        selectQuery = getDslQuery(selectQuery);
        return getSQLQueryBaseResultList(entityInformation.getJavaType(), selectQuery.getSQL(), selectQuery.getBindValues().toArray());
    }

    @Override
    public <R> List<R> findAll(Class<R> type, SelectQuery<Record> selectQuery) {
        selectQuery = getDslQuery(selectQuery);
        return getSQLQueryBaseResultList(type, selectQuery.getSQL(), selectQuery.getBindValues().toArray());
    }

    @Override
    public List<Map<String, Object>> findAllToMap(SelectQuery<Record> selectQuery) {
        selectQuery = getDslQuery(selectQuery);
        return getSQLQueryMapList(selectQuery.getSQL(), selectQuery.getBindValues().toArray());
    }

    @Override
    public <R> List<R> findAllToBean(Class<R> type, SelectQuery<Record> selectQuery) {
        selectQuery = getDslQuery(selectQuery);
        return getSQLQueryBeanList(type, selectQuery.getSQL(), selectQuery.getBindValues().toArray());
    }

    @Override
    public Page<T> findAll(SelectQuery<Record> selectQuery, Pageable pageable) {
        selectQuery = getDslQuery(selectQuery);
        SelectQuery<Record1<Integer>> countQuery = getCountQuery(selectQuery);
        List<T> list = getSQLQueryBeanList(entityInformation.getJavaType(), pageable, selectQuery.getSQL(), selectQuery.getBindValues());
        Optional<Long> result = getSQLQueryBaseResult(Long.class, countQuery.getSQL(), countQuery.getBindValues());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public <R> Page<R> findAll(Class<R> type, SelectQuery<Record> selectQuery, Pageable pageable) {
        selectQuery = getDslQuery(selectQuery);
        SelectQuery<Record1<Integer>> countQuery = getCountQuery(selectQuery);
        List<R> list = getSQLQueryBeanList(type, pageable, selectQuery.getSQL(), selectQuery.getBindValues());
        Optional<Long> result = getSQLQueryBaseResult(Long.class, countQuery.getSQL(), countQuery.getBindValues());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public Page<Map<String, Object>> findAllToMap(SelectQuery<Record> selectQuery, Pageable pageable) {
        selectQuery = getDslQuery(selectQuery);
        SelectQuery<Record1<Integer>> countQuery = getCountQuery(selectQuery);
        List<Map<String, Object>> list = getSQLQueryMapList(pageable, selectQuery.getSQL(), selectQuery.getBindValues());
        Optional<Long> result = getSQLQueryBaseResult(Long.class, countQuery.getSQL(), countQuery.getBindValues());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public <R> Page<R> findAllToBean(Class<R> type, SelectQuery<Record> selectQuery, Pageable pageable) {
        selectQuery = getDslQuery(selectQuery);
        SelectQuery<Record1<Integer>> countQuery = getCountQuery(selectQuery);
        List<R> list = getSQLQueryBeanList(type, pageable, selectQuery.getSQL(), selectQuery.getBindValues());
        Optional<Long> result = getSQLQueryBaseResult(Long.class, countQuery.getSQL(), countQuery.getBindValues());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public Optional<T> findOneByQuery(ArrayQuery query) {
        return getQueryBaseResult(entityInformation.getJavaType(), query.getSql(), query.getParams());
    }

    @Override
    public <R> Optional<R> findOneByQuery(Class<R> type, ArrayQuery query) {
        return getQueryBaseResult(type, query.getSql(), query.getParams());
    }

    @Override
    public Optional<Map<String, Object>> findOneByQueryToMap(ArrayQuery query) {
        return getQueryMap(query.getSql(), query.getParams());
    }

    @Override
    public <R> Optional<R> findOneByQueryToBean(Class<R> type, ArrayQuery query) {
        return getQueryBean(type, query.getSql(), query.getParams());
    }

    @Override
    public Optional<T> findOneByQuery(MapQuery query) {
        return getQueryBaseResult(entityInformation.getJavaType(), query.getSql(), query.getParams());
    }

    @Override
    public <R> Optional<R> findOneByQuery(Class<R> type, MapQuery query) {
        return getQueryBaseResult(type, query.getSql(), query.getParams());
    }

    @Override
    public Optional<Map<String, Object>> findOneByQueryToMap(MapQuery query) {
        return getQueryMap(query.getSql(), query.getParams());
    }

    @Override
    public <R> Optional<R> findOneByQueryToBean(Class<R> type, MapQuery query) {
        return getQueryBean(type, query.getSql(), query.getParams());
    }

    @Override
    public List<T> findAllByQuery(ArrayQuery query) {
        return getSQLQueryBaseResultList(entityInformation.getJavaType(), query.getSql(), query.getParams());
    }

    @Override
    public <R> List<R> findAllByQuery(Class<R> type, ArrayQuery query) {
        return getQueryBaseResultList(type, query.getSql(), query.getParams());
    }

    @Override
    public List<Map<String, Object>> findAllByQueryToMap(ArrayQuery query) {
        return getQueryMapList(query.getSql(), query.getParams());
    }

    @Override
    public <R> List<R> findAllByQueryToBean(Class<R> type, ArrayQuery query) {
        return getQueryBeanList(type, query.getSql(), query.getParams());
    }

    @Override
    public List<T> findAllByQuery(MapQuery query) {
        return getQueryBaseResultList(entityInformation.getJavaType(), query.getSql(), query.getParams());
    }

    @Override
    public <R> List<R> findAllByQuery(Class<R> type, MapQuery query) {
        return getQueryBaseResultList(type, query.getSql(), query.getParams());
    }

    @Override
    public List<Map<String, Object>> findAllByQueryToMap(MapQuery query) {
        return getQueryMapList(query.getSql(), query.getParams());
    }

    @Override
    public <R> List<R> findAllByQueryToBean(Class<R> type, MapQuery query) {
        return getQueryBeanList(type, query.getSql(), query.getParams());
    }

    @Override
    public Page<T> findAllByQuery(ArrayQuery query, Pageable pageable) {
        List<T> list = getQueryBaseResultList(entityInformation.getJavaType(), pageable, query.getSql(), query.getParams());
        Optional<Long> result = getQueryBaseResult(Long.class, getCountQuery(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public <R> Page<R> findAllByQuery(Class<R> type, ArrayQuery query, Pageable pageable) {
        List<R> list = getQueryBaseResultList(type, pageable, query.getSql(), query.getParams());
        Optional<Long> result = getQueryBaseResult(Long.class, getCountQuery(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public Page<Map<String, Object>> findAllByQueryToMap(ArrayQuery query, Pageable pageable) {
        List<Map<String, Object>> list = getQueryMapList(pageable, query.getSql(), query.getParams());
        Optional<Long> result = getQueryBaseResult(Long.class, getCountQuery(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public <R> Page<R> findAllByQueryToBean(Class<R> type, ArrayQuery query, Pageable pageable) {
        List<R> list = getQueryBeanList(type, pageable, query.getSql(), query.getParams());
        Optional<Long> result = getQueryBaseResult(Long.class, getCountQuery(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public Page<T> findAllByQuery(MapQuery query, Pageable pageable) {
        List<T> list = getQueryBaseResultList(entityInformation.getJavaType(), pageable, query.getSql(), query.getParams());
        Optional<Long> result = getQueryBaseResult(Long.class, getCountQuery(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public <R> Page<R> findAllByQuery(Class<R> type, MapQuery query, Pageable pageable) {
        List<R> list = getQueryBaseResultList(type, pageable, query.getSql(), query.getParams());
        Optional<Long> result = getQueryBaseResult(Long.class, getCountQuery(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public Page<Map<String, Object>> findAllByQueryToMap(MapQuery query, Pageable pageable) {
        List<Map<String, Object>> list = getQueryMapList(pageable, query.getSql(), query.getParams());
        Optional<Long> result = getQueryBaseResult(Long.class, getCountQuery(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public <R> Page<R> findAllByQueryToBean(Class<R> type, MapQuery query, Pageable pageable) {
        List<R> list = getQueryBeanList(type, pageable, query.getSql(), query.getParams());
        Optional<Long> result = getQueryBaseResult(Long.class, getCountQuery(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public Optional<T> findOneBySQLQuery(ArrayQuery query) {
        return getSQLQueryBaseResult(entityInformation.getJavaType(), query.getSql(), query.getParams());
    }

    @Override
    public <R> Optional<R> findOneBySQLQuery(Class<R> type, ArrayQuery query) {
        return getSQLQueryBaseResult(type, query.getSql(), query.getParams());
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLQueryToMap(ArrayQuery query) {
        return getSQLQueryMap(query.getSql(), query.getParams());
    }

    @Override
    public <R> Optional<R> findOneBySQLQueryToBean(Class<R> type, ArrayQuery query) {
        return getSQLQueryBean(type, query.getSql(), query.getParams());
    }

    @Override
    public Optional<T> findOneBySQLQuery(MapQuery query) {
        return getSQLQueryBaseResult(entityInformation.getJavaType(), query.getSql(), query.getParams());
    }

    @Override
    public <R> Optional<R> findOneBySQLQuery(Class<R> type, MapQuery query) {
        return getSQLQueryBaseResult(type, query.getSql(), query.getParams());
    }

    @Override
    public Optional<Map<String, Object>> findOneBySQLQueryToMap(MapQuery query) {
        return getSQLQueryMap(query.getSql(), query.getParams());
    }

    @Override
    public <R> Optional<R> findOneBySQLQueryToBean(Class<R> type, MapQuery query) {
        return getSQLQueryBean(type, query.getSql(), query.getParams());
    }

    @Override
    public List<T> findAllBySQLQuery(ArrayQuery query) {
        return getSQLQueryBaseResultList(entityInformation.getJavaType(), query.getSql(), query.getParams());
    }

    @Override
    public <R> List<R> findAllBySQLQuery(Class<R> type, ArrayQuery query) {
        return getSQLQueryBaseResultList(type, query.getSql(), query.getParams());
    }

    @Override
    public List<Map<String, Object>> findAllBySQLQueryToMap(ArrayQuery query) {
        return getSQLQueryMapList(query.getSql(), query.getParams());
    }

    @Override
    public <R> List<R> findAllBySQLQueryToBean(Class<R> type, ArrayQuery query) {
        return getSQLQueryBeanList(type, query.getSql(), query.getParams());
    }

    @Override
    public List<T> findAllBySQLQuery(MapQuery query) {
        return getSQLQueryBaseResultList(entityInformation.getJavaType(), query.getSql(), query.getParams());
    }

    @Override
    public <R> List<R> findAllBySQLQuery(Class<R> type, MapQuery query) {
        return getSQLQueryBaseResultList(type, query.getSql(), query.getParams());
    }

    @Override
    public List<Map<String, Object>> findAllBySQLQueryToMap(MapQuery query) {
        return getSQLQueryMapList(query.getSql(), query.getParams());
    }

    @Override
    public <R> List<R> findAllBySQLQueryToBean(Class<R> type, MapQuery query) {
        return getSQLQueryBeanList(type, query.getSql(), query.getParams());
    }

    @Override
    public Page<T> findAllBySQLQuery(ArrayQuery query, Pageable pageable) {
        List<T> list = getSQLQueryBaseResultList(entityInformation.getJavaType(), pageable, query.getSql(), query.getParams());
        Optional<Long> result = getSQLQueryBaseResult(Long.class, getCountSQL(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public <R> Page<R> findAllBySQLQuery(Class<R> type, ArrayQuery query, Pageable pageable) {
        List<R> list = getSQLQueryBaseResultList(type, pageable, query.getSql(), query.getParams());
        Optional<Long> result = getSQLQueryBaseResult(Long.class, getCountSQL(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLQueryToMap(ArrayQuery query, Pageable pageable) {
        List<Map<String, Object>> list = getSQLQueryMapList(pageable, query.getSql(), query.getParams());
        Optional<Long> result = getSQLQueryBaseResult(Long.class, getCountSQL(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public <R> Page<R> findAllBySQLQueryToBean(Class<R> type, ArrayQuery query, Pageable pageable) {
        List<R> list = getSQLQueryBeanList(type, pageable, query.getSql(), query.getParams());
        Optional<Long> result = getSQLQueryBaseResult(Long.class, getCountSQL(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public Page<T> findAllBySQLQuery(MapQuery query, Pageable pageable) {
        List<T> list = getSQLQueryBaseResultList(entityInformation.getJavaType(), pageable, query.getSql(), query.getParams());
        Optional<Long> result = getSQLQueryBaseResult(Long.class, getCountSQL(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public <R> Page<R> findAllBySQLQuery(Class<R> type, MapQuery query, Pageable pageable) {
        List<R> list = getSQLQueryBaseResultList(type, pageable, query.getSql(), query.getParams());
        Optional<Long> result = getSQLQueryBaseResult(Long.class, getCountSQL(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public Page<Map<String, Object>> findAllBySQLQueryToMap(MapQuery query, Pageable pageable) {
        List<Map<String, Object>> list = getSQLQueryMapList(pageable, query.getSql(), query.getParams());
        Optional<Long> result = getSQLQueryBaseResult(Long.class, getCountSQL(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    @Override
    public <R> Page<R> findAllBySQLQueryToBean(Class<R> type, MapQuery query, Pageable pageable) {
        List<R> list = getSQLQueryBeanList(type, pageable, query.getSql(), query.getParams());
        Optional<Long> result = getSQLQueryBaseResult(Long.class, getCountSQL(query.getSql()), query.getParams());
        return new PageImpl<>(list, pageable, result.orElse(0L));
    }

    private <R> Optional<R> getSQLQueryBaseResult(Class<R> type, String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql, type);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        return Optional.ofNullable((R) nativeQuery.getSingleResult());
    }


    /*
        基础生成部分
     */
    private <R> Optional<R> getSQLQueryBaseResult(Class<R> type, String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql, type);
        map.forEach(nativeQuery::setParameter);
        return Optional.ofNullable((R) nativeQuery.getSingleResult());
    }

    private <R> Optional<R> getQueryBaseResult(Class<R> type, String query, Object... objects) {
        TypedQuery<R> query1 = entityManager.createQuery(query, type);
        for (int i = 0; i < objects.length; i++) {
            query1.setParameter(i + 1, objects[i]);
        }
        return Optional.ofNullable(query1.getSingleResult());
    }

    private <R> Optional<R> getQueryBaseResult(Class<R> type, String query, Map<String, Object> map) {
        TypedQuery<R> nativeQuery = entityManager.createQuery(query, type);
        map.forEach(nativeQuery::setParameter);
        return Optional.ofNullable(nativeQuery.getSingleResult());
    }

    private Optional<Map<String, Object>> getSQLQueryMap(String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return Optional.ofNullable((Map<String, Object>) nativeQuery.getSingleResult());
    }

    private Optional<Map<String, Object>> getSQLQueryMap(String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return Optional.ofNullable((Map<String, Object>) nativeQuery.getSingleResult());
    }

    private Optional<Map<String, Object>> getQueryMap(String sql, Object... objects) {
        Query nativeQuery = entityManager.createQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return Optional.ofNullable((Map<String, Object>) nativeQuery.getSingleResult());
    }

    private Optional<Map<String, Object>> getQueryMap(String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return Optional.ofNullable((Map<String, Object>) nativeQuery.getSingleResult());
    }

    private <R> Optional<R> getSQLQueryBean(Class<R> type, String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return Optional.ofNullable((R) nativeQuery.getSingleResult());
    }

    private <R> Optional<R> getSQLQueryBean(Class<R> type, String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return Optional.ofNullable((R) nativeQuery.getSingleResult());
    }

    private <R> Optional<R> getQueryBean(Class<R> type, String sql, Object... objects) {
        Query nativeQuery = entityManager.createQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return Optional.ofNullable((R) nativeQuery.getSingleResult());
    }

    private <R> Optional<R> getQueryBean(Class<R> type, String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return Optional.ofNullable((R) nativeQuery.getSingleResult());
    }

    ///////////////////////////////////////////////////////

    private <R> List<R> getSQLQueryBaseResultList(Class<R> type, String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql, type);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        return nativeQuery.getResultList();
    }

    private <R> List<R> getSQLQueryBaseResultList(Class<R> type, String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql, type);
        map.forEach(nativeQuery::setParameter);
        return nativeQuery.getResultList();
    }


    private <R> List<R> getQueryBaseResultList(Class<R> type, String query, Object... objects) {
        TypedQuery<R> nativeQuery = entityManager.createQuery(query, type);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        return nativeQuery.getResultList();
    }

    private <R> List<R> getQueryBaseResultList(Class<R> type, String query, Map<String, Object> map) {
        TypedQuery<R> nativeQuery = entityManager.createQuery(query, type);
        map.forEach(nativeQuery::setParameter);
        return nativeQuery.getResultList();
    }

    private List<Map<String, Object>> getSQLQueryMapList(String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return nativeQuery.getResultList();
    }

    private List<Map<String, Object>> getSQLQueryMapList(String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return nativeQuery.getResultList();
    }

    private List<Map<String, Object>> getQueryMapList(String sql, Object... objects) {
        Query nativeQuery = entityManager.createQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return nativeQuery.getResultList();
    }

    private List<Map<String, Object>> getQueryMapList(String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return nativeQuery.getResultList();
    }

    private <R> List<R> getSQLQueryBeanList(Class<R> type, String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }

    private <R> List<R> getSQLQueryBeanList(Class<R> type, String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }

    private <R> List<R> getQueryBeanList(Class<R> type, String sql, Object... objects) {
        Query nativeQuery = entityManager.createQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }

    private <R> List<R> getQueryBeanList(Class<R> type, String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }

    //////////////////////////////////////////
    private <R> List<R> getSQLQueryBaseResultList(Class<R> type, Pageable pageable, String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql, type);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        return nativeQuery.getResultList();
    }

    private <R> List<R> getSQLQueryBaseResultList(Class<R> type, Pageable pageable, String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql, type);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        return nativeQuery.getResultList();
    }


    private <R> List<R> getQueryBaseResultList(Class<R> type, Pageable pageable, String query, Object... objects) {
        TypedQuery<R> nativeQuery = entityManager.createQuery(query, type);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        return nativeQuery.getResultList();
    }

    private <R> List<R> getQueryBaseResultList(Class<R> type, Pageable pageable, String query, Map<String, Object> map) {
        TypedQuery<R> nativeQuery = entityManager.createQuery(query, type);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        return nativeQuery.getResultList();
    }

    private List<Map<String, Object>> getSQLQueryMapList(Pageable pageable, String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return nativeQuery.getResultList();
    }

    private List<Map<String, Object>> getSQLQueryMapList(Pageable pageable, String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return nativeQuery.getResultList();
    }

    private List<Map<String, Object>> getQueryMapList(Pageable pageable, String sql, Object... objects) {
        Query nativeQuery = entityManager.createQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return nativeQuery.getResultList();
    }

    private List<Map<String, Object>> getQueryMapList(Pageable pageable, String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return nativeQuery.getResultList();
    }

    private <R> List<R> getSQLQueryBeanList(Class<R> type, Pageable pageable, String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }

    private <R> List<R> getSQLQueryBeanList(Class<R> type, Pageable pageable, String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }

    private <R> List<R> getQueryBeanList(Class<R> type, Pageable pageable, String sql, Object... objects) {
        Query nativeQuery = entityManager.createQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }

    private <R> List<R> getQueryBeanList(Class<R> type, Pageable pageable, String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }


    private SelectQuery<Record> getDslQuery(SelectQuery<Record> selectQuery) {
        return dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery).asTable()).getQuery();
    }

    private SelectQuery<Record1<Integer>> getCountQuery(SelectQuery<Record> selectQuery) {
        return dslContext.select(DSL.count()).from(DSL.table(selectQuery).asTable()).getQuery();
    }

    private String getCountSQL(String sql) {
        return "select count(*) from (" + sql + ") count_table";
    }

    private String getCountQuery(String query) {
        return "select count(*) from (" + query + ") count_table";
    }

}
