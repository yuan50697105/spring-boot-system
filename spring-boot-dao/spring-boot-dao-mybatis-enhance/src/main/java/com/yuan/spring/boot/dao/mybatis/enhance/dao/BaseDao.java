package com.yuan.spring.boot.dao.mybatis.enhance.dao;

import com.gitee.hengboy.mybatis.enhance.mapper.EnhanceMapper;
import com.yuan.spring.boot.dao.mybatis.enhance.entity.domain.EnhanceDomain;

import java.io.Serializable;


public interface BaseDao<T extends EnhanceDomain, ID extends Serializable> extends EnhanceMapper<T, ID> {
}
