package com.yuan.spring.boot.app.modules.system.entity.dto;

import com.yuan.spring.boot.app.modules.commons.entity.dto.BaseQueryParams;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:27
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQueryParams extends BaseQueryParams {
    private String name;

    public SysUserQueryParams() {
    }

    @Builder
    public SysUserQueryParams(String id, String[] ids, String createUser, String updateUser, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name) {
        super(id, ids, createUser, updateUser, createDate, updateDate, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
    }
}
