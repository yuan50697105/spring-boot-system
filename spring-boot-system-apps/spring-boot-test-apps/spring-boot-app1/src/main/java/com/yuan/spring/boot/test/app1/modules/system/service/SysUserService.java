package com.yuan.spring.boot.test.app1.modules.system.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.yuan.spring.boot.test.app1.modules.commons.service.CommonsService;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysUser;

/**
 * @author yuane
 * @date 2019/7/19 21:59
 **/
public interface SysUserService extends CommonsService<SysUser> {
    void enabled(ID[] ids);

    void disabled(ID[] ids);
}
