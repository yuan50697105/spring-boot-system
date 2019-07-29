package com.yuan.spring.app1.modules.system.entity.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.app1.modules.commons.entity.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/30 0:57
 **/
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_role")
@Data
public class SysRole extends BaseEntity {
    private String name;
    private String nameSpellFull;
    private String nameSpellSimple;

    public SysRole() {
    }

    public SysRole(String id) {
        super(id);
    }

    public SysRole(String name, String nameSpellFull, String nameSpellSimple) {
        this.name = name;
        this.nameSpellFull = nameSpellFull;
        this.nameSpellSimple = nameSpellSimple;
    }

    public SysRole(String id, String createBy, String updateBy, Date createDate, Date updateDate, String name, String nameSpellFull, String nameSpellSimple) {
        super(id, createBy, updateBy, createDate, updateDate);
        this.name = name;
        this.nameSpellFull = nameSpellFull;
        this.nameSpellSimple = nameSpellSimple;
    }

    public SysRole(String id, String[] ids, String createBy, String updateBy, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name, String nameSpellFull, String nameSpellSimple) {
        super(id, ids, createBy, updateBy, createDate, updateDate, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
        this.nameSpellFull = nameSpellFull;
        this.nameSpellSimple = nameSpellSimple;
    }
}
