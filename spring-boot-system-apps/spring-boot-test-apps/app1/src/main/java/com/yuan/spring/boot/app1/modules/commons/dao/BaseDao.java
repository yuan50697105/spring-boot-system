package com.yuan.spring.boot.app1.modules.commons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuan.spring.boot.app1.modules.commons.entity.domain.BaseDomain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/7/13 1:16
 **/
@Repository
@Mapper
public interface BaseDao<T extends BaseDomain> extends BaseMapper<T>, com.yuan.spring.boot.dao.mybatis.plus.dao.MybatisPlusDao<T, Long> {
}
