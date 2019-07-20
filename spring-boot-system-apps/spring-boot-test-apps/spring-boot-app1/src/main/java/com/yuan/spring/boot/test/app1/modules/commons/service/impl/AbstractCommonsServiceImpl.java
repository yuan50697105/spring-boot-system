package com.yuan.spring.boot.test.app1.modules.commons.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.mybatis.plus.service.impl.MybatisPlusServiceImpl;
import com.yuan.spring.boot.test.app1.modules.commons.dao.CommonsDao;
import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import com.yuan.spring.boot.test.app1.modules.commons.service.CommonsService;

public abstract class AbstractCommonsServiceImpl<S extends CommonsDao<T>, T extends AbstractEntity> extends MybatisPlusServiceImpl<S, T, Long> implements CommonsService<T> {

    @Override
    protected T setCommonsParams(T t) {
        return t;
    }

    @Override
    protected T setId(T t) {
        t.setId(IdUtil.getSnowflake(1, 1).nextId());
        return t;
    }

    protected boolean isNotEmpty(Object object) {
        return ObjectUtil.isNotEmpty(object);
    }

    protected boolean isBetween(Object object, int min, int max) {
        String s = object.toString();
        return min <= s.length() && s.length() <= max;
    }

    protected boolean isNotBetween(Object object, int min, int max) {
        return !isBetween(object, min, max);
    }
}
