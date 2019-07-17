package com.yuan.spring.boot.app2.modules.commons.dao;

import com.yuan.spring.boot.app2.modules.commons.entity.domain.AbstractEntity;
import com.yuan.spring.boot.dao.mybatis.plus.dao.MybatisPlusDao;

public interface CommonsDao<T extends AbstractEntity> extends MybatisPlusDao<T, Long> {
}
