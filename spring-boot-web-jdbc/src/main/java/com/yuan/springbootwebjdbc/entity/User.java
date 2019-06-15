package com.yuan.springbootwebjdbc.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author yuane
 * @date 2019/6/8 17:34
 **/
@Data
public class User {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;


}
