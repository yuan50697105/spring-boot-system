package com.yuan.springbootwebshiro.entity;

import lombok.Data;

/**
 * @author yuane
 * @date 2019/6/15 12:43
 **/

@Data
public class User {
    private String id;
    private String name;
    private String password;
    private String salt;
}
