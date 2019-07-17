package com.yuan.spring.boot.test.app1.modules.system.entity.dto;

import com.yuan.spring.boot.test.app1.modules.commons.entity.dto.AbstractExcelEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleExcelEntity extends AbstractExcelEntity {
    private String name;
    private Integer enabled;

    public SysRoleExcelEntity() {
    }

    @Builder
    public SysRoleExcelEntity(Long id, int rowNum, String errorMsg, String name, Integer enabled) {
        super(id, rowNum, errorMsg);
        this.name = name;
        this.enabled = enabled;
    }
}
