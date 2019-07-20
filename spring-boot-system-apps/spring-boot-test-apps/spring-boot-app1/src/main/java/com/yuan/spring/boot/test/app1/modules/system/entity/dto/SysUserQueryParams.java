package com.yuan.spring.boot.test.app1.modules.system.entity.dto;

import com.yuan.spring.boot.test.app1.modules.commons.entity.dto.AbstractQueryParams;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/19 22:28
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQueryParams extends AbstractQueryParams {
    private String name;

    public SysUserQueryParams() {
    }

    @Builder
    public SysUserQueryParams(Long id, Long[] ids, String name) {
        super(id, ids);
        this.name = name;
    }
}
