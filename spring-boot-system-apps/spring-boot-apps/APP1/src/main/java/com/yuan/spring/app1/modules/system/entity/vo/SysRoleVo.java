package com.yuan.spring.app1.modules.system.entity.vo;

import com.yuan.spring.app1.modules.system.entity.domain.SysRole;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/30 1:03
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleVo extends SysRole {
    public SysRoleVo() {
    }

    public SysRoleVo(String id) {
        super(id);
    }

    public SysRoleVo(String name, String nameSpellFull, String nameSpellSimple) {
        super(name, nameSpellFull, nameSpellSimple);
    }

    @Builder
    public SysRoleVo(String id, String createBy, String updateBy, Date createDate, Date updateDate, String name, String nameSpellFull, String nameSpellSimple) {
        super(id, createBy, updateBy, createDate, updateDate, name, nameSpellFull, nameSpellSimple);
    }
}
