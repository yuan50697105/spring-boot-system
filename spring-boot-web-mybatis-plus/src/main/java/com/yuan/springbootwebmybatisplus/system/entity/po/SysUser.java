package com.yuan.springbootwebmybatisplus.system.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.springbootwebmybatisplus.commons.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/6/20 22:51
 **/
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
@Data
public class SysUser extends BasePo {
    private String username;
    private String password;
    private String name;
    private String nameSpellSimple;
    private String nameSpellFull;
    private Integer enabled;
}
