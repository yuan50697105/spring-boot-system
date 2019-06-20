package com.yuan.springbootwebjpa.system.service.impl;

import com.yuan.springbootwebjpa.commons.service.impl.BaseSerivceImpl;
import com.yuan.springbootwebjpa.system.entity.po.SysUser;
import com.yuan.springbootwebjpa.system.repository.SysUserRepository;
import com.yuan.springbootwebjpa.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/6/20 22:32
 **/
@Service
public class SysUserServiceImpl extends BaseSerivceImpl<SysUser, Long, SysUserRepository> implements SysUserService {
    private final SysUserRepository sysUserRepository;

    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    protected SysUserRepository getRepository() {
        return sysUserRepository;
    }
}
