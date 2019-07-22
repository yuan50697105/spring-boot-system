package com.yuan.spring.boot.test.app1.module.commons.service;

import com.yuan.spring.boot.dao.jdbc.service.JdbcService;
import com.yuan.spring.boot.test.app1.module.commons.entity.domain.BaseJdbcEntity;

/**
 * @author yuane
 * @date 2019/7/22 18:38
 **/
public interface BaseJdbcService<T extends BaseJdbcEntity> extends JdbcService<T, Long> {
}
