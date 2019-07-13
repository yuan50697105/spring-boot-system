package com.yuan.spring.boot.dao.mybatis.plus.dao;

import com.yuan.spring.boot.dao.mybatis.plus.entity.domain.MybatisPlusDomain;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 23:26
 **/
public interface MybatisPlusDao<T extends MybatisPlusDomain<ID>, ID extends Serializable> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {
}
