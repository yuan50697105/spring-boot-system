package com.yuan.spring.boot.test.app1.modules.system.entity.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuane
 * @date 2019/7/19 21:55
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends AbstractEntity {
    @Excel(name = "账户名")
    private String username;
    @ExcelIgnore
    private String password;
    @Excel(name = "用户名")
    private String name;
    @Excel(name = "用户名全拼")
    private String nameSpellFull;
    @Excel(name = "用户名简拼")
    private String nameSpellSimple;
    private Integer enabled;

    public SysUser() {
    }

    public SysUser(String username, String password, String name, String nameSpellFull, String nameSpellSimple) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nameSpellFull = nameSpellFull;
        this.nameSpellSimple = nameSpellSimple;
    }

    public SysUser(Long id, String username, String password, String name, String nameSpellFull, String nameSpellSimple) {
        super(id);
        this.username = username;
        this.password = password;
        this.name = name;
        this.nameSpellFull = nameSpellFull;
        this.nameSpellSimple = nameSpellSimple;
    }
}
