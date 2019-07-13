package com.yuan.spring.boot.dao.mybatis.service;

import com.yuan.spring.boot.dao.commons.service.BaseService;
import com.yuan.spring.boot.dao.mybatis.entity.domain.MybatisDomain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/7/10 21:47
 **/
public interface MybatisService<T extends MybatisDomain<ID>, ID extends Serializable> extends BaseService<T, ID> {

    List<T> findAllById(ID[] ids);

    List<T> findAllById(Collection<ID> iterable);
}
