package com.yuan.spring.boot.app2.modules.system.entity.dto;

import com.yuan.spring.boot.app2.modules.commons.entity.dto.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/22 22:58
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQueryParams extends BaseQueryParams {
    private String name;
}
