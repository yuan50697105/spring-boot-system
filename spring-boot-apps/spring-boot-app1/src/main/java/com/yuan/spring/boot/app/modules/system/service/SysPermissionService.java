package com.yuan.spring.boot.app.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.app.modules.commons.service.BaseService;
import com.yuan.spring.boot.app.modules.system.entity.domain.SysPermisson;
import com.yuan.spring.boot.app.modules.system.entity.dto.SysPermissionQueryParams;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/14 23:36
 **/
public interface SysPermissionService extends BaseService<SysPermisson> {
    IPage selectPageByParams(Page<SysPermisson> objectPage, SysPermissionQueryParams queryParams);

    List selectListByParams(SysPermissionQueryParams queryParams);

    Object selectOneByParams(SysPermissionQueryParams queryParams);
}
