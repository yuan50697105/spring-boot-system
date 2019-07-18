package com.yuan.spring.boot.dao.mybatis.mapper.dao;

import com.yuan.spring.boot.dao.mybatis.mapper.entity.domain.MapperDomain;
import tk.mybatis.mapper.additional.dialect.oracle.OracleMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.*;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 22:48
 **/
@RegisterMapper
public interface MapperDao<T extends MapperDomain<ID>, ID extends Serializable> extends Mapper<T>, RowBoundsMapper<T>, IdsMapper<T>, MySqlMapper<T>, OracleMapper<T>, SqlServerMapper<T>, ConditionMapper<T> {
}
