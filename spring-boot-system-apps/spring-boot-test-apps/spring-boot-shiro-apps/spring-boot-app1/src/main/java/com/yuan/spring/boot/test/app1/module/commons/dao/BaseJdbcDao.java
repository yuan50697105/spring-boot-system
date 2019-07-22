package com.yuan.spring.boot.test.app1.module.commons.dao;

import com.yuan.spring.boot.dao.jdbc.dao.JdbcDao;
import com.yuan.spring.boot.test.app1.module.commons.entity.domain.BaseJdbcEntity;

/**
 * @author yuane
 * @date 2019/7/22 18:36
 **/
public interface BaseJdbcDao<T extends BaseJdbcEntity> extends JdbcDao<T, Long> {
}
