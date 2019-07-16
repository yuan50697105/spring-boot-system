package com.yuan.spring.boot.test.app1.modules.system.entity.vo;

import com.yuan.spring.boot.test.app1.modules.commons.entity.vo.AbstractVo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/17 1:00
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleVo extends AbstractVo {
    private String name;

    public SysRoleVo() {
    }

    @Builder
    public SysRoleVo(Long id, String name) {
        super(id);
        this.name = name;
    }
}
