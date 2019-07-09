package com.yuan.spring.boot.web.mvc.shiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yuane
 * @date 2019/6/15 13:27
 **/
@ControllerAdvice
@Controller
@Slf4j
public class LoginController {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        e.printStackTrace();
        return e.getMessage();
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(String username, String password) {
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(usernamePasswordToken);
            log.info(String.format("%s登录成功", username));
            return "登录成功";
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }
    }
}
