package com.yuan.spring.boot.app.modules.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.app.modules.commons.service.impl.MybatisPlusServiceImpl;
import com.yuan.spring.boot.app.modules.system.dao.SysUserDao;
import com.yuan.spring.boot.app.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.app.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.app.modules.system.service.SysUserService;
import com.yuan.spring.boot.dao.mybatis.plus.exception.CheckNotPassException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/13 8:40
 **/
@Service
public class SysUserServiceImpl extends MybatisPlusServiceImpl<SysUserDao, SysUser> implements SysUserService {
    @Override
    public void checkSave(SysUser sysUser) throws CheckNotPassException {
        checkSysUser(sysUser);
    }

    @Override
    public void checkUpdate(SysUser sysUser) throws CheckNotPassException {
        checkSysUser(sysUser);
    }

//    @Override
//    public void checkSaveOrUpdate(SysUser sysUser) throws CheckNotPassException {
//        if (isNew(sysUser)) {
//            checkSave(sysUser);
//        } else {
//            checkUpdate(sysUser);
//        }
//    }

    private void checkSysUser(SysUser sysUser) {
        boolean isProcess = true;
        StringJoiner stringJoiner = new StringJoiner(",");
        String username = sysUser.getUsername();
        String name = sysUser.getName();
        String password = sysUser.getPassword();
        if (ObjectUtil.isEmpty(username)) {
            isProcess = false;
            stringJoiner.add("用户名不能空");
        } else {
            Integer selectCount = getBaseMapper().selectCount(new QueryWrapper<>(SysUser.builder().username(username).build()));
            if (selectCount > 0) {
                isProcess = false;
                stringJoiner.add(username + "已存在");
            }
        }
        if (ObjectUtil.isEmpty(name)) {
            isProcess = false;
            stringJoiner.add("姓名不能为空");
        }
        if (ObjectUtil.isEmpty(password)) {
            isProcess = false;
            stringJoiner.add("密码不能为空");
        }
        if (!isProcess) {
            throw new CheckNotPassException(stringJoiner.toString() + "。");
        }
    }

    @Override
    protected SysUser setCommonsParameters(SysUser entity) {
        entity.setUpdateUser("");
        entity.setCreateUser("");
        return super.setCommonsParameters(entity);
    }

    @Override
    public Page<SysUser> selectPageByParams(Page<SysUser> objectPage, SysUserQueryParams queryParams) {
        return getBaseMapper().selectPageByParams(objectPage, queryParams);
    }

    @Override
    public List<SysUser> selectListByParams(SysUserQueryParams queryParams) {
        return getBaseMapper().selectListByParams(queryParams);
    }

    @Override
    public Optional<SysUser> selectOneByParams(SysUserQueryParams queryParams) {
        return getBaseMapper().selectOneByParams(queryParams);
    }
}
