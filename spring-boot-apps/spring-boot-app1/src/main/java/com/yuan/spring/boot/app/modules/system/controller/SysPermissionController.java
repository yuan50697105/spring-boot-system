package com.yuan.spring.boot.app.modules.system.controller;

import cn.hutool.core.map.MapBuilder;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.app.modules.commons.controller.BaseController;
import com.yuan.spring.boot.app.modules.system.entity.converter.SysPermissionConvertor;
import com.yuan.spring.boot.app.modules.system.entity.domain.SysPermisson;
import com.yuan.spring.boot.app.modules.system.entity.dto.SysPermissionQueryParams;
import com.yuan.spring.boot.app.modules.system.entity.vo.SysPermissionVo;
import com.yuan.spring.boot.app.modules.system.service.SysPermissionService;
import com.yuan.spring.boot.dao.mybatis.plus.utils.PageUtils;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("dataGrid")
    @ResponseBody
    public AjaxResult dataGrid(SysPermissionQueryParams queryParams, int page, int size) {
        return AjaxResult.data(PageUtils.build(sysPermissionService.selectPageByParams(new Page<>(page, size), queryParams)));
    }

    @RequestMapping("dataList")
    @ResponseBody
    public AjaxResult dataList(SysPermissionQueryParams queryParams) {
        return AjaxResult.data(sysPermissionService.selectListByParams(queryParams));
    }

    @RequestMapping("dataOne")
    @ResponseBody
    public AjaxResult dataOne(SysPermissionQueryParams queryParams) {
        return AjaxResult.data(sysPermissionService.selectOneByParams(queryParams));
    }

    @RequestMapping("add")
    @ResponseBody
    public String add() {
        return display("add");
    }

    @RequestMapping("edit")
    public ModelAndView edit(String id) {
        SysPermisson sysPermisson = sysPermissionService.get(id);
        MapBuilder<String, SysPermisson> data = MapUtil.builder("data", sysPermisson);
        return displayModelAndView("edit", data.build());
    }

    @RequestMapping("checkSaveOrUpdate")
    @ResponseBody
    public AjaxResult checkSaveOrUpdate(SysPermissionVo sysPermissionVo) {
        SysPermisson sysPermisson = sysPermissionConvertor.voToDomain(sysPermissionVo);
        return sysPermissionService.checkSaveOrUpdate(sysPermisson).convert();
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxResult save(SysPermissionVo sysPermissionVo) {
        SysPermisson sysPermisson = sysPermissionConvertor.voToDomain(sysPermissionVo);
        return sysPermissionService.save(sysPermisson).convert();
    }

    @RequestMapping("update")
    @ResponseBody
    public AjaxResult update(SysPermissionVo sysPermissionVo) {
        SysPermisson sysPermisson = sysPermissionConvertor.voToDomain(sysPermissionVo);
        return sysPermissionService.update(sysPermisson).convert();
    }

    @RequestMapping("delete")
    @ResponseBody
    public AjaxResult delete(String[] id) {
        return sysPermissionService.deleteById(id).convert();
    }

}
