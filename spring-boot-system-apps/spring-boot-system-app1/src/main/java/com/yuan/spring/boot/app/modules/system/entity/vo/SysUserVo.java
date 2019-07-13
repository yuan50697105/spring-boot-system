package com.yuan.spring.boot.app.modules.system.entity.vo;

import com.yuan.spring.boot.app.modules.system.entity.domain.SysUser;
import com.yuan.spring.boot.app.modules.system.entity.validator.InsertValidator;
import com.yuan.spring.boot.app.modules.system.entity.validator.UpdateValidator;
import com.yuan.spring.boot.dao.mybatis.plus.commons.entity.vo.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author yuane
 * @date 2019/7/13 1:25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserVo extends BaseVo {
    @NotNull(message = "用户名不能为空", groups = InsertValidator.class)
    @Range(min = 1, max = 20, message = "用户名在1到20位之间", groups = InsertValidator.class)
    private String username;
    @NotNull(message = "密码不能为空", groups = {InsertValidator.class, UpdateValidator.class})
    @Range(min = 1, max = 20, message = "密码在1到20位之间", groups = {InsertValidator.class, UpdateValidator.class})
    private String password;
    @NotNull(message = "姓名不能为空", groups = {InsertValidator.class, UpdateValidator.class})
    @Range(min = 1, max = 20, message = "姓名在1到20位之间", groups = {InsertValidator.class, UpdateValidator.class})
    private String name;

    public SysUser convert() {
        return new SysUser(username, password, name);
    }
}
