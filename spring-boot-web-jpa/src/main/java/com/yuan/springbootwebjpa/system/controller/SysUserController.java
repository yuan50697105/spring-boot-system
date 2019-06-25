package com.yuan.springbootwebjpa.system.controller;

import com.yuan.springbootwebjpa.commons.controller.BaseController;
import com.yuan.springbootwebjpa.commons.entity.dto.Result;
import com.yuan.springbootwebjpa.commons.entity.vo.AjaxResult;
import com.yuan.springbootwebjpa.commons.entity.vo.PageVo;
import com.yuan.springbootwebjpa.system.entity.bo.SysUserQueryParam;
import com.yuan.springbootwebjpa.system.service.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.List;
import java.util.Optional;

/**
 * @author yuane
 * @date 2019/6/25 18:50
 **/
@Controller
@RequestMapping("system/user")
public class SysUserController extends BaseController {
    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("dataGrid")
    @ResponseBody
    public WebAsyncTask<AjaxResult> dataGrid(SysUserQueryParam queryParam, int page, int size) {
        return new WebAsyncTask<>(() -> {
            Page pageByParams = sysUserService.findPageByParams(queryParam, PageRequest.of(page, size));
            return Result.of(Result.Status.DATA, null, PageVo.of(pageByParams.getTotalElements(), pageByParams.getContent())).toAjax();
        });
    }

    @RequestMapping("dataList")
    @ResponseBody
    public WebAsyncTask<AjaxResult> dataList(SysUserQueryParam queryParam) {
        return new WebAsyncTask<>(() -> {
            List listByParams = sysUserService.findListByParams(queryParam);
            return Result.of(Result.Status.DATA, null, listByParams).toAjax();
        });
    }

    @RequestMapping("dataOne")
    @ResponseBody
    public WebAsyncTask<AjaxResult> dataOne(SysUserQueryParam queryParam) {
        return new WebAsyncTask<>(() -> {
            Optional oneByParams = sysUserService.findOneByParams(queryParam);
            return Result.of(Result.Status.DATA, null, oneByParams).toAjax();
        });
    }


}
