package com.yuan.spring.boot.app.modules.system.entity.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.boot.app.modules.commons.entity.domain.BaseDomain;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/14 23:21
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_permission")
public class SysPermisson extends BaseDomain {
    private String name;
    private Integer enabled;

    public SysPermisson() {
    }

    public SysPermisson(String name, Integer enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    @Builder
    public SysPermisson(String id, String createBy, String updateBy, Date createDate, Date updateDate, String name, Integer enabled) {
        super(id, createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.enabled = enabled;
    }
}
