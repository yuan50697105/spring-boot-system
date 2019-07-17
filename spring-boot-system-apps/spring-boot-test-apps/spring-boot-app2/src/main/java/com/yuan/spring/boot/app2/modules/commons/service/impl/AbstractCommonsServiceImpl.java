package com.yuan.spring.boot.app2.modules.commons.service.impl;

import cn.hutool.core.util.IdUtil;
import com.yuan.spring.boot.app2.modules.commons.dao.CommonsDao;
import com.yuan.spring.boot.app2.modules.commons.entity.domain.AbstractEntity;
import com.yuan.spring.boot.app2.modules.commons.service.CommonsService;
import com.yuan.spring.boot.dao.mybatis.plus.service.impl.MybatisPlusServiceImpl;

public abstract class AbstractCommonsServiceImpl<S extends CommonsDao<T>, T extends AbstractEntity> extends MybatisPlusServiceImpl<S, T, Long> implements CommonsService<T> {
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
