package com.spring.boot.test.app3.modules.commons.service.impl;

import com.spring.boot.test.app3.modules.commons.dao.SysUserDao;
import com.spring.boot.test.app3.modules.commons.entity.domain.SysUser;
import com.spring.boot.test.app3.modules.commons.service.SysUserService;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {
    public ServiceResult checkSave(SysUser sysUser) {
        return null;
    }

    public ServiceResult checkUpdate(SysUser sysUser) {
        return null;
    }

    public ServiceResult checkDelete(SysUser sysUser) {
        return null;
    }
}
