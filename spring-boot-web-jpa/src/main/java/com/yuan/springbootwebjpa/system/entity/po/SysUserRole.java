package com.yuan.springbootwebjpa.system.entity.po;

import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/20 22:39
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sys_user_role")
@Data
public class SysUserRole extends BasePo {
    private Long userId;
    private Long roleId;

    public SysUserRole() {
    }

    public SysUserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @Builder
    public SysUserRole(String id, Date createDate, Date updateDate, String createUser, String updateUser, Long userId, Long roleId) {
        super(id, createDate, updateDate, createUser, updateUser);
        this.userId = userId;
        this.roleId = roleId;
    }
}
