package com.yuan.spring.boot.mapper.modules.system.entity.vo;

import com.yuan.spring.boot.mapper.modules.system.entity.domain.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/14 20:19
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleVo extends SysRole {
    public SysRoleVo() {
    }

    public SysRoleVo(String name, Integer enabled) {
        super(name, enabled);
    }

    public SysRoleVo(String id, String createBy, String updateBy, Date createDate, Date updateDate, String name, Integer enabled) {
        super(id, createBy, updateBy, createDate, updateDate, name, enabled);
    }
}
