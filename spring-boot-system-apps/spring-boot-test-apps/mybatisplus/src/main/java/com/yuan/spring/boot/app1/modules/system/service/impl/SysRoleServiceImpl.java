package com.yuan.spring.boot.app1.modules.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.yuan.spring.boot.app1.modules.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.app1.modules.system.dao.SysRoleDao;
import com.yuan.spring.boot.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.app1.modules.system.entity.dto.SysRoleQueryParams;
import com.yuan.spring.boot.app1.modules.system.service.SysRoleService;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.CheckMessageUtils;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/14 20:48
 **/
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

    @Override
    public ServiceResult checkSave(SysRole sysRole) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner message = new StringJoiner(",");
        String name = sysRole.getName();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            message.add("角色名称不能为空");
        } else {
            Integer integer = baseDao.selectCount(new QueryWrapper<>(SysRole.builder().name(name).build()));
            if (integer > 0) {
                passFlag = false;
                message.add(name + "已存在");
            }
        }
        return CheckMessageUtils.build(passFlag, message.toString());
    }

    @Override
    public ServiceResult checkUpdate(SysRole sysRole) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner message = new StringJoiner(",");
        String name = sysRole.getName();
        if (ObjectUtil.isEmpty(name)) {
            passFlag = false;
            message.add("角色名称不能为空");
        }
        return CheckMessageUtils.build(passFlag, message.toString());
    }

    @Override
    public ServiceResult checkDelete(SysRole sysRole) throws CheckNotPassException {
        return ServiceResultUtils.ok();
    }

    @Override
    public IPage selectPageByParams(SysRoleQueryParams queryParams, Page<SysRole> objectPage) {
        QueryChainWrapper<SysRole> sysRoleQueryChainWrapper = getSysRoleQueryChainWrapper(queryParams);
        return sysRoleQueryChainWrapper.page(objectPage);
    }

    @Override
    public List selectListByParams(SysRoleQueryParams queryParams) {
        return getSysRoleQueryChainWrapper(queryParams).list();
    }

    @Override
    public Object selectOne(SysRoleQueryParams queryParams) {
        return getSysRoleQueryChainWrapper(queryParams).one();
    }

    private QueryChainWrapper<SysRole> getSysRoleQueryChainWrapper(SysRoleQueryParams queryParams) {
        String id = queryParams.getId();
        String[] ids = queryParams.getIds();
        String name = queryParams.getName();
        QueryChainWrapper<SysRole> sysRoleQueryChainWrapper = new QueryChainWrapper<>(baseDao);
        sysRoleQueryChainWrapper.eq(isNotEmpty(id), "id", id);
        sysRoleQueryChainWrapper.in(isNotEmpty(ids), "id", (Object[]) ids);
        sysRoleQueryChainWrapper.like(isNotEmpty(name), "name", name);
        return sysRoleQueryChainWrapper;
    }
}
