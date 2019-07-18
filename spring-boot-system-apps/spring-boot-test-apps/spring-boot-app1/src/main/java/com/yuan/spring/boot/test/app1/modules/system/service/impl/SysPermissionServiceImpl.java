package com.yuan.spring.boot.test.app1.modules.system.service.impl;

import com.yuan.spring.boot.test.app1.modules.commons.service.impl.AbstractCommonsService;
import com.yuan.spring.boot.test.app1.modules.system.dao.SysPermissionDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.converter.SysPermissionConverter;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysPermission;
import com.yuan.spring.boot.test.app1.modules.system.service.SysPermissionService;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionServiceImpl extends AbstractCommonsService<SysPermissionDao, SysPermission> implements SysPermissionService {
    private SysPermissionConverter sysPermissionConverter;

    public SysPermissionServiceImpl(SysPermissionConverter sysPermissionConverter) {
        this.sysPermissionConverter = sysPermissionConverter;
    }
}
