package com.yuan.spring.boot.app1.modules.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuan.spring.boot.app1.modules.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.app1.modules.system.SysUser;
import com.yuan.spring.boot.app1.modules.system.SysUserDao;
import com.yuan.spring.boot.app1.modules.system.SysUserService;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/16 21:07
 **/
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {
    @Override
    public ServiceResult checkSave(SysUser sysUser) throws CheckNotPassException {
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult checkUpdate(SysUser sysUser) throws CheckNotPassException {
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult checkDelete(SysUser sysUser) throws CheckNotPassException {
        return ServiceResultUtils.ok();
    }

    @Override
    public List<SysUser> findAll() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().orderByDesc("id");
        return baseDao.selectList(queryWrapper);
    }
}
