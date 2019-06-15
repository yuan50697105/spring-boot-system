package com.yuan.springbootwebmybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuane
 * @date 2019/6/8 16:12
 **/
@Data
public class User implements Serializable {
    private String id;
    private String name;
}
