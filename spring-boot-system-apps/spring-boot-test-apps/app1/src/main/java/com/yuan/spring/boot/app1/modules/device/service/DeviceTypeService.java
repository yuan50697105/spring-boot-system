package com.yuan.spring.boot.app1.modules.device.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.spring.boot.app1.modules.commons.service.BaseService;
import com.yuan.spring.boot.app1.modules.device.entity.domain.DeviceType;
import com.yuan.spring.boot.app1.modules.device.entity.dto.DeviceTypeQueryParams;

/**
 * @author yuane
 * @date 2019/7/16 19:04
 **/
public interface DeviceTypeService extends BaseService<DeviceType> {
    IPage<DeviceType> selectPageByParams(Page<DeviceType> objectPage, DeviceTypeQueryParams queryParams);
}
