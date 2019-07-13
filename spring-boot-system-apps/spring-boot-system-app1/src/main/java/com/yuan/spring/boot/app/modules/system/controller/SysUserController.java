package com.yuan.spring.boot.app.modules.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.app.modules.commons.controller.BaseController;
import com.yuan.spring.boot.app.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.app.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.app.modules.system.service.SysUserService;
import com.yuan.spring.boot.dao.mybatis.plus.commons.entity.vo.PageVo;
import com.yuan.spring.boot.dao.mybatis.plus.commons.exception.CheckNotPassException;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author yuane
 * @date 2019/7/13 8:39
 **/
@Controller
@RequestMapping("system/user")
@ViewPrefix("system/user")
public class SysUserController extends BaseController {
    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @RequestMapping("dataGrid")
    @ResponseBody
    public AjaxResult dataGrid(SysUserQueryParams queryParams, int page, int size) {
        return AjaxResult.data(PageVo.build(sysUserService.selectPageByParams(new Page<>(page, size), queryParams)));
    }

    @RequestMapping("dataList")
    @ResponseBody
    public AjaxResult dataList(SysUserQueryParams queryParams) {
        return AjaxResult.data(sysUserService.selectListByParams(queryParams));
    }

    @RequestMapping("dataOne")
    @ResponseBody
    public AjaxResult dataOne(SysUserQueryParams queryParams) {
        return AjaxResult.data(sysUserService.selectOneByParams(queryParams));
    }

    @RequestMapping("checkSaveOrUpdate")
    @ResponseBody
    public AjaxResult checkSaveOrUpdate(@RequestBody @Valid SysUser sysUser, BindingResult result) {
        if (result.hasGlobalErrors()) {
            try {
                return AjaxResult.error(Objects.requireNonNull(result.getGlobalError()).getDefaultMessage());
            } catch (NullPointerException e) {
                try {
                    sysUserService.checkSaveOrUpdate(sysUser);
                    return AjaxResult.ok();
                } catch (CheckNotPassException ex) {
                    return AjaxResult.error(ex.getMessage());
                }
            }

        } else {
            try {
                sysUserService.checkSaveOrUpdate(sysUser);
                return AjaxResult.ok();
            } catch (CheckNotPassException ex) {
                return AjaxResult.error(ex.getMessage());
            }
        }
    }

    @RequestMapping("doSaveOrUpdate")
    @ResponseBody
    public AjaxResult doSaveOrUpdate(@RequestBody @Valid SysUser sysUser, BindingResult result) {
        AjaxResult ajaxResult = checkSaveOrUpdate(sysUser, result);
        if (ajaxResult.getCode().equals(AjaxResult.Status.ERROR.getCode())) {
            return ajaxResult;
        } else {
            sysUserService.saveOrUpdate(sysUser);
            return AjaxResult.ok();
        }
    }

    @RequestMapping("doDelete")
    @ResponseBody
    public AjaxResult doDelete(String[] ids) {
        sysUserService.removeByIds(Arrays.asList(ids));
        return AjaxResult.ok();
    }

    @ResponseBody
    @RequestMapping("get")
    public AjaxResult get(String id) {
        return AjaxResult.data(sysUserService.getById(id));
    }
}
