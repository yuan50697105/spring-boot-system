package com.yuan.spring.boot.web.mvc.shiro.service;

import com.yuan.spring.boot.web.mvc.shiro.entity.Permission;

import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 12:48
 **/
public interface PermissionService {
    List<Permission> getPermissionList(Permission permission);
}
