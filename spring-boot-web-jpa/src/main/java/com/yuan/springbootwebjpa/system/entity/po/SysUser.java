package com.yuan.springbootwebjpa.system.entity.po;

import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/20 19:20
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sys_user")
@Data
public class SysUser extends BasePo {
    private String username;
    private String password;
    private String salt;
    private String name;
    private String nameSpellSimple;
    private String nameSpellFull;
    private Integer enabled;

    public SysUser() {
    }

    public SysUser(String username, String password, String salt, String name, String nameSpellSimple, String nameSpellFull, Integer enabled) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.name = name;
        this.nameSpellSimple = nameSpellSimple;
        this.nameSpellFull = nameSpellFull;
        this.enabled = enabled;
    }

    public SysUser(String id, Date createDate, Date updateDate, String createUser, String updateUser, String username, String password, String salt, String name, String nameSpellSimple, String nameSpellFull, Integer enabled) {
        super(id, createDate, updateDate, createUser, updateUser);
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.name = name;
        this.nameSpellSimple = nameSpellSimple;
        this.nameSpellFull = nameSpellFull;
        this.enabled = enabled;
    }
}
