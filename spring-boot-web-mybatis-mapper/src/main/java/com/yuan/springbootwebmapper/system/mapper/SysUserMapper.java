package com.yuan.springbootwebmapper.system.mapper;

import com.yuan.springbootwebmapper.commons.mapper.BaseMapper;
import com.yuan.springbootwebmapper.system.entity.po.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/6/29 14:24
 **/
@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
