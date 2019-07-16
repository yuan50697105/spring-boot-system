package com.yuan.spring.boot.test.app1.modules.system.entity.vo;

import com.yuan.spring.boot.test.app1.modules.commons.entity.vo.AbstractVo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/17 0:50
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserVo extends AbstractVo {
    private String username;
    private String password;
    private String name;

    public SysUserVo() {
    }

    public SysUserVo(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    @Builder
    public SysUserVo(Long id, String username, String password, String name) {
        super(id);
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
