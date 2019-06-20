package com.yuan.springbootwebmybatisplus.system.service.impl;

import com.yuan.springbootwebmybatisplus.commons.service.impl.BaseServiceImpl;
import com.yuan.springbootwebmybatisplus.system.entity.po.SysUser;
import com.yuan.springbootwebmybatisplus.system.mapper.SysUserMapper;
import com.yuan.springbootwebmybatisplus.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/6/20 23:05
 **/
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
