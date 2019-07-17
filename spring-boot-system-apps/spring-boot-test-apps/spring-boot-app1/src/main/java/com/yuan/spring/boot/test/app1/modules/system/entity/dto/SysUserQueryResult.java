package com.yuan.spring.boot.test.app1.modules.system.entity.dto;

import com.yuan.spring.boot.test.app1.modules.commons.entity.dto.AbstractQueryResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQueryResult extends AbstractQueryResult {
    private String username;
    private String name;
    private String password;
    private Integer enabled;

    public SysUserQueryResult() {
    }

    //    @Builder
    public SysUserQueryResult(Long id, String username, String name, String password, Integer enabled) {
        super(id);
        this.username = username;
        this.name = name;
        this.password = password;
        this.enabled = enabled;
    }
}
