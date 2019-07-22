package com.yuan.spring.boot.test.app1.module.commons.service.impl;

import cn.hutool.core.util.IdUtil;
import com.yuan.spring.boot.dao.jdbc.service.impl.JdbcServiceImpl;
import com.yuan.spring.boot.test.app1.module.commons.dao.BaseJdbcDao;
import com.yuan.spring.boot.test.app1.module.commons.entity.domain.BaseJdbcEntity;
import com.yuan.spring.boot.test.app1.module.commons.service.BaseJdbcService;

/**
 * @author yuane
 * @date 2019/7/22 18:39
 **/
public abstract class BaseJdbcServiceImpl<S extends BaseJdbcDao<T>, T extends BaseJdbcEntity> extends JdbcServiceImpl<S, T, Long> implements BaseJdbcService<T> {
    @Override
    protected T setId(T t) {
        t.setId(IdUtil.getSnowflake(1,1).nextId());
        return t;
    }

    @Override
    protected T setCommonsParams(T t) {
        return t;
    }

}
