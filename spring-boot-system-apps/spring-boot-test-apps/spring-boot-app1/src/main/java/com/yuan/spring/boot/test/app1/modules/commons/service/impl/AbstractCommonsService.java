package com.yuan.spring.boot.test.app1.modules.commons.service.impl;

import cn.hutool.core.util.IdUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.dao.mybatis.service.impl.MybatisServiceImpl;
import com.yuan.spring.boot.test.app1.modules.commons.dao.CommonsDao;
import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import com.yuan.spring.boot.test.app1.modules.commons.service.CommonsService;

public abstract class AbstractCommonsService<S extends CommonsDao<T>, T extends AbstractEntity> extends MybatisServiceImpl<S, T, Long> implements CommonsService<T> {
    @Override
    protected T setCommonsParams(T t) {
        return t;
    }

    @Override
    protected T setId(T t) {
        t.setId(IdUtil.getSnowflake(1, 1).nextId());
        return t;
    }

    @Override
    public ServiceResult checkSave(T t) {
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult checkUpdate(T t) {
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult checkDelete(T t) {
        return ServiceResultUtils.ok();
    }
}
