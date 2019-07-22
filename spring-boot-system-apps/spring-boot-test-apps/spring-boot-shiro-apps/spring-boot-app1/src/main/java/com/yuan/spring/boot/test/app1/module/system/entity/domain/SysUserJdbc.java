package com.yuan.spring.boot.test.app1.module.system.entity.domain;

import com.yuan.spring.boot.test.app1.module.commons.entity.domain.BaseJdbcEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yuane
 * @date 2019/7/22 18:42
 **/
@Entity
@Table(name = "sys_user")
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserJdbc extends BaseJdbcEntity {
    private String username;

}
