package com.yuan.spring.boot.test.app1.modules.system.controller;

import com.yuan.spring.boot.dao.commons.entity.vo.PageVo;
import com.yuan.spring.boot.test.app1.modules.commons.controler.CommonsController;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.service.SysUserService;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author yuane
 * @date 2019/7/17 1:05
 **/
@RestController
@RequestMapping("sys/user")
@ViewPrefix("sys/user")
public class SysUserController extends CommonsController {
    private SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @RequestMapping
    public WebAsyncTask<ModelAndView> index() {
        return new WebAsyncTask<>(() -> displayModelAndView("index"));
    }

    @RequestMapping("dataGrid")
    public WebAsyncTask<AjaxResult> dataGrid(SysUserQueryParams queryParams, int page, int size) {
        return new WebAsyncTask<>(() -> {
            Page<SysUser> sysUsers = sysUserService.findAll(PageRequest.of(page, size, Sort.by(Sort.Order.desc("id"))));
            PageVo pageVo = PageVo.build(sysUsers.getTotalElements(), sysUsers.getContent());
            return AjaxResult.data(pageVo);
        });
    }

    @RequestMapping("dataList")
    public WebAsyncTask<AjaxResult> dataList(SysUserQueryParams queryParams) {
        return new WebAsyncTask<>(() -> {
            List<SysUser> sysUsers = sysUserService.findAll(Sort.by(Sort.Order.desc("id")));
            return AjaxResult.data(sysUsers);
        });
    }

    @RequestMapping("dataOne")
    public WebAsyncTask<AjaxResult> dataOne(SysUserQueryParams queryParams) {
        return new WebAsyncTask<>(() -> {
            return AjaxResult.data("");
        });
    }

    @SuppressWarnings("ConstantConditions")
    @RequestMapping("checkSave")
    public WebAsyncTask<AjaxResult> checkSave(@RequestBody @Validated SysUser sysUser, BindingResult result) {
        return new WebAsyncTask<>(() -> {
            if (result.hasErrors()) {
                return AjaxResult.error(result.getFieldError().getDefaultMessage());
            } else {
                return sysUserService.checkSave(sysUser).convert();
            }
        });
    }

    @SuppressWarnings("ConstantConditions")
    @RequestMapping("checkUpdate")
    public WebAsyncTask<AjaxResult> checkUpdate(@RequestBody @Validated SysUser sysUser, BindingResult result) {
        return new WebAsyncTask<>(() -> {
            if (result.hasErrors()) {
                return AjaxResult.error(result.getGlobalError().getDefaultMessage());
            } else {
                return AjaxResult.ok();
            }
        });
    }

    public WebAsyncTask<AjaxResult> doSave(SysUser sysUser, BindingResult result) {
        return new WebAsyncTask<>(() -> {
            return AjaxResult.ok();
        });
    }
}
