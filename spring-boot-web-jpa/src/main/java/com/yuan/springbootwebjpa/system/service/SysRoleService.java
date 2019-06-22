package com.yuan.springbootwebjpa.system.service;

import com.yuan.springbootwebjpa.commons.service.BaseSerivce;
import com.yuan.springbootwebjpa.system.entity.bo.SysRoleQueryParam;
import com.yuan.springbootwebjpa.system.entity.po.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/20 22:44
 **/
public interface SysRoleService extends BaseSerivce<SysRole, String> {
    Page findPageByBo(SysRoleQueryParam sysRoleBo, Pageable pageable);

    List findListByBo(SysRoleQueryParam sysRoleBo);

    Optional findOneByBo(SysRoleQueryParam sysRoleBo);
}
