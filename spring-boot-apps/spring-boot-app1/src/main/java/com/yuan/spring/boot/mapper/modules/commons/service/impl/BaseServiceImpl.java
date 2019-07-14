package com.yuan.spring.boot.mapper.modules.commons.service.impl;

import cn.hutool.core.util.IdUtil;
import com.yuan.spring.boot.mapper.modules.commons.dao.BaseDao;
import com.yuan.spring.boot.mapper.modules.commons.entity.domain.BaseDomain;
import com.yuan.spring.boot.mapper.modules.commons.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:18
 **/
public abstract class BaseServiceImpl<M extends BaseDao<T>, T extends BaseDomain> extends com.yuan.spring.boot.dao.mybatis.plus.service.impl.MybatisPlusServiceImpl<M, T, String> implements BaseService<T> {
    @Autowired
    protected M baseDao;

    @Override
    public M getBaseDao() {
        return baseDao;
    }

    @Override
    protected T setCommonsParameters(T entity) {
        entity.setCreateDate(new Date());
        entity.setUpdateDate(new Date());
        return entity;
    }

    @Override
    protected T setId(T t) {
        t.setId(IdUtil.fastSimpleUUID());
        return t;
    }
}
