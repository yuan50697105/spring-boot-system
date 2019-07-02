package com.yuan.springbootshirojwt.utils;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author yuane
 * @date 2019/7/2 21:47
 **/
public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
