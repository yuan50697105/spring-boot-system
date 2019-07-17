package com.yuan.spring.boot.test.app1.modules.system.entity.domain;

import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yuane
 * @date 2019/7/17 0:47
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "sys_user")
public class SysUser extends AbstractEntity {
    private String username;
    private String password;
    private String name;
    @Column(name = "name_spell_simple")
    private String nameSpellSimple;
    @Column(name = "name_spell_full")
    private String nameSpellFull;
    private Integer enabled;

    public SysUser(String username, String password, String name, String nameSpellSimple, String nameSpellFull, Integer enabled) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nameSpellSimple = nameSpellSimple;
        this.nameSpellFull = nameSpellFull;
        this.enabled = enabled;
    }

    @Builder
    public SysUser(Long id, String username, String password, String name, String nameSpellSimple, String nameSpellFull, Integer enabled) {
        super(id);
        this.username = username;
        this.password = password;
        this.name = name;
        this.nameSpellSimple = nameSpellSimple;
        this.nameSpellFull = nameSpellFull;
        this.enabled = enabled;
    }
}
