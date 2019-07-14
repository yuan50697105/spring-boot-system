package com.yuan.spring.boot.mapper.modules.system.entity.dto;

import com.yuan.spring.boot.mapper.modules.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/14 23:22
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysPermissionQueryParams extends BaseQueryParams {
    private String name;
    private Integer enabled;

    public SysPermissionQueryParams() {
    }

    public SysPermissionQueryParams(String name, Integer enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public SysPermissionQueryParams(String createBy, String updateBy, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name, Integer enabled) {
        super(createBy, updateBy, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
        this.enabled = enabled;
    }

    public SysPermissionQueryParams(String id, String[] ids, String createBy, String updateBy, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name, Integer enabled) {
        super(id, ids, createBy, updateBy, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
        this.enabled = enabled;
    }
}
