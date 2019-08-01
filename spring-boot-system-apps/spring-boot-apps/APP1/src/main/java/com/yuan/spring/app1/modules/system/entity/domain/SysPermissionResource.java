package com.yuan.spring.app1.modules.system.entity.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.app1.modules.commons.entity.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/8/1 19:05
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_permission_resource")
public class SysPermissionResource extends BaseEntity {
    private String permissionid;
    private String resourceid;

    public SysPermissionResource() {
    }

    public SysPermissionResource(String id) {
        super(id);
    }

    public SysPermissionResource(String permissionid, String resourceid) {
        this.permissionid = permissionid;
        this.resourceid = resourceid;
    }
}
