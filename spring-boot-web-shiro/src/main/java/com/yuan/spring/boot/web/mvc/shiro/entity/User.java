package com.yuan.spring.boot.web.mvc.shiro.entity;

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
