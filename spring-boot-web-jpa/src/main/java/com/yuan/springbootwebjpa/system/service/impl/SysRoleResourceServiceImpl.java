package com.yuan.springbootwebjpa.system.service.impl;

import com.yuan.springbootwebjpa.commons.service.impl.BaseSerivceImpl;
import com.yuan.springbootwebjpa.system.entity.po.SysRoleResource;
import com.yuan.springbootwebjpa.system.repository.SysRoleResourceRepository;
import com.yuan.springbootwebjpa.system.service.SysRoleResourceService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/6/20 22:49
 **/
@Service
public class SysRoleResourceServiceImpl extends BaseSerivceImpl<SysRoleResource, Long, SysRoleResourceRepository> implements SysRoleResourceService {
    private final SysRoleResourceRepository sysRoleResourceRepository;

    public SysRoleResourceServiceImpl(SysRoleResourceRepository sysRoleResourceRepository) {
        this.sysRoleResourceRepository = sysRoleResourceRepository;
    }

    @Override
    protected SysRoleResourceRepository getRepository() {
        return sysRoleResourceRepository;
    }
}
