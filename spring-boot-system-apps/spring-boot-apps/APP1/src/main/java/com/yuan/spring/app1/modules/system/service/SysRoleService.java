package com.yuan.spring.app1.modules.system.service;

import com.yuan.spring.app1.modules.commons.controller.BaseController;
import com.yuan.spring.app1.modules.commons.service.BaseService;
import com.yuan.spring.app1.modules.commons.utils.PageVo;
import com.yuan.spring.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.app1.modules.system.entity.dto.SysRoleQueryParams;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author yuane
 * @date 2019/7/30 22:35
 **/
public interface SysRoleService extends BaseService<SysRole> {
    PageVo<Map<String, Object>> listData(SysRoleQueryParams queryParams, PageVo page);

    BaseController.AjaxResult upload(MultipartFile file);
}
