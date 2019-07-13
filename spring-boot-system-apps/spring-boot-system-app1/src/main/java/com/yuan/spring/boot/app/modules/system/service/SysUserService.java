package com.yuan.spring.boot.app.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.app.modules.commons.service.MybatisPlusService;
import com.yuan.spring.boot.app.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.app.modules.system.entity.dto.SysUserQueryParams;

import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/7/13 8:40
 **/
public interface SysUserService extends MybatisPlusService<SysUser> {
    Page<SysUser> selectPageByParams(Page<SysUser> objectPage, SysUserQueryParams queryParams);

    List<SysUser> selectListByParams(SysUserQueryParams queryParams);

    Optional<SysUser> selectOneByParams(SysUserQueryParams queryParams);
}
