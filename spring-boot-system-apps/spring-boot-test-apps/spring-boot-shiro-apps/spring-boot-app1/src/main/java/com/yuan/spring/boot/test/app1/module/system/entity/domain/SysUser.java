package com.yuan.spring.boot.test.app1.module.system.entity.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.yuan.spring.boot.test.app1.module.commons.entity.domain.BaseEntity;
import com.yuan.spring.boot.test.app1.module.system.entity.validator.SaveValid;
import com.yuan.spring.boot.test.app1.module.system.entity.validator.UpdateValid;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author yuane
 * @date 2019/7/21 22:49
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sys_user")
@Data
public class SysUser extends BaseEntity {
    @Excel(name = "用户名")
    @NotNull(message = "不能为空", groups = SaveValid.class)
    @Column(name = "username", updatable = false)
    private String username;
    @NotNull(message = "不能为空", groups = {SaveValid.class, UpdateValid.class})
    @Column(name = "password")
    @ExcelIgnore
    private String password;
    @Excel(name = "姓名")
    @NotNull(message = "不能为空", groups = {SaveValid.class, UpdateValid.class})
    @Column(name = "name")
    private String name;
    @Column(name = "name_spell_full")
    private String nameSpellFull;
    @Column(name = "name_spell_simple")
    private String nameSpellSimple;

}
