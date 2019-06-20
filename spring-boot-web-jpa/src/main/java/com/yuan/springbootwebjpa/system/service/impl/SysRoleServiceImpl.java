package com.yuan.springbootwebjpa.system.service.impl;

import com.yuan.springbootwebjpa.commons.service.impl.BaseSerivceImpl;
import com.yuan.springbootwebjpa.system.entity.po.SysRole;
import com.yuan.springbootwebjpa.system.repository.SysRoleRepository;
import com.yuan.springbootwebjpa.system.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/6/20 22:44
 **/
@Service
public class SysRoleServiceImpl extends BaseSerivceImpl<SysRole, Long, SysRoleRepository> implements SysRoleService {
    private final SysRoleRepository sysRoleRepository;

    public SysRoleServiceImpl(SysRoleRepository sysRoleRepository) {
        this.sysRoleRepository = sysRoleRepository;
    }

    @Override
    protected SysRoleRepository getRepository() {
        return sysRoleRepository;
    }
}
