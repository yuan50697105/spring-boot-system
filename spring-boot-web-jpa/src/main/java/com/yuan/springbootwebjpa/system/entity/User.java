package com.yuan.springbootwebjpa.system.entity;

import com.yuan.springbootwebjpa.commons.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yuane
 * @date 2019/6/16 1:32
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity {
    private String name;
}
