package com.yuan.springbootwebjpa.system.service.impl;

import com.yuan.springbootwebjpa.commons.service.impl.BaseSerivceImpl;
import com.yuan.springbootwebjpa.system.entity.po.SysResource;
import com.yuan.springbootwebjpa.system.repository.SysResourceRepository;
import com.yuan.springbootwebjpa.system.service.SysResourceService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/6/20 22:48
 **/
@Service
public class SysResourceServiceImpl extends BaseSerivceImpl<SysResource, Long, SysResourceRepository> implements SysResourceService {
    private final SysResourceRepository sysResourceRepository;

    public SysResourceServiceImpl(SysResourceRepository sysResourceRepository) {
        this.sysResourceRepository = sysResourceRepository;
    }

    @Override
    protected SysResourceRepository getRepository() {
        return sysResourceRepository;
    }
}
