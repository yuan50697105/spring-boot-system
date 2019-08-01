package com.yuan.spring.app1.modules.system.entity.vo;

import com.yuan.spring.app1.modules.system.entity.domain.SysUser;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/27 11:23
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserVo extends SysUser {

    public SysUserVo() {
    }

    public SysUserVo(String id) {
        super(id);
    }

    @Builder
    public SysUserVo(String username, String password, String name, Integer enabled) {
        super(username, password, name, enabled);
    }

}
