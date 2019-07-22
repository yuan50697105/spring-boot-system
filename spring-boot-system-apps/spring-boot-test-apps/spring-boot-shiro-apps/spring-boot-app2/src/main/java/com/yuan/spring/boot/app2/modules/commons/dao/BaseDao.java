package com.yuan.spring.boot.app2.modules.commons.dao;

import com.yuan.spring.boot.app2.modules.commons.entity.domain.BaseEntity;
import com.yuan.spring.boot.dao.mybatis.plus.dao.MybatisPlusDao;

/**
 * @author yuane
 * @date 2019/7/22 22:53
 **/

public interface BaseDao<T extends BaseEntity> extends MybatisPlusDao<T,Long> {
}
