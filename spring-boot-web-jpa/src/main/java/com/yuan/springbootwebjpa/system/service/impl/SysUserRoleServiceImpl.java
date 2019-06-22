package com.yuan.springbootwebjpa.system.service.impl;

import com.yuan.springbootwebjpa.commons.service.impl.BaseServiceImpl;
import com.yuan.springbootwebjpa.system.entity.po.SysUserRole;
import com.yuan.springbootwebjpa.system.repository.SysUserRoleRepository;
import com.yuan.springbootwebjpa.system.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/6/20 22:46
 **/
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole, Long, SysUserRoleRepository> implements SysUserRoleService {
    private final SysUserRoleRepository sysUserRoleRepository;

    public SysUserRoleServiceImpl(SysUserRoleRepository sysUserRoleRepository) {
        this.sysUserRoleRepository = sysUserRoleRepository;
    }

    @Override
    protected SysUserRoleRepository getRepository() {
        return sysUserRoleRepository;
    }
}
