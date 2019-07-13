package com.yuan.spring.boot.app.modules.commons.service.impl;

import com.yuan.spring.boot.app.modules.commons.dao.MybatisPlusDao;
import com.yuan.spring.boot.app.modules.commons.entity.domain.BaseDomain;
import com.yuan.spring.boot.app.modules.commons.service.MybatisPlusService;

/**
 * @author yuane
 * @date 2019/7/13 1:18
 **/
public abstract class MybatisPlusServiceImpl<M extends MybatisPlusDao<T>, T extends BaseDomain> extends com.yuan.spring.boot.dao.mybatis.plus.service.impl.MybatisPlusServiceImpl<M, T, String> implements MybatisPlusService<T> {
}
