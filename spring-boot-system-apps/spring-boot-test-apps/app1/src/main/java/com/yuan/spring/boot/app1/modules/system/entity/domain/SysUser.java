package com.yuan.spring.boot.app1.modules.system.entity.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.boot.app1.modules.commons.entity.domain.BaseDomain;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:20
 **/
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
@Data
public class SysUser extends BaseDomain {
    @TableField(value = "username", fill = FieldFill.INSERT)
    private String username;
    @TableField(value = "password", select = false)
    private String password;
    @TableField(value = "name")
    private String name;
    private Integer enabled;

    public SysUser() {
    }

    public SysUser(String username, String password, String name, Integer enabled) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
    }

    @Builder
    public SysUser(String id, String createBy, String updateBy, Date createDate, Date updateDate, String username, String password, String name) {
        super(id, createBy, updateBy, createDate, updateDate);
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
