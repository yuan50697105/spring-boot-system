package com.yuan.spring.app1.modules.system.controller;

import com.yuan.spring.app1.modules.commons.controller.BaseController;
import com.yuan.spring.app1.modules.commons.utils.PageVo;
import com.yuan.spring.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.app1.modules.system.entity.dto.SysRoleQueryParams;
import com.yuan.spring.app1.modules.system.entity.vo.SysRoleVo;
import com.yuan.spring.app1.modules.system.service.SysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Map;

/**
 * @author yuane
 * @date 2019/7/30 22:37
 **/
@Controller
@RequestMapping("system/role")
public class SysRoleController extends BaseController {
    private final SysRoleService sysRoleService;

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @RequestMapping("list")
    public String list() {
        return "system/role/list";
    }

    @RequestMapping("listData")
    @ResponseBody
    public AjaxResult<PageVo<Map<String, Object>>> listData(SysRoleQueryParams queryParams, PageVo pageVo) {
        return AjaxResult.ok(null, sysRoleService.listData(queryParams, pageVo));
    }

    @RequestMapping("add")
    public String add() {
        return "system/role/add";
    }

    @RequestMapping("edit")
    public String edit(Model model, String id) {
        SysRole sysRole = sysRoleService.getById(id);
        model.addAttribute("data", sysRole);
        return "system/role/edit";
    }

    @RequestMapping("beforeSave")
    @ResponseBody
    public AjaxResult beforeSave(@Validated SysRoleVo sysRoleVo, BindingResult result) {
        if (result.hasErrors()) {
            return AjaxResult.error(result.getAllErrors().toString());
        } else {
            return AjaxResult.ok();
        }
    }

    @RequestMapping("beforeUpdate")
    @ResponseBody
    public AjaxResult beforeUpdate(@Validated SysRoleVo sysRole, BindingResult result) {
        if (result.hasErrors()) {
            return AjaxResult.error(result.getAllErrors().toString());
        } else {
            return AjaxResult.ok();
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxResult save(@RequestBody @Validated SysRoleVo sysRoleVo, BindingResult result) {
        AjaxResult ajaxResult = beforeSave(sysRoleVo, result);
        if (ajaxResult.getStatus().equals(AjaxResult.Status.ERROR)) {
            return ajaxResult;
        } else {
            sysRoleService.save(sysRoleVo);
            return AjaxResult.ok();
        }
    }

    @RequestMapping("update")
    @ResponseBody
    public AjaxResult update(@RequestBody @Validated SysRoleVo sysRoleVo, BindingResult result) {
        AjaxResult ajaxResult = beforeUpdate(sysRoleVo, result);
        if (ajaxResult.getStatus().equals(AjaxResult.Status.ERROR)) {
            return ajaxResult;
        } else {
            sysRoleService.updateById(sysRoleVo);
            return AjaxResult.ok();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public AjaxResult delete(String[] id) {
        sysRoleService.removeByIds(Arrays.asList(id));
        return AjaxResult.ok();
    }

    @RequestMapping("upload")
    @ResponseBody
    public AjaxResult upload(MultipartFile file) {
        AjaxResult ajaxResult = sysRoleService.upload(file);
        return AjaxResult.ok();
    }
}
