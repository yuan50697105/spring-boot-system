package com.yuan.springbootwebjpa.system.entity.po;

import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/20 22:42
 **/
@Entity
@Table(name = "sys_role_resource")
public class SysRoleResource extends BasePo {
    private Long roleId;
    private Long resourceId;

    public SysRoleResource() {
    }

    public SysRoleResource(Long roleId, Long resourceId) {
        this.roleId = roleId;
        this.resourceId = resourceId;
    }

    @Builder
    public SysRoleResource(String id, Date createDate, Date updateDate, String createUser, String updateUser, Long roleId, Long resourceId) {
        super(id, createDate, updateDate, createUser, updateUser);
        this.roleId = roleId;
        this.resourceId = resourceId;
    }
}
