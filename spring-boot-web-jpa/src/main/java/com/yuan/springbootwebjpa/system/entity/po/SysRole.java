package com.yuan.springbootwebjpa.system.entity.po;

import com.yuan.springbootwebjpa.commons.entity.po.BasePo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/20 22:34
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sys_role")
@Data
public class SysRole extends BasePo {
    private String name;

    public SysRole() {
    }

    public SysRole(String name) {
        this.name = name;
    }

    @Builder
    public SysRole(String id, Date createDate, Date updateDate, String createUser, String updateUser, String name) {
        super(id, createDate, updateDate, createUser, updateUser);
        this.name = name;
    }
}
