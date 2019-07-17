package com.yuan.spring.boot.app2.modules.commons.service;

import com.yuan.spring.boot.app2.modules.commons.entity.domain.AbstractEntity;
import com.yuan.spring.boot.dao.mybatis.plus.service.MybatisPlusService;

public interface CommonsService<T extends AbstractEntity> extends MybatisPlusService<T, Long> {
}
