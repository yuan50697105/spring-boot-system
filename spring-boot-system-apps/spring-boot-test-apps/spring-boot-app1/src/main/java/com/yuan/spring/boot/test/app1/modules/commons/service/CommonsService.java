package com.yuan.spring.boot.test.app1.modules.commons.service;

import com.yuan.spring.boot.dao.mybatis.plus.service.MybatisPlusService;
import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;

/**
 * @author yuane
 * @date 2019/7/17 0:42
 **/
public interface CommonsService<T extends AbstractEntity> extends MybatisPlusService<T, Long> {
}
