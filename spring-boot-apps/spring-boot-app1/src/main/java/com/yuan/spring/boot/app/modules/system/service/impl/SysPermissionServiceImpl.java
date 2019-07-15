package com.yuan.spring.boot.app.modules.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.yuan.spring.boot.app.modules.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.app.modules.system.dao.SysPermissionDao;
import com.yuan.spring.boot.app.modules.system.entity.domain.SysPermisson;
import com.yuan.spring.boot.app.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.app.modules.system.service.SysPermissionService;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.CheckMessageUtils;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/14 23:37
 **/
@Service
public class SysPermissionServiceImpl extends BaseServiceImpl<SysPermissionDao, SysPermisson> implements SysPermissionService {
    @Override
    public ServiceResult checkSaveOrUpdate(SysPermisson sysPermisson) throws CheckNotPassException {
        if (isNew(sysPermisson)) {
            return checkSave(sysPermisson);
        } else {
            return checkUpdate(sysPermisson);
        }
    }

    @Override
    public ServiceResult checkSave(SysPermisson sysPermisson) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoiner = new StringJoiner("", "，", "。");
        String name = sysPermisson.getName();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            stringJoiner.add("权限名称不能为空");
        } else {
            Integer integer = baseDao.selectCount(new QueryWrapper<>(SysPermisson.builder().name(name).build()));
            if (integer > 0) {
                passFlag = false;
                stringJoiner.add(name + "已存在");
            }
        }
        return CheckMessageUtils.build(passFlag, stringJoiner.toString());
    }

    @Override
    public ServiceResult checkUpdate(SysPermisson sysPermisson) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner stringJoiner = new StringJoiner(",");
        String name = sysPermisson.getName();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            stringJoiner.add("权限名称不能为空");
        }
        return CheckMessageUtils.build(passFlag, stringJoiner.toString());
    }

    @Override
    public ServiceResult checkDelete(SysPermisson sysPermisson) throws CheckNotPassException {
        return ServiceResultUtils.ok();
    }

    @Override
    public IPage selectPageByParams(Page<SysPermisson> objectPage, SysUserQueryParams queryParams) {
        String id = queryParams.getId();
        String[] ids = queryParams.getIds();
        String name = queryParams.getName();
        Integer enabled = queryParams.getEnabled();
        QueryChainWrapper<SysPermisson> queryChainWrapper = new QueryChainWrapper<>(baseDao);
        queryChainWrapper.eq(isNotEmpty(id), "id", id);
        queryChainWrapper.in(isNotEmpty(ids), "id", (Object[]) ids);
        queryChainWrapper.like(isNotEmpty(name), "name", name);
        queryChainWrapper.eq(isNotEmpty(enabled), "enabled", enabled);
        return queryChainWrapper.page(objectPage);
    }
}
