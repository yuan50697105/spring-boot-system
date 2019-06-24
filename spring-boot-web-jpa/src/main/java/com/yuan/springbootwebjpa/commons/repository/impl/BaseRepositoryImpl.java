package com.yuan.springbootwebjpa.commons.repository.impl;

import com.yuan.springbootwebjpa.commons.repository.BaseRepository;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.query.internal.QueryImpl;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Page;
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

    public Optional<T> findOne(SelectQuery<Record> selectQuery) {
        return Optional.empty();
    }

    public <R> Optional<R> findOne(Class<R> type, SelectQuery<Record> selectQuery) {
        return Optional.empty();
    }

    public Optional<Map<String, Object>> findOneToMap(SelectQuery<Record> selectQuery) {
        return Optional.empty();
    }

    public <R> Optional<R> findOneToBean(SelectQuery<Record> selectQuery) {
        return Optional.empty();
    }

    public List<T> findAll(SelectQuery<Record> selectQuery) {
        return null;
    }

    public <R> List<R> findAll(Class<R> type, SelectQuery<Record> selectQuery) {
        return null;
    }

    public List<Map<String, Object>> findAllToMap(SelectQuery<Record> selectQuery) {
        return null;
    }

    public <R> List<R> findAllToBean(Class<R> type, SelectQuery<Record> selectQuery) {
        return null;
    }


    public Page<T> findAll(SelectQuery<Record> selectQuery, Pageable pageable) {
        return null;
    }

    public <R> Page<R> findAll(Class<R> type, SelectQuery<Record> selectQuery, Pageable pageable) {
        return null;
    }

    public Page<Map<String, Object>> findAllToMap(SelectQuery<Record> selectQuery, Pageable pageable) {
        return null;
    }

    public <R> Page<R> findAllToBean(SelectQuery<Record> selectQuery, Pageable pageable) {
        return null;
    }

    public Optional<T> findOneByQuery(String query, Object... objects) {
        return Optional.empty();
    }

    public <R> Optional<R> findOneByQuery(Class<R> type, String query, Object... objects) {
        return Optional.empty();
    }

    public Optional<Map<String, Object>> findOneByQueryToMap(String query, Object... objects) {
        return Optional.empty();
    }

    public <R> Optional<R> findOneByQueryToBean(Class<R> type, String query, Object... objects) {
        return Optional.empty();
    }

    public Optional<T> findOneByQuery(String query, Map<String, Object> map) {
        return Optional.empty();
    }

    public <R> Optional<R> findOneByQuery(Class<R> type, String query, Map<String, Object> map) {
        return Optional.empty();
    }

    public Optional<Map<String, Object>> findOneByQueryToMap(String query, Map<String, Object> map) {
        return Optional.empty();
    }

    public <R> Optional<R> findOneByQueryToBean(Class<R> type, String query, Map<String, Object> map) {
        return Optional.empty();
    }

    public List<T> findAllByQuery(String query, Object... objects) {
        return null;
    }

    public <R> List<R> findAllByQuery(Class<R> type, String query, Object... objects) {
        return null;
    }

    public List<Map<String, Object>> findAllByQueryToMap(String query, Object... objects) {
        return null;
    }

    public <R> List<R> findAllByQueryToBean(Class<R> type, String query, Object... objects) {
        return null;
    }

    public List<T> findAllByQuery(String query, Map<String, Object> map) {
        return null;
    }

    public <R> List<R> findAllByQuery(Class<R> type, String query, Map<String, Object> map) {
        return null;
    }

    public List<Map<String, Object>> findAllByQueryToMap(String query, Map<String, Object> map) {
        return null;
    }

    public <R> List<R> findAllByQueryToBean(Class<R> type, String query, Map<String, Object> map) {
        return null;
    }

    public Page<T> findAllByQuery(Pageable pageable, String sql, Object... objects) {
        return null;
    }

    public <R> Page<R> findAllByQuery(Class<R> type, Pageable pageable, String sql, Object... objects) {
        return null;
    }

    public Page<Map<String, Object>> findAllByQueryToMap(Pageable pageable, String sql, Object... objects) {
        return null;
    }

    public <R> Page<R> findAllByQueryToBean(Class<R> type, Pageable pageable, String sql, Object... objects) {
        return null;
    }

    public Page<T> findAllByQuery(Pageable pageable, String sql, Map<String, Object> map) {
        return null;
    }

    public <R> Page<R> findAllByQuery(Class<R> type, Pageable pageable, String sql, Map<String, Object> map) {
        return null;
    }

    public Page<Map<String, Object>> findAllByQueryToMap(Pageable pageable, String sql, Map<String, Object> map) {
        return null;
    }

    public <R> Page<R> findAllByQueryToBean(Class<R> type, Pageable pageable, String sql, Map<String, Object> map) {
        return null;
    }

    public Optional<T> findOneBySQLQuery(String sql, Object... objects) {
        return Optional.empty();
    }

    public <R> Optional<R> findOneBySQLQuery(Class<R> type, String sql, Object... objects) {
        return Optional.empty();
    }

    public Optional<Map<String, Object>> findOneBySQLQueryToMap(String sql, Object... objects) {
        return Optional.empty();
    }

    public <R> Optional<R> findOneBySQLQueryToBean(Class<R> type, String sql, Object... objects) {
        return Optional.empty();
    }

    public Optional<T> findOneBySQLQuery(String sql, Map<String, Object> map) {
        return Optional.empty();
    }

    public <R> Optional<R> findOneBySQLQuery(Class<R> type, String sql, Map<String, Object> map) {
        return Optional.empty();
    }

    public Optional<Map<String, Object>> findOneBySQLQueryToMap(String sql, Map<String, Object> map) {
        return Optional.empty();
    }

    public <R> Optional<R> findOneBySQLQueryToBean(Class<R> type, String sql, Map<String, Object> map) {
        return Optional.empty();
    }

    public List<T> findAllBySQLQuery(String sql, Object... objects) {
        return null;
    }

    public <R> List<R> findAllBySQLQuery(Class<R> type, String sql, Object... objects) {
        return null;
    }

    public List<Map<String, Object>> findAllBySQLQueryToMap(String sql, Object... objects) {
        return null;
    }

    public <R> List<R> findAllBySQLQueryToBean(Class<R> type, String sql, Object... objects) {
        return null;
    }

    public List<T> findAllBySQLQuery(String sql, Map<String, Object> map) {
        return null;
    }

    public <R> List<R> findAllBySQLQuery(Class<R> type, String sql, Map<String, Object> map) {
        return null;
    }

    public List<Map<String, Object>> findAllBySQLQueryToMap(String sql, Map<String, Object> map) {
        return null;
    }

    public <R> List<R> findAllBySQLQueryToBean(Class<R> type, String sql, Map<String, Object> map) {
        return null;
    }

    public Page<T> findAllBySQLQuery(Pageable pageable, String sql, Object... objects) {
        return null;
    }

    public <R> Page<R> findAllBySQLQuery(Class<R> type, Pageable pageable, String sql, Object... objects) {
        return null;
    }

    public Page<Map<String, Object>> findAllBySQLQueryToMap(Pageable pageable, String sql, Object... objects) {
        return null;
    }

    public <R> Page<R> findAllBySQLQueryToBean(Class<R> type, Pageable pageable, String sql, Object... objects) {
        return null;
    }


    public Page<T> findAllBySQLQuery(Pageable pageable, String sql, Map<String, Object> map) {
        return null;
    }

    public <R> Page<R> findAllBySQLQuery(Class<R> type, Pageable pageable, String sql, Map<String, Object> map) {
        return null;
    }

    public Page<Map<String, Object>> findAllBySQLQueryToMap(Pageable pageable, String sql, Map<String, Object> map) {
        return null;
    }

    public <R> Page<R> findAllBySQLQueryToBean(Class<R> type, Pageable pageable, String sql, Map<String, Object> map) {
        return null;
    }


    private <R> Optional<R> getSQLQueryBaseResult(Class<R> type, String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql, type);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        return Optional.ofNullable((R) nativeQuery.getSingleResult());
    }

    private <R> Optional<R> getQueryBaseResult(Class<R> type, String query, Object... objects) {
        TypedQuery<R> query1 = entityManager.createQuery(query, type);
        for (int i = 0; i < objects.length; i++) {
            query1.setParameter(i + 1, objects[i]);
        }
        return Optional.ofNullable(query1.getSingleResult());
    }

    private Optional<Map<String, Object>> getSQLQueryMap(String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
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

    private <R> Optional<R> getSQLQueryBean(Class<R> type, String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
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

    ///////////////////////////////////////////////////////

    private <R> List<R> getSQLQueryBaseResultList(Class<R> type, String sql, Object... objects) {
        Query nativeQuery = entityManager.createNativeQuery(sql, type);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        return nativeQuery.getResultList();
    }


    private <R> List<R> getQueryBaseResultList(Class<R> type, String query, Object... objects) {
        TypedQuery<R> nativeQuery = entityManager.createQuery(query, type);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
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

    private List<Map<String, Object>> getQueryMapList(String sql, Object... objects) {
        Query nativeQuery = entityManager.createQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
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

    private <R> List<R> getQueryBeanList(Class<R> type, String sql, Object... objects) {
        Query nativeQuery = entityManager.createQuery(sql);
        for (int i = 0; i < objects.length; i++) {
            nativeQuery.setParameter(i + 1, objects[i]);
        }
        nativeQuery.unwrap(QueryImpl.class).setResultTransformer(new AliasToBeanResultTransformer(type));
        return nativeQuery.getResultList();
    }


    private SelectQuery<Record> getDslQuery(SelectQuery<Record> selectQuery) {
        selectQuery = dslContext.select(selectQuery.getSelect()).from(DSL.table(selectQuery).asTable()).getQuery();
        return selectQuery;
    }

}
