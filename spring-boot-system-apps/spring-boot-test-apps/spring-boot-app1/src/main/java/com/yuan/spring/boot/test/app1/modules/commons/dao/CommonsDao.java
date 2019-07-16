package com.yuan.spring.boot.test.app1.modules.commons.dao;

import com.yuan.spring.boot.dao.mybatis.dao.MybatisDao;
import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author yuane
 * @date 2019/7/17 0:41
 **/
@NoRepositoryBean
public interface CommonsDao<T extends AbstractEntity> extends MybatisDao<T, Long> {
}
