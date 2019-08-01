package com.yuan.spring.app1.modules.system.entity.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.spring.app1.modules.commons.entity.domain.BaseEntity;
import com.yuan.spring.boot.utils.SpellUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/8/1 18:50
 **/
@TableName("sys_resource")
@EqualsAndHashCode(callSuper = true)
@Data
public class SysResource extends BaseEntity {
    private String name;
    private String nameSpellFull;
    private String nameSpellSimple;
    private String content;
    private String url;
    private String icon;
    private String parent;

    public SysResource() {

    }

    public SysResource(String id) {
        super(id);
    }

    public SysResource(String name, String content, String url, String icon, String parent) {
        this.name = name;
        this.nameSpellFull = SpellUtils.getSpell(name);
        this.nameSpellSimple = SpellUtils.getFirstSpell(name);
        this.content = content;
        this.url = url;
        this.icon = icon;
        this.parent = parent;
    }

    public SysResource(String id, String[] ids, String createBy, String updateBy, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd, String name, String content, String url, String icon, String parent) {
        super(id, ids, createBy, updateBy, createDate, updateDate, createDateStart, createDateEnd, updateDateStart, updateDateEnd);
        this.name = name;
        this.content = content;
        this.url = url;
        this.icon = icon;
        this.parent = parent;
    }
}
