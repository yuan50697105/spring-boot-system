package com.yuan.spring.app1.modules.system.entity.dto;

import com.yuan.spring.app1.modules.system.entity.domain.SysPermission;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/30 1:07
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysPermissionParams extends SysPermission {
    public SysPermissionParams() {
    }

    public SysPermissionParams(String name) {
        super(name);
    }

    @Builder
    public SysPermissionParams(String id, String[] ids, String createBy, String updateBy, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name, String nameSpellFull, String nameSpellSimple) {
        super(id, ids, createBy, updateBy, createDate, updateDate, createDateStart, createDateEnd, updateDateStart, updateDateEnd, name, nameSpellFull, nameSpellSimple);
    }
}
