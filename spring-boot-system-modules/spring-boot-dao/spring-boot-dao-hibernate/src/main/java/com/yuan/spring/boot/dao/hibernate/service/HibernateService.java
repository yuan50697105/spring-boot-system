package com.yuan.spring.boot.dao.hibernate.service;

import com.yuan.spring.boot.dao.hibernate.entity.domain.HibernateDomain;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/
public interface HibernateService<T extends HibernateDomain<ID>, ID extends Serializable> extends com.yuan.spring.boot.dao.commons.service.BaseService<T, ID> {

}
