package com.yuan.spring.boot.app2.modules.commons.service;

import com.yuan.spring.boot.app2.modules.commons.entity.domain.BaseEntity;
import com.yuan.spring.boot.dao.mybatis.plus.service.MybatisPlusService;

/**
 * @author yuane
 * @date 2019/7/22 22:53
 **/
public interface BaseService<T extends BaseEntity> extends MybatisPlusService<T,Long> {
}
