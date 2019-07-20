package com.yuan.spring.boot.dao.mybatis.mapper.service;

import com.yuan.spring.boot.dao.commons.service.BaseService;
import com.yuan.spring.boot.dao.mybatis.mapper.entity.domain.MybatisMapperDomain;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 23:09
 **/
public interface MybatisMapperService<T extends MybatisMapperDomain<ID>, ID extends Serializable> extends BaseService<T, ID> {


}
