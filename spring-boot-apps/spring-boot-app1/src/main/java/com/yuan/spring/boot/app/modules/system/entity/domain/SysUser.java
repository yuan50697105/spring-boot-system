package com.yuan.spring.boot.app.modules.system.entity.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.boot.app.modules.commons.entity.domain.BaseDomain;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:20
 **/
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
@Data
@NoArgsConstructor
public class SysUser extends BaseDomain {
    @TableField(value = "username", fill = FieldFill.INSERT)
    private String username;
    @TableField(value = "password", select = false)
    private String password;
    @TableField(value = "name")
    private String name;

    public SysUser(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    @Builder
    public SysUser(String id, String createUser, String updateUser, Date createDate, Date updateDate, String username, String password, String name) {
        super(id, createUser, updateUser, createDate, updateDate);
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
