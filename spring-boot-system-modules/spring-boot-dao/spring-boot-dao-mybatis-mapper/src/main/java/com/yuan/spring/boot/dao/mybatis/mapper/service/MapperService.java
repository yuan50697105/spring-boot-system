package com.yuan.spring.boot.dao.mybatis.mapper.service;

import com.github.pagehelper.IPage;
import com.github.pagehelper.PageInfo;
import com.yuan.spring.boot.dao.commons.service.BaseService;
import com.yuan.spring.boot.dao.mybatis.mapper.entity.domain.MapperDomain;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 23:09
 **/
public interface MapperService<T extends MapperDomain<ID>, ID extends Serializable> extends BaseService<T,ID> {

    List<T> findAll(T t);

    T findOne(T t);

    PageInfo<T> findAll(IPage page);

    PageInfo<T> findAll(T t, IPage page);

    List<T> findAll();


}
