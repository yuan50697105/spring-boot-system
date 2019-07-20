package com.yuan.spring.boot.test.app1.module.commons.dao;

import com.yuan.spring.boot.dao.mybatis.dao.MybatisDao;
import com.yuan.spring.boot.test.app1.module.commons.entity.domain.BaseEntity;

/**
 * @author yuane
 * @date 2019/7/21 1:08
 **/
public interface BaseDao<T extends BaseEntity> extends MybatisDao<T,Long> {
}
