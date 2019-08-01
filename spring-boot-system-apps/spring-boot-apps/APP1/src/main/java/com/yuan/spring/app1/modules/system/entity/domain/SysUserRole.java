package com.yuan.spring.app1.modules.system.entity.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.app1.modules.commons.entity.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/8/1 19:03
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {
    private String userid;
    private String roleid;

    public SysUserRole() {
    }

    public SysUserRole(String id) {
        super(id);
    }

    public SysUserRole(String userid, String roleid) {
        this.userid = userid;
        this.roleid = roleid;
    }
}
