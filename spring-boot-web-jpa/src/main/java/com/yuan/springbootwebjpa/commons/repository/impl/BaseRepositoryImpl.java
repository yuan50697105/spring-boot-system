package com.yuan.springbootwebjpa.commons.repository.impl;

import com.querydsl.hibernate.search.SearchQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.query.internal.QueryImpl;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.core.EntityInformation;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/15 17:09
 **/
@SuppressWarnings("deprecation")
@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable> extends QuerydslJpaRepository<T, ID> implements BaseRepository<T, ID> {
    private final EntityManager entityManager;
    private final EntityInformation<T, ID> entityInformation;
    private final FullTextEntityManager fullTextEntityManager;
    private final JPAQueryFactory jpaQueryFactory;
    private final SearchQuery<T> searchQuery;
    private final DSLContext dslContext;

    public BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager, EntityPathResolver resolver, DSLContext dslContext) {
        super(entityInformation, entityManager, resolver);
        this.entityManager = entityManager;
        this.fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        this.entityInformation = entityInformation;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
        this.dslContext = dslContext;
        this.searchQuery = new SearchQuery<>((FullTextSession) fullTextEntityManager.getDelegate(), resolver.createPath(entityInformation.getJavaType()));
    }

    @Override
    public JPAQueryFactory getJpaQueryFactory() {
        return jpaQueryFactory;
    }

    @Override
    public SearchQuery getSearchQuery() {
        return searchQuery;
    }

    @Override
    public QueryBuilder getLuceneQueryBuilder() {
        return fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(entityInformation.getJavaType()).get();
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        return entityManager.getCriteriaBuilder();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> fullTextList(org.apache.lucene.search.Query query) {
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, entityInformation.getJavaType());
        return (List<T>) fullTextQuery.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<T> fullTextOne(org.apache.lucene.search.Query query) {
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, entityInformation.getJavaType());
        return Optional.ofNullable((T) fullTextQuery.getSingleResult());
    }

    @Override
    public int executeBySQL(String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        int i = 0;
        for (Object object : objects) {
            nativeQuery.setParameter(++i, object);
        }
        return nativeQuery.executeUpdate();
    }

    @Override
    public int executeBySQL(String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        return nativeQuery.executeUpdate();
    }

    @Override
    public int executeByHQL(String hql, Object... objects) {
        Query query = entityManager.createQuery(hql);
        int i = 0;
        for (Object object : objects) {
            query.setParameter(++i, object);
        }
        return query.executeUpdate();
    }

    @Override
    public int executeByHQL(String hql, Map<String, Object> map) {
        Query query = entityManager.createQuery(hql);
        map.forEach(query::setParameter);
        return query.executeUpdate();
    }

    @Override
    public int executeByQuery(org.jooq.Query query) {
        return dslContext.execute(query);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<T> findOneBySQL(String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql, entityInformation.getJavaType());
        int i = 0;
        for (Object object : objects) {
            nativeQuery.setParameter(++i, object);
        }
        return Optional.ofNullable(((T) nativeQuery.getSingleResult()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<T> findOneBySQL(String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql, entityInformation.getJavaType());
        map.forEach(nativeQuery::setParameter);
        return Optional.ofNullable(((T) nativeQuery.getSingleResult()));
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Object... objects) {
        TypedQuery<T> query = entityManager.createQuery(hql, entityInformation.getJavaType());
        int i = 0;
        for (Object object : objects) {
            query.setParameter(++i, object);
        }
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Optional<T> findOneByHQL(String hql, Map<String, Object> map) {
        TypedQuery<T> query = entityManager.createQuery(hql, entityInformation.getJavaType());
        map.forEach(query::setParameter);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Optional<T> findOneByQuery(SelectQuery<org.jooq.Record> selectQuery) {
        SelectQuery<org.jooq.Record> query = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findOneByHQL(query.getSQL(), query.getBindValues());
    }


    @SuppressWarnings("unchecked")
    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        int i = 0;
        for (Object object : objects) {
            nativeQuery.setParameter(++i, object);
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return Optional.ofNullable(((Map<String, Object>) nativeQuery.getSingleResult()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<Map<String, Object>> findOneBySQLToMap(String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return Optional.ofNullable(((Map<String, Object>) nativeQuery.getSingleResult()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(String hql, Object... objects) {
        Query nativeQuery = entityManager.createQuery(hql);
        int i = 0;
        for (Object object : objects) {
            nativeQuery.setParameter(++i, object);
        }
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return Optional.ofNullable(((Map<String, Object>) nativeQuery.getSingleResult()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<Map<String, Object>> findOneByHQLToMap(String hql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createQuery(hql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return Optional.ofNullable(((Map<String, Object>) nativeQuery.getSingleResult()));
    }

    @Override
    public Optional<Map<String, Object>> findOneByQueryToMap(SelectQuery<Record> selectQuery) {
        SelectQuery<Record> query = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findOneBySQLToMap(query.getSQL(), query.getBindValues());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAllBySQL(String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql, entityInformation.getJavaType());
        int i = 0;
        for (Object object : objects) {
            nativeQuery.setParameter(++i, object);
        }
        return (List<T>) nativeQuery.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAllBySQL(String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql, entityInformation.getJavaType());
        map.forEach(nativeQuery::setParameter);
        return (List<T>) nativeQuery.getResultList();
    }

    @Override
    public List<T> findAllByHQL(String hql, Object... objects) {
        TypedQuery<T> nativeQuery = entityManager.createQuery(hql, entityInformation.getJavaType());
        int i = 0;
        for (Object object : objects) {
            nativeQuery.setParameter(++i, object);
        }
        return nativeQuery.getResultList();
    }

    @Override
    public List<T> findAllByHQL(String hql, Map<String, Object> map) {
        TypedQuery<T> nativeQuery = entityManager.createQuery(hql, entityInformation.getJavaType());
        map.forEach(nativeQuery::setParameter);
        return nativeQuery.getResultList();
    }

    @Override
    public List<T> findAllByQuery(SelectQuery<Record> selectQuery) {
        SelectQuery<Record> query = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findAllByHQL(query.getSQL(), query.getBindValues());
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        int i = 0;
        for (Object object : objects) {
            nativeQuery.setParameter(++i, object);
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return (List<Map<String, Object>>) nativeQuery.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> findAllBySQLToMap(String sql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return (List<Map<String, Object>>) nativeQuery.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> findAllByHQLToMap(String hql, Object... objects) {
        Query nativeQuery = entityManager.createQuery(hql);
        int i = 0;
        for (Object object : objects) {
            nativeQuery.setParameter(++i, object);
        }
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return (List<Map<String, Object>>) nativeQuery.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> findAllByHQLToMap(String hql, Map<String, Object> map) {
        Query nativeQuery = entityManager.createQuery(hql);
        map.forEach(nativeQuery::setParameter);
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return (List<Map<String, Object>>) nativeQuery.getResultList();
    }

    @Override
    public List<Map<String, Object>> findAllByQueryToMap(SelectQuery<Record> selectQuery) {
        SelectQuery<Record> query = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findAllBySQLToMap(query.getSQL(), query.getBindValues());
    }

    private String createCountSQL(String sql) {
        return "select count(1) from (" + sql + ") COUNTABLE";
    }

    private String createCountHQL(String sql) {
        return "select count(1) from (" + sql + ") COUNTABLE";
    }

    @SuppressWarnings({"unchecked", "Duplicates"})
    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql, entityInformation.getJavaType());
        Query countQuery = entityManager.createNativeQuery(createCountSQL(sql), Long.class);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
            countQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        List resultList = nativeQuery.getResultList();
        Object singleResult = countQuery.getSingleResult();
        return new PageImpl<T>((List<T>) resultList, pageable, (Long) singleResult);
    }

    @SuppressWarnings({"Duplicates", "unchecked"})
    @Override
    public Page<T> findAllBySQL(String sql, Pageable pageable, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql, entityInformation.getJavaType());
        Query countQuery = entityManager.createNativeQuery(createCountSQL(sql), Long.class);
        map.forEach(nativeQuery::setParameter);
        map.forEach(countQuery::setParameter);
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        List resultList = nativeQuery.getResultList();
        Object singleResult = countQuery.getSingleResult();
        return new PageImpl<>((List<T>) resultList, pageable, (Long) singleResult);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Page<T> findAllByHQL(String hql, Pageable pageable, Object... objects) {
        TypedQuery<T> nativeQuery = entityManager.createQuery(hql, entityInformation.getJavaType());
        TypedQuery<Long> countQuery = entityManager.createQuery(createCountHQL(hql), Long.class);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
            countQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        List<T> resultList = nativeQuery.getResultList();
        Long singleResult = countQuery.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Page<T> findAllByHQL(String hql, Pageable pageable, Map<String, Object> map) {
        TypedQuery<T> nativeQuery = entityManager.createQuery(hql, entityInformation.getJavaType());
        TypedQuery<Long> countQuery = entityManager.createQuery(createCountHQL(hql), Long.class);
        map.forEach(nativeQuery::setParameter);
        map.forEach(countQuery::setParameter);
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        List<T> resultList = nativeQuery.getResultList();
        Long singleResult = countQuery.getSingleResult();
        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public Page<T> findAllByQuery(SelectQuery<Record> selectQuery, Pageable pageable) {
        SelectQuery<Record> query = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findAllBySQL(query.getSQL(),pageable,query.getBindValues());
    }

    @SuppressWarnings({"unchecked", "Duplicates"})
    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        Query countQuery = entityManager.createNativeQuery(createCountSQL(sql), Long.class);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
            countQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List resultList = nativeQuery.getResultList();
        Object singleResult = countQuery.getSingleResult();
        return new PageImpl<>((List<Map<String, Object>>) resultList, pageable, (Long) singleResult);
    }

    @SuppressWarnings({"unchecked", "Duplicates"})
    @Override
    public Page<Map<String, Object>> findAllBySQLToMap(String sql, Pageable pageable, Map<String, Object> map) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        Query countQuery = entityManager.createNativeQuery(createCountSQL(sql), Long.class);
        map.forEach(nativeQuery::setParameter);
        map.forEach(countQuery::setParameter);
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List resultList = nativeQuery.getResultList();
        Object singleResult = countQuery.getSingleResult();
        return new PageImpl<>((List<Map<String, Object>>) resultList, pageable, (Long) singleResult);
    }

    @SuppressWarnings({"unchecked", "Duplicates"})
    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(String hql, Pageable pageable, Object... objects) {
        Query nativeQuery = entityManager.createQuery(hql);
        TypedQuery<Long> countQuery = entityManager.createQuery(createCountHQL(hql), Long.class);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
            countQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<T> resultList = nativeQuery.getResultList();
        Long singleResult = countQuery.getSingleResult();
        return new PageImpl<>(((List<Map<String, Object>>) resultList), pageable, singleResult);
    }

    @SuppressWarnings({"Duplicates", "unchecked"})
    @Override
    public Page<Map<String, Object>> findAllByHQLToMap(String hql, Pageable pageable, Map<String, Object> map) {
        Query nativeQuery = entityManager.createQuery(hql);
        TypedQuery<Long> countQuery = entityManager.createQuery(createCountHQL(hql), Long.class);
        map.forEach(nativeQuery::setParameter);
        map.forEach(countQuery::setParameter);
        nativeQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        nativeQuery.setMaxResults(pageable.getPageSize());
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<T> resultList = nativeQuery.getResultList();
        Long singleResult = countQuery.getSingleResult();
        return new PageImpl<>(((List<Map<String, Object>>) resultList), pageable, singleResult);
    }

    @Override
    public Page<Map<String, Object>> findAllByQueryToMap(SelectQuery<Record> selectQuery, Pageable pageable) {
        SelectQuery<Record> query = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery.getSQL(), selectQuery.getBindValues()).asTable()).getQuery();
        return findAllBySQLToMap(query.getSQL(),pageable,query.getBindValues());
    }
}
