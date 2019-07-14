package com.yuan.spring.boot.mapper.modules.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.exception.CheckNotPassException;
import com.yuan.spring.boot.dao.commons.utils.CheckMessageUtils;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.mapper.modules.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.boot.mapper.modules.commons.validator.SaveValidator;
import com.yuan.spring.boot.mapper.modules.system.dao.SysUserDao;
import com.yuan.spring.boot.mapper.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.mapper.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.mapper.modules.system.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * @author yuane
 * @date 2019/7/13 8:40
 **/
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Override
    public IPage<SysUser> selectPageByParams(Page<SysUser> objectPage, SysUserQueryParams queryParams) {
        return baseDao.selectPageByParams(objectPage, queryParams);
    }

    @Override
    public List<SysUser> selectListByParams(SysUserQueryParams queryParams) {
        return null;
    }

    @Override
    public Optional<SysUser> selectOneByParams(SysUserQueryParams queryParams) {
        return Optional.empty();
    }

    @Override
    protected SysUser setCommonsParameters(SysUser entity) {
        return null;
    }

    @Override
    public ServiceResult checkSaveOrUpdate(SysUser sysUser) throws CheckNotPassException {
        if (isNew(sysUser)) {
            return checkSave(sysUser);
        } else {
            return checkUpdate(sysUser);
        }
    }

    @Override
    public ServiceResult checkSave(SysUser sysUser) throws CheckNotPassException {
        boolean passFlag = true;
        StringJoiner message = new StringJoiner(",");
        @NotNull(groups = SaveValidator.class, message = "账户不能为空") String username = sysUser.getUsername();
        @NotNull(groups = SaveValidator.class, message = "密码不能为空") String password = sysUser.getPassword();
        @NotNull(groups = SaveValidator.class, message = "名称不能为空") String name = sysUser.getName();
        if (ObjectUtil.isEmpty(username)) {
            passFlag = false;
            message.add("用户名不能为空");
        } else {
            Integer integer = baseDao.selectCount(new QueryWrapper<>(SysUser.builder().username(username).build()));
            if (integer > 0) {
                passFlag = false;
                message.add(username + "已存在");
            }
        }
        return CheckMessageUtils.build(passFlag, message.toString());
    }

    @Override
    public ServiceResult checkUpdate(SysUser sysUser) throws CheckNotPassException {
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult checkDelete(SysUser sysUser) throws CheckNotPassException {
        return ServiceResultUtils.ok();
    }


}
