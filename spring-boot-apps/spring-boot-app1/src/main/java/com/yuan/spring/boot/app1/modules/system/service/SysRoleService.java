package com.yuan.spring.boot.app1.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.app1.modules.commons.service.BaseService;
import com.yuan.spring.boot.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.app1.modules.system.entity.dto.SysRoleQueryParams;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/14 20:48
 **/
public interface SysRoleService extends BaseService<SysRole> {
    IPage selectPageByParams(SysRoleQueryParams queryParams, Page<SysRole> objectPage);

    List selectListByParams(SysRoleQueryParams queryParams);

    Object selectOne(SysRoleQueryParams queryParams);
}