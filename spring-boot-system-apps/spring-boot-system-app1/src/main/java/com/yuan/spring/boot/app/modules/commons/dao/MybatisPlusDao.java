package com.yuan.spring.boot.app.modules.commons.dao;

import com.yuan.spring.boot.app.modules.commons.entity.domain.BaseDomain;

/**
 * @author yuane
 * @date 2019/7/13 1:16
 **/
public interface MybatisPlusDao<T extends BaseDomain> extends com.yuan.spring.boot.dao.mybatis.plus.dao.MybatisPlusDao<T, String> {
}
