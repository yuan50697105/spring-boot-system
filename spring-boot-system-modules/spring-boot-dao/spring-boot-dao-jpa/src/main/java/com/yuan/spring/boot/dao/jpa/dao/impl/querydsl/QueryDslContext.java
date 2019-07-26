package com.yuan.spring.boot.dao.jpa.dao.impl.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/**
 * @author yuane
 * @date 2019/7/26 0:09
 **/
@Component
public class QueryDslContext {
    private final EntityManager entityManager;

    public QueryDslContext(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public JPAQueryFactory getQuery() {
        return new JPAQueryFactory(entityManager);
    }

}
