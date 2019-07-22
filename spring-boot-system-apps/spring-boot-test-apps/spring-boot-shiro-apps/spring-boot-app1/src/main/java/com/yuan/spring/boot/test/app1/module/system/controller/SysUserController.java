package com.yuan.spring.boot.test.app1.module.system.controller;

import com.yuan.spring.boot.test.app1.module.commons.controller.BaseController;
import com.yuan.spring.boot.test.app1.module.system.service.SysUserService;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yuane
 * @date 2019/7/21 23:49
 **/
@Controller
@RequestMapping("system/user")
@ViewPrefix("system/user")
public class SysUserController extends BaseController {
    private SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    public void download(HttpServletRequest request, HttpServletResponse response) {
    }
}
