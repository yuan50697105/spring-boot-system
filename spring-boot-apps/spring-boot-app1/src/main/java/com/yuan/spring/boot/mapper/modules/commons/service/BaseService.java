package com.yuan.spring.boot.mapper.modules.commons.service;

import com.yuan.spring.boot.mapper.modules.commons.entity.domain.BaseDomain;

/**
 * @author yuane
 * @date 2019/7/13 1:17
 **/
public interface BaseService<T extends BaseDomain> extends com.yuan.spring.boot.dao.mybatis.plus.service.MybatisPlusService<T, String> {
}
