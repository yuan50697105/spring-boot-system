package com.spring.boot.test.app3.modules.commons.entity.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQueryParams extends BaseQueryParams {
    private String name;

    public SysUserQueryParams() {
    }

    @Builder
    public SysUserQueryParams(Long id, Long[] ids, Integer pageNum, Integer pageSize, String orderBy, String name) {
        super(id, ids, pageNum, pageSize, orderBy);
        this.name = name;
    }
}
