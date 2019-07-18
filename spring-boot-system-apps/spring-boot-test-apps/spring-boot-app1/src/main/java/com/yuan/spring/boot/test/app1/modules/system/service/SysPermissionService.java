package com.yuan.spring.boot.test.app1.modules.system.service;

import com.yuan.spring.boot.test.app1.modules.commons.service.CommonsService;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysPermission;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysPermissionQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysPermissionQueryResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/17 19:12
 **/
public interface SysPermissionService extends CommonsService<SysPermission> {
    Page<SysPermissionQueryResult> findAll(SysPermissionQueryParams queryParams, Pageable pageable);

    List<SysPermissionQueryResult> findAll(SysPermissionQueryParams queryParams);

    SysPermissionQueryResult findOne(SysPermissionQueryParams queryParams);
}
