package com.yuan.spring.boot.test.app1.modules.system.entity.dto;

import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleQueryResult extends SysRole {
    public SysRoleQueryResult() {
    }

    public SysRoleQueryResult(String name, Integer enabled) {
        super(name, enabled);
    }

    public SysRoleQueryResult(Long id, String name, Integer enabled) {
        super(id, name, enabled);
    }
}
