package com.yuan.spring.boot.app1.modules.system.entity.vo;

import com.yuan.spring.boot.app1.modules.commons.entity.vo.BaseVo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/14 23:24
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysPermissionVo extends BaseVo {
    private String name;
    private Integer enabled;

    public SysPermissionVo() {
    }

    public SysPermissionVo(String name, Integer enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public SysPermissionVo(String createBy, String updateBy, Date createDate, Date updateDate, String name, Integer enabled) {
        super(createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.enabled = enabled;
    }

    @Builder
    public SysPermissionVo(String id, String createBy, String updateBy, Date createDate, Date updateDate, String name, Integer enabled) {
        super(id, createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.enabled = enabled;
    }
}
