package com.yuan.spring.boot.dao.jdbc.dao;

import com.xphsc.easyjdbc.core.EasyJdbcDao;
import com.yuan.spring.boot.dao.jdbc.entity.domain.JdbcDomain;
import org.jooq.DSLContext;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 22:01
 **/
public interface JdbcDao<T extends JdbcDomain<ID>, ID extends Serializable> extends EasyJdbcDao<T> {
    DSLContext getDslContext();
}
