package com.yuan.spring.boot.app1.modules.system.entity.dto;

import com.yuan.spring.boot.dao.mybatis.plus.entity.dto.MybatisPlusQueryParams;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/13 1:27
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQueryParams extends MybatisPlusQueryParams<String> {
    private String name;
    private Integer enabled;

    public SysUserQueryParams() {
    }

    @Builder
    public SysUserQueryParams(String id, String[] ids, String name, Integer enabled) {
        super(id, ids);
        this.name = name;
        this.enabled = enabled;
    }
}
