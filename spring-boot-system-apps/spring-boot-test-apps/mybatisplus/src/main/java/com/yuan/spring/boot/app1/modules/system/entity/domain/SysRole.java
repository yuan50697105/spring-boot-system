package com.yuan.spring.boot.app1.modules.system.entity.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.boot.app1.modules.commons.entity.domain.BaseDomain;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/14 20:16
 **/
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
@Data
public class SysRole extends BaseDomain {
    private String name;//角色名称
    private Integer enabled;//是否启用（0：启用，1：停用）

    public SysRole() {
    }

    public SysRole(String name, Integer enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    @Builder
    public SysRole(String id, String createBy, String updateBy, Date createDate, Date updateDate, String name, Integer enabled) {
        super(id, createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.enabled = enabled;
    }
}
