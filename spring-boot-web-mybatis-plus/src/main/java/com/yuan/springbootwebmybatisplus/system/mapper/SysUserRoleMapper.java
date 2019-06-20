package com.yuan.springbootwebmybatisplus.system.mapper;

import com.yuan.springbootwebmybatisplus.commons.mapper.BaseMapper;
import com.yuan.springbootwebmybatisplus.system.entity.po.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/6/20 23:04
 **/
@Repository
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
}
