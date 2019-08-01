package com.yuan.spring.app1.modules.system.service.impl;

import com.yuan.spring.app1.modules.commons.service.impl.BaseServiceImpl;
import com.yuan.spring.app1.modules.system.dao.SysResourceDao;
import com.yuan.spring.app1.modules.system.entity.domain.SysResource;
import com.yuan.spring.app1.modules.system.service.SysResourceService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/8/1 19:12
 **/
@Service
public class SysResourceServiceImpl extends BaseServiceImpl<SysResourceDao, SysResource> implements SysResourceService {
}
