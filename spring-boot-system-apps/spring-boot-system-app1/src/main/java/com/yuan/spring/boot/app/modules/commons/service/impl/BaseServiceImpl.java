package com.yuan.spring.boot.app.modules.commons.service.impl;

import com.yuan.spring.boot.app.modules.commons.dao.BaseDao;
import com.yuan.spring.boot.app.modules.commons.entity.domain.BaseDomain;
import com.yuan.spring.boot.app.modules.commons.service.BaseService;

/**
 * @author yuane
 * @date 2019/7/13 1:18
 **/
public abstract class BaseServiceImpl<M extends BaseDao<T>, T extends BaseDomain> extends com.yuan.spring.boot.dao.mybatis.plus.commons.service.impl.BaseServiceImpl<M, T, String> implements BaseService<T> {
}
