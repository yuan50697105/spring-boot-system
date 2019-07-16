package com.yuan.spring.boot.app1.modules.system.entity.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.boot.app1.modules.commons.entity.domain.BaseDomain;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/15 23:31
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_resource")
public class SysResource extends BaseDomain {
    private String name;
    private String url;
    private String icon;
    private String permission;
    private Integer type;

    public SysResource() {
    }

    public SysResource(String name, String url, String icon, String permission, Integer type) {
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.permission = permission;
        this.type = type;
    }

    @Builder
    public SysResource(String id, String createBy, String updateBy, Date createDate, Date updateDate, String name, String url, String icon, String permission, Integer type) {
        super(id, createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.permission = permission;
        this.type = type;
    }
}
