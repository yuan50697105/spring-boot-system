package com.yuan.spring.boot.test.app1.module.commons.service.impl;

import com.yuan.spring.boot.dao.mybatis.service.impl.MybatisServiceImpl;
import com.yuan.spring.boot.test.app1.module.commons.dao.BaseDao;
import com.yuan.spring.boot.test.app1.module.commons.entity.domain.BaseEntity;
import com.yuan.spring.boot.test.app1.module.commons.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/7/21 1:09
 **/
@Service
public abstract class BaseServiceImpl<S extends BaseDao<T>, T extends BaseEntity> extends MybatisServiceImpl<S, T, Long> implements BaseService<T> {
    @Override
    protected T setId(T t) {
        return t;
    }

    @Override
    protected T setCommonsParams(T t) {
        return t;
    }

}
