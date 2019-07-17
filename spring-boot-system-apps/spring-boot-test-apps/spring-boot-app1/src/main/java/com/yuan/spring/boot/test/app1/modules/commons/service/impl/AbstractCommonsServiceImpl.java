package com.yuan.spring.boot.test.app1.modules.commons.service.impl;

import cn.hutool.core.util.IdUtil;
import com.yuan.spring.boot.dao.mybatis.service.impl.MybatisServiceImpl;
import com.yuan.spring.boot.test.app1.modules.commons.dao.CommonsDao;
import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import com.yuan.spring.boot.test.app1.modules.commons.service.CommonsService;

public abstract class AbstractCommonsServiceImpl<S extends CommonsDao<T>, T extends AbstractEntity> extends MybatisServiceImpl<S, T, Long> implements CommonsService<T> {
    @Override
    protected T setCommonsParameters(T entity) {
        return entity;
    }

    @Override
    protected T setId(T t) {
        t.setId(IdUtil.getSnowflake(1, 1).nextId());
        return t;
    }
}
