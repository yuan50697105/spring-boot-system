package com.yuan.spring.boot.dao.mybatis.commons.dao;

import com.yuan.spring.boot.dao.mybatis.commons.entity.po.BasePo;
import org.springframework.data.mybatis.repository.MybatisRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/10 21:47
 **/
@NoRepositoryBean
public interface BaseDao<T extends BasePo<ID>, ID extends Serializable> extends MybatisRepository<T, ID> {
}
