package com.yuan.springbootwebjpa.system.entity.po;

import com.yuan.springbootwebjpa.commons.entity.po.BasePo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yuane
 * @date 2019/6/20 22:42
 **/
@Entity
@Table(name = "sys_role_resource")
public class SysRoleResource extends BasePo {
    private Long roleId;
    private Long resourceId;
}
