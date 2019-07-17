package com.yuan.spring.boot.test.app1.modules.system.entity.dto;

import com.yuan.spring.boot.test.app1.modules.commons.entity.dto.AbstractQueryParams;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/17 19:00
 **/

@EqualsAndHashCode(callSuper = true)
@Data
public class SysPermissionQueryParams extends AbstractQueryParams {
    private String name;
    private Integer enabled;

    public SysPermissionQueryParams() {
    }

    @Builder
    public SysPermissionQueryParams(Long id, Long[] ids, String name, Integer enabled) {
        super(id, ids);
        this.name = name;
        this.enabled = enabled;
    }
}
