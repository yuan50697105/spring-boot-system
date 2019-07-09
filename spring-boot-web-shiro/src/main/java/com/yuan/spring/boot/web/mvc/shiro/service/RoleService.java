package com.yuan.spring.boot.web.mvc.shiro.service;

import com.yuan.spring.boot.web.mvc.shiro.entity.Role;

import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 12:47
 **/
public interface RoleService {
    List<Role> getRoleList(Role role);
}
