package com.yuan.spring.boot.web.mvc.shiro.jwt.utils;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author yuane
 * @date 2019/7/2 21:50
 **/
public class JwtRealm extends AuthorizingRealm {
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("————权限认证————");
        String username = JWTUtils.getUsername(principals.toString());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 此处最好使用缓存提升速度
//        UserInfo userInfo = userInfoMapper.selectByName(username);
//        userInfo = userInfoMapper.selectUserOfRole(userInfo.getUid());
//        if (userInfo == null || userInfo.getRoleList().isEmpty()) {
//            return authorizationInfo;
//        }
//        for (Role role : userInfo.getRoleList()) {
//            authorizationInfo.addRole(role.getRole());
//            role = roleMapper.selectRoleOfPerm(role.getId());
//            if (role == null || role.getPermissions().isEmpty()) {
//                continue;
//            }
//            for (Permission p : role.getPermissions()) {
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
//        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtils.getUsername(token);
        if (username == null || !JWTUtils.verify(token, username)) {
            throw new AuthenticationException("token认证失败！");
        }
//        UserInfo userInfo = userInfoMapper.selectByName(username);
//        if (userInfo == null) {
//            throw new AuthenticationException("该用户不存在！");
//        }
//        if (userInfo.getState() == 1) {
//            throw new AuthenticationException("该用户已被封号！");
//        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }
}
