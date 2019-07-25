package com.yuan.spring.boot.dao.jpa.dao.impl;

import com.querydsl.jpa.HQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yuan.spring.boot.dao.jpa.dao.JpaDao;
import com.yuan.spring.boot.dao.jpa.entity.domain.JpaDomain;
import com.yuan.spring.boot.dao.jpa.entity.dto.ArrayQuery;
import com.yuan.spring.boot.dao.jpa.entity.dto.MapQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.query.internal.QueryImpl;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
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
public class JpaDaoImpl<T extends JpaDomain<ID>, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements JpaDao<T, ID> {
    private final EntityManager entityManager;
    private final JpaEntityInformation<T, ?> entityInformation;
    private final JPAQueryFactory queryFactory;

    public JpaDaoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
        this.queryFactory = new JPAQueryFactory(new HQLTemplates(), entityManager);
    }

    public JPAQueryFactory getQueryFactory() {
        return this.queryFactory;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public boolean isNew(T t) {
        return entityInformation.isNew(t);
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

    private String getCountSQL(String sql) {
        return "select count(*) from (" + sql + ") count_table";
    }

    private String getCountQuery(String query) {
        return "select count(*) from (" + query + ") count_table";
    }

}
