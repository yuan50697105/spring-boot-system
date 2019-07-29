package com.yuan.spring.app1.modules.system.entity.dto;

import com.yuan.spring.app1.modules.system.entity.domain.SysRole;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/30 1:02
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleQueryParams extends SysRole {
    public SysRoleQueryParams() {
    }

    public SysRoleQueryParams(String name) {
        super(name);
    }

    @Builder
    public SysRoleQueryParams(String id, String[] ids, String createBy, String updateBy, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name, String nameSpellFull, String nameSpellSimple) {
        super(id, ids, createBy, updateBy, createDate, updateDate, createDateStart, createDateEnd, updateDateStart, updateDateEnd, name, nameSpellFull, nameSpellSimple);
    }
}
