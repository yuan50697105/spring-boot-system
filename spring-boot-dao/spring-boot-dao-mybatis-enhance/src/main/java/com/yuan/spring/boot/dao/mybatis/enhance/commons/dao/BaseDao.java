package com.yuan.spring.boot.dao.mybatis.enhance.commons.dao;

import com.gitee.hengboy.mybatis.enhance.mapper.EnhanceMapper;
import com.yuan.spring.boot.dao.mybatis.enhance.commons.entity.po.BasePo;

import java.io.Serializable;


public interface BaseDao<T extends BasePo, ID extends Serializable> extends EnhanceMapper<T, ID> {
}
