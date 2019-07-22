package com.yuan.spring.boot.dao.jdbc.dao;

import com.xphsc.easyjdbc.core.EasyJdbcDao;
import com.yuan.spring.boot.dao.jdbc.entity.domain.JdbcDomain;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 22:01
 **/
@NoRepositoryBean
public interface JdbcDao<T extends JdbcDomain<ID>, ID extends Serializable> extends EasyJdbcDao<T>, Repository<T, ID> {
}

