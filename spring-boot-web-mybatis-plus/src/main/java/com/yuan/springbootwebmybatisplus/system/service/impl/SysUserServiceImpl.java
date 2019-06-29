package com.yuan.springbootwebmybatisplus.system.service.impl;

import com.yuan.springbootwebmybatisplus.commons.service.impl.BaseServiceImpl;
import com.yuan.springbootwebmybatisplus.system.entity.po.SysUser;
import com.yuan.springbootwebmybatisplus.system.mapper.SysUserMapper;
import com.yuan.springbootwebmybatisplus.system.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/29 14:18
 **/
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    protected void beforeSave(SysUser sysUser) throws RuntimeException {
        sysUser.setCreateDate(new Date());

    }

    @Override
    protected void beforeUpdate(SysUser sysUser) throws RuntimeException {
        sysUser.setUpdateDate(new Date());
    }

    @Override
    protected void beforeSaveOrUpdate(SysUser sysUser) throws RuntimeException {
        sysUser.setCreateDate(new Date());
        sysUser.setUpdateDate(new Date());
    }
}
