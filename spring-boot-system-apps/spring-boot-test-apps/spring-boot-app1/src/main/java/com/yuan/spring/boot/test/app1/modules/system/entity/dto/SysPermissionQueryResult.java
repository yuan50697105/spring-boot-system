package com.yuan.spring.boot.test.app1.modules.system.entity.dto;

import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/17 19:01
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysPermissionQueryResult extends AbstractEntity {
    private String name;
    private Integer enabled;

    public SysPermissionQueryResult() {
    }

    public SysPermissionQueryResult(Long id, String name, Integer enabled) {
        super(id);
        this.name = name;
        this.enabled = enabled;
    }
}
