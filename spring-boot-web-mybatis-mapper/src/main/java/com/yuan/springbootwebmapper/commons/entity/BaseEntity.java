package com.yuan.springbootwebmapper.commons.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 22:47
 **/
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    private String id;
}
