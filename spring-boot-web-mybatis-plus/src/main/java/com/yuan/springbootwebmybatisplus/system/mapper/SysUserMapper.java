package com.yuan.springbootwebmybatisplus.system.mapper;

import com.yuan.springbootwebmybatisplus.commons.mapper.BaseMapper;
import com.yuan.springbootwebmybatisplus.system.entity.po.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuane
 * @date 2019/6/29 14:18
 **/
@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    int countByUsername(String username);
}
