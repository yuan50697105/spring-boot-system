package com.yuan.spring.boot.dao.hibernate.service;

import com.yuan.spring.boot.dao.hibernate.entity.domain.HibernateDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 19:07
 **/
public interface HibernateService<T extends HibernateDomain<ID>, ID extends Serializable> extends com.yuan.spring.boot.dao.commons.service.BaseService<T, ID> {


    List<T> findAllById(ID[] ids);

    List<T> findAllById(Collection<ID> collection);

    T findOne(T t);

    List<T> findAll();

    List<T> findAll(T t);

    List<T> findAll(T t, Sort sort);

    Page<T> findAll(Pageable pageable);

    Page<T> findAll(T t, Pageable pageable);

}
