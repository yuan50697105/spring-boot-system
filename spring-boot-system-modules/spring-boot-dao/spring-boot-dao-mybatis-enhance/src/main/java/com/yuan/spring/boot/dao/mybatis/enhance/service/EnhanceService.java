package com.yuan.spring.boot.dao.mybatis.enhance.service;

import com.yuan.spring.boot.dao.commons.service.BaseService;
import com.yuan.spring.boot.dao.mybatis.enhance.entity.domain.EnhanceDomain;

import java.io.Serializable;

public interface EnhanceService<T extends EnhanceDomain<ID>, ID extends Serializable> extends BaseService<T, ID> {

}
