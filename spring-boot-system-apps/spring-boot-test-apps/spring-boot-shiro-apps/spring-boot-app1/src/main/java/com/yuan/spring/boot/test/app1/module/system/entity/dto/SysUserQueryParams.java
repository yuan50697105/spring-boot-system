package com.yuan.spring.boot.test.app1.module.system.entity.dto;

import com.yuan.spring.boot.test.app1.module.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/21 23:34
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQueryParams extends BaseQueryParams {
    private String name;
}
