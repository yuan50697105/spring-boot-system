package com.yuan.springbootwebjpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author yuane
 * @date 2019/6/8 15:23
 **/
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "com.yuan.springbootwebjpa.utils.MyIdentifierGenerator")
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
}
