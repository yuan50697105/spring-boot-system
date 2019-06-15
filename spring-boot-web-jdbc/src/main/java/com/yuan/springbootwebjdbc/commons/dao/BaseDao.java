package com.yuan.springbootwebjdbc.commons.dao;

import com.xphsc.easyjdbc.core.EasyJdbcDao;
import com.yuan.springbootwebjdbc.commons.entity.BaseEntity;

/**
 * @author yuane
 * @date 2019/6/15 16:27
 **/
public interface BaseDao<T extends BaseEntity> extends EasyJdbcDao<T> {
}
