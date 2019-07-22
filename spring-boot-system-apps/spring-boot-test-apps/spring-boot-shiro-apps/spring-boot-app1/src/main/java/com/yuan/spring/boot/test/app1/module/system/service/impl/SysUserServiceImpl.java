package com.yuan.spring.boot.test.app1.module.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.test.app1.module.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.test.app1.module.system.dao.SysUserDao;
import com.yuan.spring.boot.test.app1.module.system.entity.domain.SysUser;
import com.yuan.spring.boot.test.app1.module.system.entity.validator.SaveValid;
import com.yuan.spring.boot.test.app1.module.system.entity.validator.UpdateValid;
import com.yuan.spring.boot.test.app1.module.system.service.SysUserService;
import com.yuan.spring.boot.utils.SpellUtils;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/21 23:44
 **/
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {
    @Override
    public ServiceResult checkSave(SysUser sysUser) {
        boolean passFlag = true;
        StringJoiner joiner = new StringJoiner(",");
        String username = sysUser.getUsername();
        if (baseDao.findByUsernameEquals(username).isPresent()) {
            passFlag = false;
            joiner.add(username + "已存在");
        }
        return ServiceResultUtils.check(passFlag, joiner.toString());

    }

    @Override
    public ServiceResult checkUpdate(SysUser sysUser) {
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult checkDelete(SysUser sysUser) {
        return ServiceResultUtils.ok();
    }

    @Override
    protected void baseSave(SysUser sysUser) {
        @NotNull(message = "不能为空", groups = {SaveValid.class, UpdateValid.class}) String name = sysUser.getName();
        if (ObjectUtil.isNotEmpty(name)) {
            sysUser.setNameSpellFull(SpellUtils.getSpell(name));
            sysUser.setNameSpellSimple(SpellUtils.getFirstSpell(name));
        }
        super.baseSave(sysUser);
    }

    @Override
    protected void baseUpdate(SysUser sysUser) {
        @NotNull(message = "不能为空", groups = {SaveValid.class, UpdateValid.class}) String name = sysUser.getName();
        if (ObjectUtil.isNotEmpty(name)) {
            sysUser.setNameSpellFull(SpellUtils.getSpell(name));
            sysUser.setNameSpellSimple(SpellUtils.getFirstSpell(name));
        }
        super.baseUpdate(sysUser);
    }
}
