package com.yuan.spring.boot.test.app1.modules.system.entity.dto;

import com.yuan.spring.boot.test.app1.modules.commons.entity.dto.AbstractQueryParams;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/17 0:59
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleQueryParams extends AbstractQueryParams {
    private String name;
    private Integer enabled;

    public SysRoleQueryParams() {
    }

    @Builder
    public SysRoleQueryParams(Long id, Long[] ids, String name, Integer enabled) {
        super(id, ids);
        this.name = name;
        this.enabled = enabled;
    }
}
