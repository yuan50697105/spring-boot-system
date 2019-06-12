package com.yuan.springbootwebjdbc.dao.impl;

import com.yuan.springbootwebjdbc.dao.BaseRepository;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.data.jdbc.repository.support.SimpleJdbcRepository;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class BaseRepositoryImpl<T, ID> extends SimpleJdbcRepository<T, ID> implements BaseRepository<T, ID> {
    private final JdbcAggregateOperations aggregateOperations;
    private final PersistentEntity<T, ?> entity;

    public BaseRepositoryImpl(@NonNull JdbcAggregateOperations entityOperations, @NonNull PersistentEntity<T, ?> entity) {
        super(entityOperations, entity);
        this.aggregateOperations = entityOperations;
        this.entity = entity;
    }

    public Page<T> findAll(String sql, Pageable pageable, Object... objects) {
        return Page.empty();
    }
}
