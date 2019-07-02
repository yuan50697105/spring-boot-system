package com.yuan.springbootwebmybatisplus.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.springbootwebmybatisplus.commons.service.BaseService;
import com.yuan.springbootwebmybatisplus.system.entity.bo.SysUserQueryParams;
import com.yuan.springbootwebmybatisplus.system.entity.po.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @author yuane
 * @date 2019/6/29 14:18
 **/
public interface SysUserService extends BaseService<SysUser> {
    Page findPage(Page<Map<String, Object>> mapPage, SysUserQueryParams queryParams);

    List findList(SysUserQueryParams queryParams);
}
