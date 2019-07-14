package com.yuan.spring.boot.mapper.modules.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.dao.mybatis.plus.utils.PageUtils;
import com.yuan.spring.boot.mapper.modules.commons.controller.BaseController;
import com.yuan.spring.boot.mapper.modules.system.entity.converter.SysRoleConverter;
import com.yuan.spring.boot.mapper.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.mapper.modules.system.entity.dto.SysRoleQueryParams;
import com.yuan.spring.boot.mapper.modules.system.entity.vo.SysRoleVo;
import com.yuan.spring.boot.mapper.modules.system.service.SysRoleService;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yuane
 * @date 2019/7/14 20:54
 **/
@Controller
@RequestMapping("system/role")
@ViewPrefix("system/role")
public class SysRoleController extends BaseController {
    private SysRoleService sysRoleService;
    private SysRoleConverter sysRoleConverter;

    public SysRoleController(SysRoleService sysRoleService, SysRoleConverter sysRoleConverter) {
        this.sysRoleService = sysRoleService;
        this.sysRoleConverter = sysRoleConverter;
    }

    @RequestMapping
    public String index() {
        return display("index");
    }

    @RequestMapping("dataGrid")
    @ResponseBody
    public AjaxResult dataGrid(SysRoleQueryParams queryParams, int page, int size) {
        return AjaxResult.data(PageUtils.build(sysRoleService.selectPageByParams(queryParams, new Page<>(page, size))));
    }

    @RequestMapping("dataList")
    @ResponseBody
    public AjaxResult dataList(SysRoleQueryParams queryParams) {
        return AjaxResult.data(sysRoleService.selectListByParams(queryParams));
    }

    @RequestMapping("dataOne")
    @ResponseBody
    public AjaxResult dataOne(SysRoleQueryParams queryParams) {
        return AjaxResult.data(sysRoleService.selectOne(queryParams));
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxResult save(SysRoleVo sysRoleVo) {
        SysRole sysRole = sysRoleConverter.voToDomain(sysRoleVo);
        return sysRoleService.save(sysRole).convert();
    }

    @RequestMapping("update")
    @ResponseBody
    public AjaxResult update(SysRoleVo sysRoleVo) {
        SysRole sysRole = sysRoleConverter.voToDomain(sysRoleVo);
        return sysRoleService.update(sysRole).convert();
    }


}
