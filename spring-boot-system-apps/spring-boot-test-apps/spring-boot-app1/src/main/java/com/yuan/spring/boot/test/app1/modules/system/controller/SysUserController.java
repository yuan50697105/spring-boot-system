package com.yuan.spring.boot.test.app1.modules.system.controller;

import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.entity.vo.PageVo;
import com.yuan.spring.boot.test.app1.modules.commons.controler.AbstractController;
import com.yuan.spring.boot.test.app1.modules.commons.validator.SaveValidator;
import com.yuan.spring.boot.test.app1.modules.commons.validator.UpdateValidator;
import com.yuan.spring.boot.test.app1.modules.system.entity.converter.SysUserConverter;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserExcelEntity;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserQueryParams;
import com.yuan.spring.boot.test.app1.modules.system.entity.dto.SysUserQueryResult;
import com.yuan.spring.boot.test.app1.modules.system.entity.vo.SysUserVo;
import com.yuan.spring.boot.test.app1.modules.system.service.SysUserService;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.apache.poi.ss.usermodel.Workbook;
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

/**
 * @author yuane
 * @date 2019/7/17 1:05
 **/
@RestController
@RequestMapping("sys/user")
@ViewPrefix("sys/user")
public class SysUserController extends AbstractController {
    private SysUserService sysUserService;
    private SysUserConverter sysUserConverter;

    public SysUserController(SysUserService sysUserService, SysUserConverter sysUserConverter) {
        this.sysUserService = sysUserService;
        this.sysUserConverter = sysUserConverter;
    }

    @RequestMapping
    public WebAsyncTask<ModelAndView> index() {
        return new WebAsyncTask<>(() -> displayModelAndView("index"));
    }

    @RequestMapping("dataGrid")
    public WebAsyncTask<AjaxResult> dataGrid(SysUserQueryParams queryParams, int page, int size) {
        return new WebAsyncTask<>(() -> {
            Page<SysUserQueryResult> queryResults = sysUserService.findAll(queryParams, PageRequest.of(page, size));
            PageVo pageVo = PageVo.build(queryResults.getTotalElements(), queryResults.getContent());
            return AjaxResult.data(pageVo);
        });
    }

    @RequestMapping("dataList")
    public WebAsyncTask<AjaxResult> dataList(SysUserQueryParams queryParams) {
        return new WebAsyncTask<>(() -> {
            List<SysUserQueryResult> sysUsers = sysUserService.findAll(queryParams);
            return AjaxResult.data(sysUsers);
        });
    }

    @RequestMapping("dataOne")
    public WebAsyncTask<AjaxResult> dataOne(SysUserQueryParams queryParams) {
        return new WebAsyncTask<>(() -> {
            SysUserQueryResult queryResult = sysUserService.findOne(queryParams);
            return AjaxResult.data(queryResult);
        });
    }

    @RequestMapping("checkSave")
    public WebAsyncTask<AjaxResult> checkSave(@RequestBody @Validated(SaveValidator.class) SysUserVo sysUser, BindingResult result) {
        return new WebAsyncTask<>(() -> checkFormProcess(sysUser, result, sysUserService.checkSave(sysUserConverter.voToDomain(sysUser)).convert()));
    }

    @RequestMapping("checkUpdate")
    public WebAsyncTask<AjaxResult> checkUpdate(@RequestBody @Validated(UpdateValidator.class) SysUserVo sysUser, BindingResult result) {
        return new WebAsyncTask<>(() -> checkFormProcess(sysUser, result, sysUserService.checkUpdate(sysUserConverter.voToDomain(sysUser)).convert()));
    }


    @RequestMapping("save")
    public WebAsyncTask<AjaxResult> save(@RequestBody @Validated(SaveValidator.class) SysUserVo sysUser, BindingResult result) {
        return new WebAsyncTask<>(() -> checkFormProcess(sysUser, result, sysUserService.save(sysUserConverter.voToDomain(sysUser)).convert()));
    }


    @RequestMapping("update")
    public WebAsyncTask<AjaxResult> update(@RequestBody @Validated(UpdateValidator.class) SysUserVo sysUser, BindingResult result) {
        return new WebAsyncTask<>(() -> checkFormProcess(sysUser, result, sysUserService.update(sysUserConverter.voToDomain(sysUser)).convert()));
    }

    public WebAsyncTask<AjaxResult> delete(Long[] ids) {
        return new WebAsyncTask<>(() -> sysUserService.deleteAllById(ids).convert());
    }

    @RequestMapping("upload")
    public WebAsyncTask<ResponseEntity<byte[]>> upload(MultipartFile file) {
        return new WebAsyncTask<>(() -> {
            ServiceResult<ExcelImportResult<SysUserExcelEntity>> result = sysUserService.upload(file);
            return uploadExcelProcess(result);
        });
    }

    public WebAsyncTask<ResponseEntity<byte[]>> download(SysUserQueryParams queryParams) {
        return new WebAsyncTask<>(() -> {
            Workbook workbook = sysUserService.download(queryParams);
            return downloadExcelProcess(workbook);
        });

    }


}
