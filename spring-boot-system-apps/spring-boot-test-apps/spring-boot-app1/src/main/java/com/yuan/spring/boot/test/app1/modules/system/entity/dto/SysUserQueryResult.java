package com.yuan.spring.boot.test.app1.modules.system.entity.dto;

import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQueryResult extends SysUser {
    public SysUserQueryResult() {
    }

    public SysUserQueryResult(String username, String password, String name, String nameSpellSimple, String nameSpellFull, Integer enabled) {
        super(username, password, name, nameSpellSimple, nameSpellFull, enabled);
    }

    public SysUserQueryResult(Long id, String username, String password, String name, String nameSpellSimple, String nameSpellFull, Integer enabled) {
        super(id, username, password, name, nameSpellSimple, nameSpellFull, enabled);
    }
}
