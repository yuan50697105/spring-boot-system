package com.yuan.spring.boot.test.app1.modules.system.entity.vo;

import com.yuan.spring.boot.test.app1.modules.commons.entity.vo.AbstractVo;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysRole;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/17 1:00
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleVo extends SysRole {
    public SysRoleVo() {
    }

    public SysRoleVo(String name, Integer enabled) {
        super(name, enabled);
    }

    public SysRoleVo(Long id, String name, Integer enabled) {
        super(id, name, enabled);
    }
}
