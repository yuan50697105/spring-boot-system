package com.yuan.spring.boot.jooq.dao;

import com.yuan.spring.boot.jooq.entity.domain.JooqDomain;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/18 22:14
 **/
public interface JooqDao<T extends JooqDomain<ID>, ID extends Serializable> {
}
