package com.yuan.spring.boot.test.app1.module.system.service.impl;

import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.test.app1.module.commons.service.impl.BaseJdbcServiceImpl;
import com.yuan.spring.boot.test.app1.module.system.dao.SysUserJdbcDao;
import com.yuan.spring.boot.test.app1.module.system.entity.domain.SysUserJdbc;
import com.yuan.spring.boot.test.app1.module.system.service.SysUserJdbcService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/7/22 18:45
 **/
@Service
public class SysUserJdbcServiceImpl extends BaseJdbcServiceImpl<SysUserJdbcDao, SysUserJdbc> implements SysUserJdbcService {

    @Override
    public ServiceResult checkSave(SysUserJdbc sysUserJdbc) {
        return null;
    }

    @Override
    public ServiceResult checkUpdate(SysUserJdbc sysUserJdbc) {
        return null;
    }

    @Override
    public ServiceResult checkDelete(SysUserJdbc sysUserJdbc) {
        return null;
    }
}
