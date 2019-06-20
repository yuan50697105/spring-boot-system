package com.yuan.springbootwebjpa.system.entity.po;

import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

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
}
