package com.yuan.springbootwebmapper.commons.entity.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/15 22:47
 **/
@Data
@MappedSuperclass
public class BasePo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
}
