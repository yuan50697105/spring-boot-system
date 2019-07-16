package com.yuan.spring.boot.test.app1.modules.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.CheckMessageUtils;
import com.yuan.spring.boot.test.app1.modules.commons.service.impl.CommonsServiceImpl;
import com.yuan.spring.boot.test.app1.modules.system.dao.SysUserDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.test.app1.modules.system.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/17 0:52
 **/
@Service
public class SysUserServiceImpl extends CommonsServiceImpl<SysUserDao, SysUser> implements SysUserService {
    @Override
    public ServiceResult checkSave(SysUser sysUser) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoiner = new StringJoiner("", ",", ".");
//        username验证
        String username = sysUser.getUsername();
        if (ObjectUtil.isEmpty(username)) {
//验证为空
            passFlag = false;
            stringJoiner.add("账户不能为空");
        } else {
//            不为空
            if (baseDao.existsByUsername(username)) {
                passFlag = false;
                stringJoiner.add(username + "已存在");
            }
        }
        return CheckMessageUtils.build(passFlag, stringJoiner.toString());
    }

    @Override
    public ServiceResult checkUpdate(SysUser sysUser) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoiner = new StringJoiner("", ",", ".");
//        username验证
        String username = sysUser.getUsername();
        if (ObjectUtil.isEmpty(username)) {
//验证为空
            passFlag = false;
            stringJoiner.add("账户不能为空");
        }
        return CheckMessageUtils.build(passFlag, stringJoiner.toString());
    }

    @Override
    public ServiceResult checkDelete(SysUser sysUser) throws CheckNotPassException {
        return CheckMessageUtils.build(true, "");
    }
}
