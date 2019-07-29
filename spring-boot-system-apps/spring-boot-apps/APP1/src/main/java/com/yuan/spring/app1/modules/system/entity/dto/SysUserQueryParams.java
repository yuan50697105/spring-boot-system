package com.yuan.spring.app1.modules.system.entity.dto;

import com.yuan.spring.app1.modules.system.entity.domain.SysUser;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/27 11:03
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQueryParams extends SysUser {

    public SysUserQueryParams() {
    }

    public SysUserQueryParams(String id) {
        super(id);
    }

    @Builder
    public SysUserQueryParams(String id, String[] ids, String createBy, String updateBy, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String username, String password, String name, String nameSpellFull, String nameSpellSimple, Integer enabled) {
        super(id, ids, createBy, updateBy, createDate, updateDate, createDateStart, createDateEnd, updateDateStart, updateDateEnd, username, password, name, nameSpellFull, nameSpellSimple, enabled);
    }
}
