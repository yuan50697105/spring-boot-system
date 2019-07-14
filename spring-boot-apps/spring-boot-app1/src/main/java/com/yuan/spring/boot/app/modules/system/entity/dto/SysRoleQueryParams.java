package com.yuan.spring.boot.app.modules.system.entity.dto;

import com.yuan.spring.boot.app.modules.commons.entity.dto.BaseQueryParams;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/14 20:18
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleQueryParams extends BaseQueryParams {
    private String name;
    private Integer enabled;

    public SysRoleQueryParams() {
    }

    public SysRoleQueryParams(String name, Integer enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public SysRoleQueryParams(String createBy, String updateBy, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name, Integer enabled) {
        super(createBy, updateBy, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
        this.enabled = enabled;
    }

    @Builder
    public SysRoleQueryParams(String id, String[] ids, String createBy, String updateBy, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name, Integer enabled) {
        super(id, ids, createBy, updateBy, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
        this.enabled = enabled;
    }
}
