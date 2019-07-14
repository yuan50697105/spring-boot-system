package com.yuan.spring.boot.mapper.modules.system.entity.vo;

import com.yuan.spring.boot.mapper.modules.system.entity.domain.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/13 1:25
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserVo extends SysUser {

    public SysUserVo() {
    }

    public SysUserVo(String username, String password, String name, Integer enabled) {
        super(username, password, name, enabled);
    }

    public SysUserVo(String id, String createBy, String updateBy, Date createDate, Date updateDate, String username, String password, String name) {
        super(id, createBy, updateBy, createDate, updateDate, username, password, name);
    }
}
