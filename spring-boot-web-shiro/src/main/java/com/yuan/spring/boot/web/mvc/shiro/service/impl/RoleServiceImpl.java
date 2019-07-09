package com.yuan.spring.boot.web.mvc.shiro.service.impl;

import com.yuan.spring.boot.web.mvc.shiro.entity.Role;
import com.yuan.spring.boot.web.mvc.shiro.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 12:47
 **/
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Override
    public List<Role> getRoleList(Role role) {
        role.setId("aaa");
        role.setName("aaaaaa");
        log.info(String.format("当前角色为：%s", role.getName()));
        return Collections.singletonList(role);
    }
}
