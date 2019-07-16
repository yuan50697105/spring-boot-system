package com.yuan.spring.boot.test.app1.modules.system.entity.domain;

import com.yuan.spring.boot.test.app1.modules.commons.entity.domain.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yuane
 * @date 2019/7/17 0:58
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "sys_role")
public class SysRole extends AbstractEntity {
    private String name;
    private Integer enabled;

    public SysRole() {
    }

    public SysRole(String name, Integer enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    @Builder
    public SysRole(Long id, String name, Integer enabled) {
        super(id);
        this.name = name;
        this.enabled = enabled;
    }
}
