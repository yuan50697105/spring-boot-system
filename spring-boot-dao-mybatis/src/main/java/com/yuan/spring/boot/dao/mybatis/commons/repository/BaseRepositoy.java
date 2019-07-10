package com.yuan.spring.boot.dao.mybatis.commons.repository;

import org.springframework.data.mybatis.repository.MybatisRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author yuane
 * @date 2019/7/10 21:47
 **/
@NoRepositoryBean
public interface BaseRepositoy<T, ID> extends MybatisRepository<T, ID> {
}
