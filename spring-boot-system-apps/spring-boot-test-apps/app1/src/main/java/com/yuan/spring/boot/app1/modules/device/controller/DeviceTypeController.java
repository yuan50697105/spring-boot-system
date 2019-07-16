package com.yuan.spring.boot.app1.modules.device.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.app1.modules.commons.controller.BaseController;
import com.yuan.spring.boot.app1.modules.device.entity.converter.DeviceTypeConverter;
import com.yuan.spring.boot.app1.modules.device.entity.domain.DeviceType;
import com.yuan.spring.boot.app1.modules.device.entity.dto.DeviceTypeQueryParams;
import com.yuan.spring.boot.app1.modules.device.service.DeviceTypeService;
import com.yuan.spring.boot.dao.commons.entity.vo.PageVo;
import com.yuan.spring.web.mvc.annotation.ViewPrefix;
import com.yuan.spring.web.mvc.entity.vo.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yuane
 * @date 2019/7/16 19:09
 **/
@RestController
@RequestMapping("device/type")
@ViewPrefix("device/type")
public class DeviceTypeController extends BaseController {
    private DeviceTypeService deviceTypeService;
    private DeviceTypeConverter deviceTypeConverter;

    public DeviceTypeController(DeviceTypeService deviceTypeService, DeviceTypeConverter deviceTypeConverter) {
        this.deviceTypeService = deviceTypeService;
        this.deviceTypeConverter = deviceTypeConverter;
    }

    @RequestMapping
    public ModelAndView list() {
        return displayModelAndView("list");
    }

    @RequestMapping("dataGrid")
    public AjaxResult dataGrid(DeviceTypeQueryParams queryParams, int page, int size) {
        IPage<DeviceType> typeIPage = deviceTypeService.selectPageByParams(new Page<>(page, size), queryParams);
        return AjaxResult.data(PageVo.build(typeIPage.getTotal(), typeIPage.getRecords()));
    }
}
