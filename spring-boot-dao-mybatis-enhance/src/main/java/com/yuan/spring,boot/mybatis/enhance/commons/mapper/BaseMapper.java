package com.yuan.springbootwebmybatisenhance.commons.mapper;

import com.gitee.hengboy.mybatis.enhance.mapper.EnhanceMapper;
import com.yuan.springbootwebmybatisenhance.commons.entity.po.BasePo;

import java.io.Serializable;


public interface BaseMapper<T extends BasePo, ID extends Serializable> extends EnhanceMapper<T, ID> {
}
