package com.yuan.spring.boot.dao.mybatis.plus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.spring.boot.dao.commons.service.BaseService;
import com.yuan.spring.boot.dao.mybatis.plus.entity.domain.MybatisPlusDomain;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 23:27
 **/
public interface MybatisPlusService<T extends MybatisPlusDomain<ID>, ID extends Serializable> extends BaseService<T, ID> {
    List<T> findAll();

    List<T> findAll(T t);

    IPage<T> findAll(IPage<T> page);

    IPage<T> findAll(T t, IPage<T> page);
}
