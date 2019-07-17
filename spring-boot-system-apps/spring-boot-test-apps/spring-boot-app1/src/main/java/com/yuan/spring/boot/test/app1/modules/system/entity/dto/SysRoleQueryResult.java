package com.yuan.spring.boot.test.app1.modules.system.entity.dto;

import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleQueryResult extends AbstractEntity {
    private String name;
    private Integer enabled;

    public SysRoleQueryResult() {
    }

    @Builder
    public SysRoleQueryResult(Long id, String name, Integer enabled) {
        super(id);
        this.name = name;
        this.enabled = enabled;
    }
}
