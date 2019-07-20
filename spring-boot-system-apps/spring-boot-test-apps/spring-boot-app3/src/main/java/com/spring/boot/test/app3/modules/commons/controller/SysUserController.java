package com.spring.boot.test.app3.modules.commons.controller;

import com.github.pagehelper.PageInfo;
import com.spring.boot.test.app3.modules.commons.entity.dto.SysUserQueryParams;
import com.spring.boot.test.app3.modules.commons.service.SysUserService;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.springframework.stereotype.Controller;

@Controller
public class SysUserController extends BaseController {
    private SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    public AjaxResult<PageInfo> pageInfoAjaxResult(SysUserQueryParams queryParams) {
        return AjaxResult.ok();
    }

}
