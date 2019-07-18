package com.yuan.spring.boot.dao.jdbc.service;

import com.yuan.spring.boot.dao.commons.service.BaseService;
import com.yuan.spring.boot.dao.jdbc.entity.domain.JdbcDomain;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/7/13 22:41
 **/
public interface JdbcService<T extends JdbcDomain<ID>, ID extends Serializable> extends BaseService<T, ID> {
}
