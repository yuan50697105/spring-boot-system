package com.yuan.spring.boot.test.app1.modules.system.entity.vo;

import com.yuan.spring.boot.test.app1.modules.commons.entity.vo.AbstractVo;
import com.yuan.spring.boot.test.app1.modules.commons.validator.SaveValidator;
import com.yuan.spring.boot.test.app1.modules.commons.validator.UpdateValidator;
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
public class SysUserVo extends AbstractVo {
    @NotNull(message = "账户不能为空", groups = SaveValidator.class)
    private String username;
    @NotNull(message = "密码不能为空", groups = {SaveValidator.class, UpdateValidator.class})
    private String password;
    @NotNull(message = "用户名不能为空", groups = {SaveValidator.class, UpdateValidator.class})
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
