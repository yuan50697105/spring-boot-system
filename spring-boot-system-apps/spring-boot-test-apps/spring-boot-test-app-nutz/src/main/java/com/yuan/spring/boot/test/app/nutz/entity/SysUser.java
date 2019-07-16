package com.yuan.spring.boot.test.app.nutz.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.io.Serializable;

@Table(value = "sys_user")
public class SysUser implements Serializable {
    @Id
    private String id;
    @Column("username")
    private String username;
    @Column("name")
    private String name;
}
