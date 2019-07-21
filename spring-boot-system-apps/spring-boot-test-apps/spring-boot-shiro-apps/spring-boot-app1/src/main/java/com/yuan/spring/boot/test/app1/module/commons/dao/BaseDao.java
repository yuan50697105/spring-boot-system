package com.yuan.spring.boot.test.app1.module.commons.dao;

import com.yuan.spring.boot.dao.mybatis.dao.MybatisDao;
import com.yuan.spring.boot.test.app1.module.commons.entity.domain.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author yuane
 * @date 2019/7/21 1:08
 **/

@NoRepositoryBean
public interface BaseDao<T extends BaseEntity> extends MybatisDao<T,Long> {
}
