package com.yuan.springbootwebshiro.service.impl;

import com.yuan.springbootwebshiro.entity.Permission;
import com.yuan.springbootwebshiro.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 12:48
 **/
@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {
    @Override
    public List<Permission> getPermissionList(Permission permission) {
        permission.setId("aaaa");
        permission.setName("nnnnnn");
        log.info(String.format("当前权限为 $s ", permission.getName()));
        return Collections.singletonList(permission);
    }
}
