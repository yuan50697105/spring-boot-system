package com.yuan.spring.boot.test.app1.modules.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.CheckMessageUtils;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.test.app1.modules.commons.service.impl.CommonsServiceImpl;
import com.yuan.spring.boot.test.app1.modules.system.dao.SysRoleDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.test.app1.modules.system.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/17 1:02
 **/
@Service
public class SysRoleServiceImpl extends CommonsServiceImpl<SysRoleDao, SysRole> implements SysRoleService {
    @Override
    public ServiceResult checkSave(SysRole sysRole) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoinerr = new StringJoiner("", ",", ".");
        String name = sysRole.getName();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            stringJoinerr.add("名称不能为空");
        } else {
            if (baseDao.existsByName(name)) {
                passFlag = false;
                stringJoinerr.add(name + "已存在");
            }
        }
        return CheckMessageUtils.build(passFlag, stringJoinerr.toString());
    }

    @Override
    public ServiceResult checkUpdate(SysRole sysRole) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoinerr = new StringJoiner("", ",", ".");
        String name = sysRole.getName();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            stringJoinerr.add("名称不能为空");
        }
        return CheckMessageUtils.build(passFlag, stringJoinerr.toString());
    }

    @Override
    public ServiceResult checkDelete(SysRole sysRole) throws CheckNotPassException {
        return ServiceResultUtils.ok();
    }
}
