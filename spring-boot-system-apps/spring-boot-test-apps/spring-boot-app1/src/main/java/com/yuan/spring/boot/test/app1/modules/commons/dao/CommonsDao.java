package com.yuan.spring.boot.test.app1.modules.commons.dao;

import com.yuan.spring.boot.dao.mybatis.plus.dao.MybatisPlusDao;
import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;

/**
 * @author yuane
 * @date 2019/7/17 0:41
 **/
public interface CommonsDao<T extends AbstractEntity> extends MybatisPlusDao<T, Long> {
}
