package com.yuan.spring.app1.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.app1.modules.commons.service.BaseService;
import com.yuan.spring.app1.modules.commons.utils.PageVo;
import com.yuan.spring.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.app1.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.app1.modules.system.entity.vo.SysUserVo;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/27 11:06
 **/
public interface SysUserService extends BaseService<SysUser> {
    PageVo<SysUserVo> selectPage(SysUserQueryParams queryParams, Page<SysUser> page);

    List<SysUserVo> selectList(SysUserQueryParams queryParams);

    SysUserVo selectOne(SysUserQueryParams queryParams);
}
