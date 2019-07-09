package com.yuan.spring.boot.mybatis.mapper.commons.mapper;

import com.yuan.spring.boot.mybatis.mapper.commons.entity.po.BasePo;
import tk.mybatis.mapper.additional.dialect.oracle.OracleMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.SqlServerMapper;

/**
 * @author yuane
 * @date 2019/6/15 22:48
 **/
@RegisterMapper
public interface BaseMapper<T extends BasePo> extends Mapper<T>, MySqlMapper<T>, OracleMapper<T>, SqlServerMapper<T> {
}
