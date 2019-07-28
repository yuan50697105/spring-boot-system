package com.yuan.spring.app1.modules.system.controller;

import com.yuan.spring.app1.modules.commons.controller.BaseController;
import com.yuan.spring.app1.modules.commons.utils.PageVo;
import com.yuan.spring.app1.modules.system.entity.converter.SysUserConverter;
import com.yuan.spring.app1.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.app1.modules.system.entity.vo.SysUserVo;
import com.yuan.spring.app1.modules.system.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * @author yuane
 * @date 2019/7/27 11:17
 **/
@Controller
@RequestMapping("system/user")
public class SysUserController extends BaseController {
    private SysUserService sysUserService;
    private SysUserConverter sysUserConverter;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public SysUserController(SysUserService sysUserService, SysUserConverter sysUserConverter) {
        this.sysUserService = sysUserService;
        this.sysUserConverter = sysUserConverter;
    }

    @RequestMapping("list")
    public String list() {
        return "system/user/list";
    }

    @RequestMapping("listData")
    @ResponseBody
    public AjaxResult<PageVo<SysUserVo>> listData(SysUserQueryParams queryParams, int page, int size) {
        return AjaxResult.ok();
    }


    @RequestMapping("beforeSave")
    @ResponseBody
    public AjaxResult beforeSave(SysUserVo sysUserVo, BindingResult result) {
        if (result.hasErrors()) {
            return AjaxResult.error(result.getAllErrors().toString());
        } else {
            return AjaxResult.ok();
        }
    }

    @RequestMapping("beforeUpdate")
    @ResponseBody
    public AjaxResult beforeUpdate(SysUserVo sysUserVo, BindingResult result) {
        if (result.hasErrors()) {
            return AjaxResult.error(result.getAllErrors().toString());
        } else {
            return AjaxResult.ok();
        }
    }

    @RequestMapping("doSave")
    @ResponseBody
    public AjaxResult doSave(@RequestBody @Validated SysUserVo vo, BindingResult result) {
        AjaxResult ajaxResult = beforeSave(vo, result);
        if (ajaxResult.getStatus().equals(AjaxResult.Status.ERROR)) {
            return ajaxResult;
        } else {
            sysUserService.save(sysUserConverter.toDomain(vo));
            return AjaxResult.ok();
        }
    }

    @RequestMapping("doUpdate")
    @ResponseBody
    public AjaxResult doUpdate(@RequestBody @Validated SysUserVo sysUserVo, BindingResult result) {
        AjaxResult ajaxResult = beforeUpdate(sysUserVo, result);
        if (ajaxResult.getStatus().equals(AjaxResult.Status.ERROR)) {
            return ajaxResult;
        } else {
            sysUserService.updateById(sysUserConverter.toDomain(sysUserVo));
            return AjaxResult.ok();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public AjaxResult delete(String[] ids) {
        sysUserService.removeByIds(Arrays.asList(ids));
        return AjaxResult.ok();
    }
}
