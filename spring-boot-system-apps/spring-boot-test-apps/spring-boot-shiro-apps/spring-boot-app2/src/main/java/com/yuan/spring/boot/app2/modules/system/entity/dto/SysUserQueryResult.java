package com.yuan.spring.boot.app2.modules.system.entity.dto;

import com.yuan.spring.boot.app2.modules.system.entity.domain.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/22 23:05
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQueryResult extends SysUser {
}
