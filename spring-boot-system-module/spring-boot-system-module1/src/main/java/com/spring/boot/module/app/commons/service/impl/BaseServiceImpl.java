package com.spring.boot.module.app.commons.service.impl;

import com.spring.boot.module.app.commons.dao.BaseDao;
import com.spring.boot.module.app.commons.entity.po.BasePo;
import com.spring.boot.module.app.commons.service.BaseService;

public abstract class BaseServiceImpl<M extends BaseDao<T>, T extends BasePo> extends com.yuan.spring.boot.dao.mybatis.plus.commons.service.impl.BaseServiceImpl<M, T, String> implements BaseService<T> {
}
