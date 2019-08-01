package com.yuan.spring.app1.modules.system.entity.domain;

import com.yuan.spring.app1.modules.commons.entity.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/7/30 1:06
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysPermission extends BaseEntity {
    private String name;
    private String nameSpellFull;
    private String nameSpellSimple;

    public SysPermission() {

    }

    public SysPermission(String id) {
        super(id);
    }

    public SysPermission(String name, String nameSpellFull, String nameSpellSimple) {
        this.name = name;
        this.nameSpellFull = nameSpellFull;
        this.nameSpellSimple = nameSpellSimple;
    }

    public SysPermission(String id, String[] ids, String createBy, String updateBy, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name, String nameSpellFull, String nameSpellSimple) {
        super(id, ids, createBy, updateBy, createDate, updateDate, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
        this.nameSpellFull = nameSpellFull;
        this.nameSpellSimple = nameSpellSimple;
    }
}
