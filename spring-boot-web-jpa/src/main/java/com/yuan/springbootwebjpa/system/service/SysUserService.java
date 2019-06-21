package com.yuan.springbootwebjpa.system.service;

import com.yuan.springbootwebjpa.commons.service.BaseSerivce;
import com.yuan.springbootwebjpa.system.entity.bo.SysUserQueryParam;
import com.yuan.springbootwebjpa.system.entity.po.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/20 22:32
 **/
public interface SysUserService extends BaseSerivce<SysUser, Long> {
    Page findPageByBo(SysUserQueryParam sysUserBo, Pageable pageable);

    List findListByBo(SysUserQueryParam sysUserBo);

    Optional findOneByBo(SysUserQueryParam sysUserBo);
}
