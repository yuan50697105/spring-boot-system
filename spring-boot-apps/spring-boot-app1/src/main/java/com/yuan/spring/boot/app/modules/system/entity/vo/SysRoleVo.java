package com.yuan.spring.boot.app.modules.system.entity.vo;

import com.yuan.spring.boot.app.modules.commons.entity.vo.BaseVo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/14 20:19
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleVo extends BaseVo {
    private String name;//角色名称
    private Integer enabled;//是否启用（0：启用，1：停用）

    public SysRoleVo() {
    }

    public SysRoleVo(String name, Integer enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public SysRoleVo(String createBy, String updateBy, Date createDate, Date updateDate, String name, Integer enabled) {
        super(createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.enabled = enabled;
    }

    @Builder
    public SysRoleVo(String id, String createBy, String updateBy, Date createDate, Date updateDate, String name, Integer enabled) {
        super(id, createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.enabled = enabled;
    }
}
