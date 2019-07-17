package com.yuan.spring.boot.test.app1.modules.system.entity.domain;

import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/17 18:59
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysPermission extends AbstractEntity {
    private String name;
    private Integer enabled;

    public SysPermission() {
    }

    @Builder
    public SysPermission(Long id, String name, Integer enabled) {
        super(id);
        this.name = name;
        this.enabled = enabled;
    }
}
