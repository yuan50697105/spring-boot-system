package com.yuan.springbootwebmybatisplus.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuan.springbootwebmybatisplus.commons.service.impl.BaseServiceImpl;
import com.yuan.springbootwebmybatisplus.system.entity.po.SysUser;
import com.yuan.springbootwebmybatisplus.system.mapper.SysUserMapper;
import com.yuan.springbootwebmybatisplus.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/6/29 14:18
 **/
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    protected void beforeSave(SysUser sysUser) throws RuntimeException {
        int i = getBaseMapper().selectCount(new QueryWrapper<>(SysUser.builder().username(sysUser.getUsername()).build()));
        if (i > 0) {
            throw new RuntimeException(sysUser.getUsername() + "已存在");
        }
    }

    @Override
    protected void beforeUpdate(SysUser sysUser) throws RuntimeException {
        SysUser user = getById(sysUser.getId());
        if (user == null) {
            throw new RuntimeException("此用户已经删除");
        }
    }

    @Override
    protected void beforeSaveOrUpdate(SysUser sysUser) throws RuntimeException {
    }
}
