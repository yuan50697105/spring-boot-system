package com.yuan.springbootwebmapper.system.service.impl;

import com.yuan.springbootwebmapper.commons.service.impl.BaseServiceImpl;
import com.yuan.springbootwebmapper.system.entity.po.SysUser;
import com.yuan.springbootwebmapper.system.mapper.SysUserMapper;
import com.yuan.springbootwebmapper.system.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/29 14:25
 **/
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, SysUserMapper> implements SysUserService {
    private final SysUserMapper sysUserMapper;

    public SysUserServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    protected SysUserMapper getMapper() {
        return sysUserMapper;
    }

    @Override
    protected void beforeInsert(SysUser sysUser) throws RuntimeException {
        sysUser.setCreateDate(new Date());
    }

    @Override
    protected void beforeInsertSelective(SysUser sysUser) throws RuntimeException {
        sysUser.setCreateDate(new Date());
    }

    @Override
    protected void beforeUpdate(SysUser sysUser) throws RuntimeException {
        sysUser.setUpdateDate(new Date());
    }

    @Override
    protected void beforeUpdateSelective(SysUser sysUser) throws RuntimeException {
        sysUser.setUpdateDate(new Date());
    }
}
