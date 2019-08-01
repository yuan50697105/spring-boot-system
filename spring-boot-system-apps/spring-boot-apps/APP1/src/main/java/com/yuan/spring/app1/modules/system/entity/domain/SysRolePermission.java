package com.yuan.spring.app1.modules.system.entity.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.app1.modules.commons.entity.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/8/1 19:04
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role_permission")
public class SysRolePermission extends BaseEntity {
    private String roleid;
    private String permissionid;

    public SysRolePermission() {
    }

    public SysRolePermission(String id) {
        super(id);
    }

    public SysRolePermission(String roleid, String permissionid) {
        this.roleid = roleid;
        this.permissionid = permissionid;
    }
}
