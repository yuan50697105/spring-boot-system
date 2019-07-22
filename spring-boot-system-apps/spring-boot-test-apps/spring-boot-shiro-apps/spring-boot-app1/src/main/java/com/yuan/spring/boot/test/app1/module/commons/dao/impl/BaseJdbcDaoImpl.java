package com.yuan.spring.boot.test.app1.module.commons.dao.impl;

import com.yuan.spring.boot.dao.jdbc.dao.impl.JdbcDaoImpl;
import com.yuan.spring.boot.test.app1.module.commons.dao.BaseJdbcDao;
import com.yuan.spring.boot.test.app1.module.commons.entity.domain.BaseJdbcEntity;

/**
 * @author yuane
 * @date 2019/7/22 18:37
 **/
public class BaseJdbcDaoImpl<T extends BaseJdbcEntity> extends JdbcDaoImpl<T, Long> implements BaseJdbcDao<T> {
}
