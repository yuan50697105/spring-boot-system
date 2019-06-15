package com.yuan.springbootwebshiro.config;

import com.yuan.springbootwebshiro.entity.Permission;
import com.yuan.springbootwebshiro.entity.Role;
import com.yuan.springbootwebshiro.entity.User;
import com.yuan.springbootwebshiro.service.PermissionService;
import com.yuan.springbootwebshiro.service.RoleService;
import com.yuan.springbootwebshiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuane
 * @date 2019/6/15 12:43
 **/
@Component
public class MyRealm extends AuthorizingRealm {
    private final UserService userService;
    private final RoleService roleService;
    private final PermissionService permissionService;

    public MyRealm(UserService userService, RoleService roleService, PermissionService permissionService) {
        this.userService = userService;
        this.roleService = roleService;
        this.permissionService = permissionService;
    }

    /**
     * @param token
     *
     * @return
     *
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo authenticationInfo = null;
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        if (StringUtils.isEmpty(username)) {
            throw new AccountException("用户名不存在");
        } else {
            User user = new User();
            user.setName(username);
            user = userService.getUser(user);
            if (null == user) {
                throw new AccountException(String.format("%s 用户不存在", user.getName()));
            } else {
                authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), user.getName());
            }
        }
        return authenticationInfo;

    }

    /**
     * 设定权限
     *
     * @param principals
     *         role命名规范是 roles[roleName]
     *         permissio名称是 perms[roleName:permissionName]
     *
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();
        String id = user.getId();
        List<Role> roleList = roleService.getRoleList(new Role());
        List<Permission> permissionList = permissionService.getPermissionList(new Permission());
        authorizationInfo.addStringPermissions(permissionList.stream().map(Permission::getName).collect(Collectors.toList()));
        authorizationInfo.addRoles(roleList.stream().map(Role::getName).collect(Collectors.toList()));
        return authorizationInfo;
    }


}
