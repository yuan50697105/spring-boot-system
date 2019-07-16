package com.yuan.spring.boot.app1.modules.system;

import com.google.common.collect.Lists;
import com.yuan.spring.boot.app1.modules.commons.controller.BaseController;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author yuane
 * @date 2019/7/16 21:38
 **/
@RestController
@RequestMapping
@Slf4j
public class SysUserController extends BaseController {
    private SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @RequestMapping("data")
    public AjaxResult data() {
        List<SysUser> users = sysUserService.findAll();
        log.info(users.size() + "");
        return AjaxResult.data(users.size() + "", users);
    }

    @RequestMapping("data2")
    public Callable<AjaxResult> data2() {
        return () -> data();
    }

    @RequestMapping("data3")
    public WebAsyncTask<AjaxResult> data3() {
        return new WebAsyncTask<>(data2());
    }

    @RequestMapping("save")
    public AjaxResult save(SysUser sysUser) {
        return sysUserService.saveBatch(Lists.newArrayList(sysUser, sysUser, sysUser, sysUser, sysUser, sysUser)).convert();
    }


    @RequestMapping("save1")
    public Callable<AjaxResult> save1(SysUser sysUser) {
        return () -> save(sysUser);
    }
}
