package com.spring.boot.test.app3.modules.commons.dao;

import com.spring.boot.test.app3.modules.commons.entity.domain.BaseEntity;
import com.yuan.spring.boot.dao.mybatis.mapper.dao.MybatisMapperDao;
import tk.mybatis.mapper.annotation.RegisterMapper;

@RegisterMapper
public interface BaseDao<T extends BaseEntity> extends MybatisMapperDao<T, Long> {
}
