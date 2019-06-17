package com.yuan.springbootwebjdbc.commons.dao.impl;

import com.xphsc.easyjdbc.core.SimpleJdbcDao;
import com.yuan.springbootwebjdbc.commons.dao.BaseDao;
import com.yuan.springbootwebjdbc.commons.entity.BaseEntity;

/**
 * @author yuane
 * @date 2019/6/15 16:27
 **/
public abstract class BaseDaoImpl<T extends BaseEntity> extends SimpleJdbcDao<T> implements BaseDao<T> {

}
