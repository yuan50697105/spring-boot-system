package com.yuan.spring.app1.modules.system.service.impl;

import com.yuan.spring.app1.modules.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.app1.modules.system.dao.SysPermissionDao;
import com.yuan.spring.app1.modules.system.entity.domain.SysPermission;
import com.yuan.spring.app1.modules.system.service.SysPermissionService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/7/30 22:36
 **/
@Service
public class SysPermissionServiceImpl extends BaseServiceImpl<SysPermissionDao, SysPermission> implements SysPermissionService {
}
