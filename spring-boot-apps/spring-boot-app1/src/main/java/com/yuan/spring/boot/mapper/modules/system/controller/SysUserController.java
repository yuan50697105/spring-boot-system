package com.yuan.spring.boot.mapper.modules.system.controller;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.dao.mybatis.plus.utils.PageUtils;
import com.yuan.spring.boot.mapper.modules.commons.controller.BaseController;
import com.yuan.spring.boot.mapper.modules.commons.validator.SaveValidator;
import com.yuan.spring.boot.mapper.modules.commons.validator.UpdateValidator;
import com.yuan.spring.boot.mapper.modules.system.entity.converter.SysUserConvertor;
import com.yuan.spring.boot.mapper.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.mapper.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.mapper.modules.system.entity.vo.SysUserVo;
import com.yuan.spring.boot.mapper.modules.system.service.SysUserService;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author yuane
 * @date 2019/7/13 8:39
 **/
@Controller
@RequestMapping("system/user")
@ViewPrefix("system/user")
public class SysUserController extends BaseController {
    private final SysUserService sysUserService;
    private final SysUserConvertor sysUserConvertor;

    public SysUserController(SysUserService sysUserService, SysUserConvertor sysUserConvertor) {
        this.sysUserService = sysUserService;
        this.sysUserConvertor = sysUserConvertor;
    }

    @RequestMapping
    private String index() {
        return display("index");
    }

    @RequestMapping("dataGrid")
    @ResponseBody
    public AjaxResult dataGrid(SysUserQueryParams queryParams, int page, int size) {
        return AjaxResult.data(PageUtils.build(sysUserService.selectPageByParams(new Page<>(page, size), queryParams)));
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

    @RequestMapping("add")
    public String add() {
        return display("save");
    }

    @RequestMapping("edit")
    public ModelAndView edit(String id) {
        Map<String, SysUser> data = MapUtil.builder("data", sysUserService.get(id)).build();
        return displayModelAndView("edit", data);
    }

    @RequestMapping("checkSaveOrUpdate")
    @ResponseBody
    @SuppressWarnings("ConstantConditions")
    public AjaxResult checkSaveOrUpdate(@RequestBody SysUserVo sysUserVo, BindingResult result) {
        if (result.hasGlobalErrors()) {
            return AjaxResult.error(result.getGlobalError().getDefaultMessage());
        } else {
            SysUser sysUser = sysUserConvertor.voToDomain(sysUserVo);
            return sysUserService.checkSaveOrUpdate(sysUser).convert();
        }
    }

    @SuppressWarnings("ConstantConditions")
    @RequestMapping("checkSave")
    @ResponseBody
    public AjaxResult checkSave(@RequestBody @Validated(SaveValidator.class) SysUserVo sysUserVo, BindingResult result) {
        if (result.hasGlobalErrors()) {
            return AjaxResult.error(result.getGlobalError().getDefaultMessage());
        } else {
            SysUser sysUser = sysUserConvertor.voToDomain(sysUserVo);
            return sysUserService.checkSave(sysUser).convert();
        }
    }

    @SuppressWarnings("ConstantConditions")
    @RequestMapping("checkUpdate")
    @ResponseBody
    public AjaxResult checkUpdate(@RequestBody @Validated(UpdateValidator.class) SysUserVo sysUserVo, BindingResult result) {
        if (result.hasGlobalErrors()) {
            return AjaxResult.error(result.getGlobalError().getDefaultMessage());
        } else {
            SysUser sysUser = sysUserConvertor.voToDomain(sysUserVo);
            return sysUserService.checkUpdate(sysUser).convert();
        }
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public AjaxResult saveOrUpdate(SysUserVo sysUserVo) {
        SysUser sysUser = sysUserConvertor.voToDomain(sysUserVo);
        return sysUserService.saveOrUpdate(sysUser).convert();
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxResult save(SysUserVo sysUserVo) {
        SysUser sysUser = sysUserConvertor.voToDomain(sysUserVo);
        return sysUserService.save(sysUser).convert();
    }

    @RequestMapping("update")
    @ResponseBody
    public AjaxResult update(SysUserVo sysUserVo) {
        SysUser sysUser = sysUserConvertor.voToDomain(sysUserVo);
        return sysUserService.update(sysUser).convert();
    }

    @RequestMapping("delete")
    @ResponseBody
    public AjaxResult delete(String[] id) {
        return sysUserService.deleteById(id).convert();
    }


}
