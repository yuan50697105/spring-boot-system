package com.yuan.springbootwebshiro.service;

import com.yuan.springbootwebshiro.entity.Permission;

import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 12:48
 **/
public interface PermissionService {
    List<Permission> getPermissionList(Permission permission);
}
