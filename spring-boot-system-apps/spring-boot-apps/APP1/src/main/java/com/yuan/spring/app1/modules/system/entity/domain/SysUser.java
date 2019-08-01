package com.yuan.spring.app1.modules.system.entity.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.app1.modules.commons.entity.domain.BaseEntity;
import com.yuan.spring.boot.utils.SpellUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/27 11:01
 **/
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends BaseEntity {
    private String username;
    private String password;
    private String name;
    private String nameSpellFull;
    private String nameSpellSimple;
    private Integer enabled;

    public SysUser() {
    }

    public SysUser(String id) {
        super(id);
    }

    public SysUser(String username, String password, String name, Integer enabled) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nameSpellFull = SpellUtils.getSpell(name);
        this.nameSpellSimple = SpellUtils.getFirstSpell(name);
        this.enabled = enabled;
    }

    public SysUser(String id, String[] ids, String createBy, String updateBy, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String username, String password, String name, String nameSpellFull, String nameSpellSimple, Integer enabled) {
        super(id, ids, createBy, updateBy, createDate, updateDate, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.username = username;
        this.password = password;
        this.name = name;
        this.nameSpellFull = nameSpellFull;
        this.nameSpellSimple = nameSpellSimple;
        this.enabled = enabled;
    }
}
