package com.yuan.spring.boot.dao.jdbc.dao.impl;

import com.xphsc.easyjdbc.core.SimpleJdbcDao;
import com.yuan.spring.boot.dao.jdbc.dao.JdbcDao;
import com.yuan.spring.boot.dao.jdbc.entity.domain.JdbcDomain;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 22:08
 **/
public class JdbcDaoImpl<T extends JdbcDomain<ID>, ID extends Serializable> extends SimpleJdbcDao<T> implements JdbcDao<T, ID> {
}
