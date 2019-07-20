package com.spring.boot.test.app3.modules.commons.service.impl;

import cn.hutool.core.util.IdUtil;
import com.spring.boot.test.app3.modules.commons.dao.BaseDao;
import com.spring.boot.test.app3.modules.commons.entity.domain.BaseEntity;
import com.spring.boot.test.app3.modules.commons.service.BaseService;
import com.yuan.spring.boot.dao.mybatis.mapper.service.impl.MybatisMapperServiceImpl;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<S extends BaseDao<T>, T extends BaseEntity> extends MybatisMapperServiceImpl<S, T, Long> implements BaseService<T> {
    @Override
    protected T setId(T t) {
        t.setId(IdUtil.getSnowflake(1, 1).nextId());
        return t;
    }

    @Override
    protected T setCommonsParams(T t) {
        return t;
    }


}
