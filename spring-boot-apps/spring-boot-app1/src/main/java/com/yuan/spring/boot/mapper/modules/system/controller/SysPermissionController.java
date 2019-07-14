package com.yuan.spring.boot.mapper.modules.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.dao.mybatis.plus.utils.PageUtils;
import com.yuan.spring.boot.mapper.modules.commons.controller.BaseController;
import com.yuan.spring.boot.mapper.modules.system.entity.converter.SysPermissionConvertor;
import com.yuan.spring.boot.mapper.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.mapper.modules.system.service.SysPermissionService;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuane
 * @date 2019/7/14 23:46
 **/
@Controller
@RequestMapping("system/permission")
@ViewPrefix("system/permission")
public class SysPermissionController extends BaseController {
    private SysPermissionService sysPermissionService;
    private SysPermissionConvertor sysPermissionConvertor;

    public SysPermissionController(SysPermissionService sysPermissionService, SysPermissionConvertor sysPermissionConvertor) {
        this.sysPermissionService = sysPermissionService;
        this.sysPermissionConvertor = sysPermissionConvertor;
    }

    @RequestMapping
    public String index() {
        return display("index");
    }

    public AjaxResult dataGrid(SysUserQueryParams queryParams, int page, int size) {
        return AjaxResult.data(PageUtils.build(sysPermissionService.selectPageByParams(new Page<>(page, size), queryParams)));
    }
}
