package com.yuan.spring.boot.app2.modules.commons.service.impl;

import cn.hutool.core.util.IdUtil;
import com.yuan.spring.boot.app2.modules.commons.dao.BaseDao;
import com.yuan.spring.boot.app2.modules.commons.entity.domain.BaseEntity;
import com.yuan.spring.boot.app2.modules.commons.service.BaseService;
import com.yuan.spring.boot.dao.mybatis.plus.service.impl.MybatisPlusServiceImpl;

/**
 * @author yuane
 * @date 2019/7/22 22:53
 **/
public abstract class BaseServiceImpl<S extends BaseDao<T>, T extends BaseEntity> extends MybatisPlusServiceImpl<S, T, Long> implements BaseService<T> {
    protected T setId(T t) {
        t.setId(IdUtil.getSnowflake(1, 1).nextId());
        return t;
    }

    protected T setCommonsParams(T t) {
        return t;
    }
}
