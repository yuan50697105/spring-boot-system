package com.yuan.springbootwebenhance.commons.mapper;

import com.gitee.hengboy.mybatis.enhance.mapper.EnhanceMapper;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 22:21
 **/
public interface BaseMapper<T, ID extends Serializable> extends EnhanceMapper<T, ID> {
}
