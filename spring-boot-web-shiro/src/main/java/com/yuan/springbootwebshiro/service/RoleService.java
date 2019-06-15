package com.yuan.springbootwebshiro.service;

import com.yuan.springbootwebshiro.entity.Role;

import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 12:47
 **/
public interface RoleService {
    List<Role> getRoleList(Role role);
}
