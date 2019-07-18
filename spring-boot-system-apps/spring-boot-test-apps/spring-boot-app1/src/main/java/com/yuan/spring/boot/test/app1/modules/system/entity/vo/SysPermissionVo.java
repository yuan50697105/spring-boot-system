package com.yuan.spring.boot.test.app1.modules.system.entity.vo;

import com.yuan.spring.boot.test.app1.modules.commons.entity.vo.AbstractVo;
import com.yuan.spring.boot.test.app1.modules.commons.validator.SaveValidator;
import com.yuan.spring.boot.test.app1.modules.commons.validator.UpdateValidator;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysPermission;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author yuane
 * @date 2019/7/17 19:06
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysPermissionVo extends SysPermission {
    public SysPermissionVo() {
    }

    public SysPermissionVo(String name, Integer enabled) {
        super(name, enabled);
    }

    @Builder
    public SysPermissionVo(Long id, String name, Integer enabled) {
        super(id, name, enabled);
    }
}
