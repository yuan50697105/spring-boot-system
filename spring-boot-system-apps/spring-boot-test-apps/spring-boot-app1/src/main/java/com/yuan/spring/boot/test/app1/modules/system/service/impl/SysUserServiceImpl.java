package com.yuan.spring.boot.test.app1.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.test.app1.modules.commons.service.impl.AbstractCommonsServiceImpl;
import com.yuan.spring.boot.test.app1.modules.system.dao.SysUserDao;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.test.app1.modules.system.service.SysUserService;
import com.yuan.spring.boot.utils.SpellUtils;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/19 21:59
 **/
@Service
public class SysUserServiceImpl extends AbstractCommonsServiceImpl<SysUserDao, SysUser> implements SysUserService {
    private boolean existByUsername(String username) {
        LambdaQueryChainWrapper<SysUser> chainWrapper = new LambdaQueryChainWrapper<>(baseDao);
        chainWrapper.eq(SysUser::getUsername, username);
        return chainWrapper.count() > 0;
    }

    @Override
    public ServiceResult checkSave(SysUser sysUser) {
        boolean isPass = true;
        StringJoiner joiner = new StringJoiner(",");
        String username = sysUser.getUsername();
        String name = sysUser.getName();
        String password = sysUser.getPassword();
        if (isNotEmpty(username)) {
            isPass = false;
            joiner.add("账户不能为空");
        } else if (isNotBetween(username, 1, 100)) {
            isPass = false;
            joiner.add("账户长度错误");
        } else if (existByUsername(username)) {
            isPass = false;
            joiner.add(username + "已存在");
        }
        if (isNotEmpty(name)) {

        } else if (isNotBetween(name, 1, 100)) {

        }
        if (isNotEmpty(password)) {

        } else if (isNotBetween(password, 1, 100)) {

        }
        return ServiceResultUtils.check(isPass, joiner.toString());
    }

    @Override
    public ServiceResult checkUpdate(SysUser sysUser) {
        return ServiceResultUtils.check(true, "");
    }

    @Override
    public ServiceResult checkDelete(SysUser sysUser) {
        return ServiceResultUtils.check(true, "");
    }

    @Override
    protected void baseSave(SysUser sysUser) {
        String name = sysUser.getName();
        if (isNotEmpty(name)) {
            sysUser.setNameSpellFull(SpellUtils.getSpell(name));
            sysUser.setNameSpellSimple(SpellUtils.getFirstSpell(name));
        }
        super.baseSave(sysUser);
    }

    @Override
    protected void baseUpdate(SysUser sysUser) {
        String name = sysUser.getName();
        if (isNotEmpty(name)) {
            sysUser.setNameSpellFull(SpellUtils.getSpell(name));
            sysUser.setNameSpellSimple(SpellUtils.getFirstSpell(name));
        }
        super.baseUpdate(sysUser);
    }

    @Override
    public void enabled(ID[] ids) {
        LambdaUpdateChainWrapper<SysUser> updateChainWrapper = new LambdaUpdateChainWrapper<>(baseDao);
        updateChainWrapper.set(SysUser::getEnabled, 0);
        updateChainWrapper.in(SysUser::getId, (Object[]) ids);
        updateChainWrapper.update();
    }

    @Override
    public void disabled(ID[] ids) {
        LambdaUpdateChainWrapper<SysUser> updateChainWrapper = new LambdaUpdateChainWrapper<>(baseDao);
        updateChainWrapper.set(SysUser::getEnabled, 1);
        updateChainWrapper.in(SysUser::getId, (Object[]) ids);
    }
}
