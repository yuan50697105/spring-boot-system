package com.yuan.spring.boot.app1.modules.device.entity.dto;

import com.yuan.spring.boot.app1.modules.commons.entity.dto.BaseQueryParams;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/16 18:58
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class DeviceTypeQueryParams extends BaseQueryParams {
    private String name;

    public DeviceTypeQueryParams() {
    }

    public DeviceTypeQueryParams(String name) {
        this.name = name;
    }

    public DeviceTypeQueryParams(String createBy, String updateBy, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name) {
        super(createBy, updateBy, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
    }

    @Builder
    public DeviceTypeQueryParams(String id, String[] ids, String createBy, String updateBy, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name) {
        super(id, ids, createBy, updateBy, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
    }
}
