package com.yuan.spring.boot.app1.modules.commons.service.impl;

import cn.hutool.core.util.IdUtil;
import com.yuan.spring.boot.app1.modules.commons.dao.BaseDao;
import com.yuan.spring.boot.app1.modules.commons.entity.domain.BaseDomain;
import com.yuan.spring.boot.app1.modules.commons.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:18
 **/
public abstract class BaseServiceImpl<M extends BaseDao<T>, T extends BaseDomain> extends com.yuan.spring.boot.dao.mybatis.plus.service.impl.MybatisPlusServiceImpl<M, T, Long> implements BaseService<T> {
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
//        主键生成策略
//        objectId
//        t.setId(IdUtil.objectId());
//        uuid无-
//        t.setId(IdUtil.fastSimpleUUID());
//        uuid有-
//        t.setId(IdUtil.fastUUID());
//        雪花算法
//        t.setId(IdUtil.getSnowflake(0L, 0L).nextIdStr());
        t.setId(IdUtil.getSnowflake(0, 0).nextId());
        long a = 1;
        return t;
    }
}
