package com.yuan.springbootwebjdbc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

/**
 * @author yuane
 * @date 2019/6/8 17:34
 **/
@Data
public class User {
    @Id
    @Column(value = "id")
    private String id;
    @Column(value = "name")
    private String name;
}
