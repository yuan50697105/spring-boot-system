package com.yuan.spring.app1.modules.commons.dao;

import com.yuan.spring.app1.modules.commons.entity.domain.BaseEntity;

/**
 * @author yuane
 * @date 2019/7/27 10:52
 **/
public interface BaseDao<T extends BaseEntity> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {
}
