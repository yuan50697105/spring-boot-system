package com.yuan.spring.boot.test.app1.module.commons.service;

import com.yuan.spring.boot.dao.mybatis.service.MybatisService;
import com.yuan.spring.boot.test.app1.module.commons.entity.domain.BaseEntity;

/**
 * @author yuane
 * @date 2019/7/21 1:09
 **/
public interface BaseService<T extends BaseEntity> extends MybatisService<T,Long> {
}
