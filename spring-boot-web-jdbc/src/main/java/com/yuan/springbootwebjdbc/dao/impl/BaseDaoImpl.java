package com.yuan.springbootwebjdbc.dao.impl;

import com.xphsc.easyjdbc.core.SimpleJdbcDao;
import com.yuan.springbootwebjdbc.dao.BaseDao;

/**
 * @author yuane
 * @date 2019/6/15 16:08
 **/
public abstract class BaseDaoImpl<T> extends SimpleJdbcDao<T> implements BaseDao<T> {
}
