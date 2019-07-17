package com.yuan.spring.boot.test.app1.modules.system.controller;

import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.hutool.core.map.MapUtil;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.entity.vo.PageVo;
import com.yuan.spring.boot.test.app1.modules.commons.controler.AbstractController;
import com.yuan.spring.boot.test.app1.modules.commons.validator.SaveValidator;
import com.yuan.spring.boot.test.app1.modules.commons.validator.UpdateValidator;
import com.yuan.spring.boot.test.app1.modules.system.entity.converter.SysRoleConverter;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysRole;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleExcelEntity;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysRoleQueryResult;
import com.yuan.spring.boot.test.app1.modules.system.entity.vo.SysRoleVo;
import com.yuan.spring.boot.test.app1.modules.system.service.SysRoleService;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("system/role")
@ViewPrefix("system/role")
public class SysRoleController extends AbstractController {
    private SysRoleService sysRoleService;
    private SysRoleConverter sysRoleConverter;

    public SysRoleController(SysRoleService sysRoleService, SysRoleConverter sysRoleConverter) {
        this.sysRoleService = sysRoleService;
        this.sysRoleConverter = sysRoleConverter;
    }

    @RequestMapping
    public WebAsyncTask<ModelAndView> index() {
        return new WebAsyncTask<>(() -> displayModelAndView("index"));
    }

    @RequestMapping("dataGrid")
    public WebAsyncTask<AjaxResult> dataGrid(SysRoleQueryParams queryParams, int page, int size) {
        return new WebAsyncTask<>(() -> {
            Page<SysRoleQueryResult> queryResults = sysRoleService.findAll(queryParams, PageRequest.of(page, size));
            PageVo pageVo = PageVo.build(queryResults.getTotalElements(), queryResults.getContent());
            return AjaxResult.data(pageVo);
        });
    }

    @RequestMapping("dataList")
    public WebAsyncTask<AjaxResult> dataList(SysRoleQueryParams queryParams) {
        return new WebAsyncTask<>(() -> {
            List<SysRoleQueryResult> queryResults = sysRoleService.findAll(queryParams);
            return AjaxResult.data(queryParams);
        });
    }

    @RequestMapping("dataOne")
    public WebAsyncTask<AjaxResult> dataOne(SysRoleQueryParams queryParams) {
        return new WebAsyncTask<>(() -> {
            SysRoleQueryResult queryResult = sysRoleService.findOne(queryParams);
            return AjaxResult.data(queryResult);
        });
    }

    @RequestMapping("add")
    public WebAsyncTask<ModelAndView> add() {
        return new WebAsyncTask<>(() -> displayModelAndView("add"));
    }

    @RequestMapping("edit")
    public WebAsyncTask<ModelAndView> edit(Long id) {
        return new WebAsyncTask<>(() -> {
            Map<String, SysRole> data = MapUtil.builder("data", sysRoleService.get(id)).build();
            return displayModelAndView("edit", data);
        });
    }

    @RequestMapping("checkSave")
    public WebAsyncTask<AjaxResult> checkSave(@Validated(SaveValidator.class) SysRoleVo roleVo, BindingResult result) {
        return new WebAsyncTask<>(() -> {
            return checkFormProcess(roleVo, result, sysRoleService.checkSave(sysRoleConverter.voToDomain(roleVo)));
        });
    }

    @RequestMapping("checkUpdate")
    public WebAsyncTask<AjaxResult> checkUpdate(@Validated(UpdateValidator.class) SysRoleVo roleVo, BindingResult result) {
        return new WebAsyncTask<>(() -> checkFormProcess(roleVo, result, sysRoleService.checkUpdate(sysRoleConverter.voToDomain(roleVo))));
    }

    @RequestMapping("save")
    public WebAsyncTask<AjaxResult> save(@RequestBody @Validated(SaveValidator.class) SysRoleVo roleVo, BindingResult result) {
        return new WebAsyncTask<>(() -> checkFormProcess(roleVo, result, sysRoleService.save(sysRoleConverter.voToDomain(roleVo))));
    }

    @RequestMapping("update")
    public WebAsyncTask<AjaxResult> update(@RequestBody @Validated(UpdateValidator.class) SysRoleVo roleVo, BindingResult result) {
        return new WebAsyncTask<>(() -> checkFormProcess(roleVo, result, sysRoleService.update(sysRoleConverter.voToDomain(roleVo))));
    }

    @RequestMapping("delete")
    public WebAsyncTask<AjaxResult> delete(Long[] ids) {
        return new WebAsyncTask<>(() -> sysRoleService.deleteById(ids).convert());
    }

    @RequestMapping("upload")
    public WebAsyncTask<ResponseEntity<byte[]>> upload(MultipartFile file) {
        return new WebAsyncTask<>(() -> {
            ServiceResult<ExcelImportResult<SysRoleExcelEntity>> serviceResult = sysRoleService.upload(file);
            return uploadExcelProcess(serviceResult);
        });
    }


}
