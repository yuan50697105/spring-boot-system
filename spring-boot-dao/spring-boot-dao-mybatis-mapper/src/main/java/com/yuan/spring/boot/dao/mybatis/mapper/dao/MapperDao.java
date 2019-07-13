package com.yuan.spring.boot.dao.mybatis.mapper.dao;

import com.yuan.spring.boot.dao.mybatis.mapper.entity.domain.MapperDomain;
import tk.mybatis.mapper.additional.dialect.oracle.OracleMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.SqlServerMapper;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 22:48
 **/
@RegisterMapper
public interface MapperDao<T extends MapperDomain<ID>, ID extends Serializable> extends Mapper<T>, MySqlMapper<T>, OracleMapper<T>, SqlServerMapper<T> {
}
