package com.yuan.spring.boot.dao.mybatis.enhance.dao;

import com.gitee.hengboy.mybatis.enhance.mapper.EnhanceMapper;
import com.yuan.spring.boot.dao.mybatis.enhance.entity.domain.MybatisEnhanceDomain;

import java.io.Serializable;


public interface MybatisEnhanceDao<T extends MybatisEnhanceDomain, ID extends Serializable> extends EnhanceMapper<T, ID> {
}
