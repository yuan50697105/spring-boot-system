package com.yuan.spring.boot.app1.modules.system.controller;

import com.yuan.spring.boot.app1.modules.commons.controller.BaseController;
import com.yuan.spring.boot.app1.modules.system.entity.converter.SysResoureConverter;
import com.yuan.spring.boot.app1.modules.system.entity.dto.SysResourceQueryParams;
import com.yuan.spring.boot.app1.modules.system.service.SysResourceService;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuane
 * @date 2019/7/15 23:48
 **/
@Controller
@RequestMapping("system/resource")
@ViewPrefix("system/resource")
public class SysResourceController extends BaseController {
    private SysResourceService sysResourceService;
    private SysResoureConverter sysResoureConverter;

    public SysResourceController(SysResourceService sysResourceService, SysResoureConverter sysResoureConverter) {
        this.sysResourceService = sysResourceService;
        this.sysResoureConverter = sysResoureConverter;
    }

    @RequestMapping
    public String index() {
        return display("index");
    }

    public AjaxResult treeGrid(SysResourceQueryParams queryParams) {
        return AjaxResult.ok();
    }

}
