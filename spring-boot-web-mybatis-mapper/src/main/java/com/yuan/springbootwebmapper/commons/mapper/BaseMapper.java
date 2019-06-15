package com.yuan.springbootwebmapper.commons.mapper;

import tk.mybatis.mapper.additional.dialect.oracle.OracleMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.SqlServerMapper;

/**
 * @author yuane
 * @date 2019/6/15 22:48
 **/
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, OracleMapper<T>, SqlServerMapper<T> {
}
