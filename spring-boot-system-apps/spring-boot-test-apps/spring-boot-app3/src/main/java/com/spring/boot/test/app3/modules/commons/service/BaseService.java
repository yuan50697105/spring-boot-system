package com.spring.boot.test.app3.modules.commons.service;

import com.spring.boot.test.app3.modules.commons.entity.domain.BaseEntity;
import com.yuan.spring.boot.dao.mybatis.mapper.service.MybatisMapperService;

public interface BaseService<T extends BaseEntity> extends MybatisMapperService<T, Long> {
}
