package com.yuan.spring.boot.dao.ebean.service;

import com.yuan.spring.boot.dao.ebean.entity.domain.EbeanDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/13 12:37
 **/
public interface EbeanService<T extends EbeanDomain<ID>, ID extends Serializable> extends com.yuan.spring.boot.dao.commons.service.BaseService<T, ID> {
    List<T> findAllById(ID[] ids);

    List<T> findAllById(Collection<ID> collection);

    T findOne(T t);

    List<T> findAll();

    List<T> findAll(Sort sort);

    List<T> findAll(T t);

    List<T> findAll(T t, Sort sort);

    Page<T> findAll(Pageable pageable);

    Page<T> findAll(T t, Pageable pageable);


}
