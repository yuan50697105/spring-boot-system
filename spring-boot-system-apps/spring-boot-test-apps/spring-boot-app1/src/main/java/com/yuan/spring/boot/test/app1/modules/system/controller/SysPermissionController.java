package com.yuan.spring.boot.test.app1.modules.system.controller;

import cn.hutool.core.map.MapUtil;
import com.yuan.spring.boot.dao.commons.entity.vo.PageVo;
import com.yuan.spring.boot.test.app1.modules.commons.controler.AbstractController;
import com.yuan.spring.boot.test.app1.modules.commons.validator.SaveValidator;
import com.yuan.spring.boot.test.app1.modules.commons.validator.UpdateValidator;
import com.yuan.spring.boot.test.app1.modules.system.entity.converter.SysPermissionConverter;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysPermission;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysPermissionQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysPermissionQueryResult;
import com.yuan.spring.boot.test.app1.modules.system.entity.vo.SysPermissionVo;
import com.yuan.spring.boot.test.app1.modules.system.service.SysPermissionService;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RestControllerAdvice
@RequestMapping("system/permission")
@ViewPrefix("system/permission")
public class SysPermissionController extends AbstractController {
    private final SysPermissionService sysPermissionService;
    private final SysPermissionConverter sysPermissionConverter;

    public SysPermissionController(SysPermissionService sysPermissionService, SysPermissionConverter sysPermissionConverter) {
        this.sysPermissionService = sysPermissionService;
        this.sysPermissionConverter = sysPermissionConverter;
    }

    @RequestMapping("index")
    public WebAsyncTask<ModelAndView> index() {
        return new WebAsyncTask<>(() -> displayModelAndView("index"));
    }

    @RequestMapping("dataGrid")
    public WebAsyncTask<AjaxResult> dataGrid(SysPermissionQueryParams queryParams, int page, int size) {
        return new WebAsyncTask<>(() -> {
            Page<SysPermissionQueryResult> results = sysPermissionService.findAll(queryParams, PageRequest.of(page, size));
            PageVo pageVo = PageVo.build(results.getTotalElements(), results.getContent());
            return AjaxResult.data(pageVo);
        });
    }

    @RequestMapping("dataList")
    public WebAsyncTask<AjaxResult> dataList(SysPermissionQueryParams queryParams) {
        return new WebAsyncTask<>(() -> {
            List<SysPermissionQueryResult> results = sysPermissionService.findAll(queryParams);
            return AjaxResult.data(results);
        });
    }

    @RequestMapping("dataOne")
    public WebAsyncTask<AjaxResult> dataOne(SysPermissionQueryParams queryParams) {
        return new WebAsyncTask<>(() -> {
            SysPermissionQueryResult result = sysPermissionService.findOne(queryParams);
            return AjaxResult.data(result);
        });
    }

    @RequestMapping("add")
    public WebAsyncTask<ModelAndView> add() {
        return new WebAsyncTask<>(() -> displayModelAndView("add"));
    }

    @RequestMapping("edit")
    public WebAsyncTask<ModelAndView> edit(Long id) {
        return new WebAsyncTask<>(() -> {
            SysPermission permission = sysPermissionService.get(id);
            return displayModelAndView("edit", MapUtil.of("data", permission));
        });
    }

    @RequestMapping("checkSave")
    public WebAsyncTask<AjaxResult> checkSave(@Validated(SaveValidator.class) SysPermissionVo permissionVo, BindingResult result) {
        return new WebAsyncTask<>(() -> checkFormProcess(permissionVo, result, sysPermissionService.checkSave(sysPermissionConverter.voToDomain(permissionVo)).convert()));
    }

    @RequestMapping("checkUpdate")
    public WebAsyncTask<AjaxResult> checkUpdate(@Validated(UpdateValidator.class) SysPermissionVo permissionVo, BindingResult result) {
        return new WebAsyncTask<>(() -> checkFormProcess(permissionVo, result, sysPermissionService.checkUpdate(sysPermissionConverter.voToDomain(permissionVo)).convert()));
    }

    @RequestMapping("save")
    public WebAsyncTask<AjaxResult> save(@Validated(SaveValidator.class) SysPermissionVo permissionVo, BindingResult result) {
        return new WebAsyncTask<>(() -> checkFormProcess(permissionVo, result, sysPermissionService.save(sysPermissionConverter.voToDomain(permissionVo)).convert()));
    }

    @RequestMapping("update")
    public WebAsyncTask<AjaxResult> update(@Validated(UpdateValidator.class) SysPermissionVo permissionVo, BindingResult result) {
        return new WebAsyncTask<>(() -> checkFormProcess(permissionVo, result, sysPermissionService.update(sysPermissionConverter.voToDomain(permissionVo)).convert()));
    }

    @RequestMapping("delete")
    public WebAsyncTask<AjaxResult> delete(Long[] id) {
        return new WebAsyncTask<>(() -> sysPermissionService.deleteAllById(id).convert());
    }
}
