package com.yuan.spring.app1.modules.system.entity.vo;

import com.yuan.spring.app1.modules.system.entity.domain.SysPermission;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/30 1:10
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysPermissionVo extends SysPermission {

    public SysPermissionVo() {
    }

    public SysPermissionVo(String id) {
        super(id);
    }

    public SysPermissionVo(String name, String nameSpellFull, String nameSpellSimple) {
        super(name, nameSpellFull, nameSpellSimple);
    }

    @Builder
    public SysPermissionVo(String id, String createBy, String updateBy, Date createDate, Date updateDate, String name, String nameSpellFull, String nameSpellSimple) {
        super(id, createBy, updateBy, createDate, updateDate, name, nameSpellFull, nameSpellSimple);
    }
}
