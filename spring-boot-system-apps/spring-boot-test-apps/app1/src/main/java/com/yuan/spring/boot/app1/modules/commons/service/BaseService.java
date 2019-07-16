package com.yuan.spring.boot.app1.modules.commons.service;

import com.yuan.spring.boot.app1.modules.commons.entity.domain.BaseDomain;

/**
 * @author yuane
 * @date 2019/7/13 1:17
 **/
public interface BaseService<T extends BaseDomain> extends com.yuan.spring.boot.dao.mybatis.plus.service.MybatisPlusService<T, Long> {
}
