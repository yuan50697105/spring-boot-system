package com.yuan.spring.boot.test.app1.modules.system.entity.vo;

import com.yuan.spring.boot.test.app1.modules.commons.entity.vo.AbstractVo;
import com.yuan.spring.boot.test.app1.modules.commons.validator.SaveValidator;
import com.yuan.spring.boot.test.app1.modules.commons.validator.UpdateValidator;
import com.yuan.spring.boot.test.app1.modules.system.entity.domain.SysUser;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author yuane
 * @date 2019/7/17 0:50
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserVo extends SysUser {
    public SysUserVo() {
    }

    public SysUserVo(String username, String password, String name, String nameSpellSimple, String nameSpellFull, Integer enabled) {
        super(username, password, name, nameSpellSimple, nameSpellFull, enabled);
    }

    public SysUserVo(Long id, String username, String password, String name, String nameSpellSimple, String nameSpellFull, Integer enabled) {
        super(id, username, password, name, nameSpellSimple, nameSpellFull, enabled);
    }
}
