package com.yuan.spring.boot.test.app1.modules.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.CheckMessageUtils;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.test.app1.modules.commons.service.impl.CommonsServiceImpl;
import com.yuan.spring.boot.test.app1.modules.system.dao.SysPermissionDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysPermission;
import com.yuan.spring.boot.test.app1.modules.system.service.SysPermissionService;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/17 19:13
 **/
@Service
public class SysPermissionServiceImpl extends CommonsServiceImpl<SysPermissionDao, SysPermission> implements SysPermissionService {
    @Override
    public ServiceResult checkSave(SysPermission sysPermission) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner joiner = new StringJoiner(",");
        String name = sysPermission.getName();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
        }
        return CheckMessageUtils.build(passFlag, joiner.toString());
    }

    @Override
    public ServiceResult checkUpdate(SysPermission sysPermission) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner joiner = new StringJoiner(",");
        String name = sysPermission.getName();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            joiner.add("名称不能为空");

        }
        return CheckMessageUtils.build(passFlag, joiner.toString());
    }

    @Override
    public ServiceResult checkDelete(SysPermission sysPermission) throws CheckNotPassException {
        return ServiceResultUtils.ok();
    }
}
