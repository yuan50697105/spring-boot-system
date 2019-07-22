package com.yuan.spring.boot.dao.mybatis.dao;

import com.yuan.spring.boot.dao.mybatis.entity.domain.MybatisDomain;
import org.springframework.data.mybatis.repository.MybatisRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/10 21:47
 **/
@NoRepositoryBean
public interface MybatisDao<T extends MybatisDomain<ID>, ID extends Serializable> extends MybatisRepository<T, ID> {

}
