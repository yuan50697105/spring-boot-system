package com.yuan.spring.boot.dao.mybatis.enhance.service;

import com.gitee.hengboy.mybatis.pageable.Page;
import com.gitee.hengboy.mybatis.pageable.request.Pageable;
import com.yuan.spring.boot.dao.commons.service.BaseService;
import com.yuan.spring.boot.dao.mybatis.enhance.entity.domain.EnhanceDomain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface EnhanceService<T extends EnhanceDomain<ID>, ID extends Serializable> extends BaseService<T, ID> {

    List<T> findAllById(ID[] ids);

    List<T> findAllById(Collection<ID> collection);

    List<T> findAll();

    Page<T> findAll(Pageable pageable);


}
