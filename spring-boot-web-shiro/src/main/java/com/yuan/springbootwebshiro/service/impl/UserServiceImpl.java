package com.yuan.springbootwebshiro.service.impl;

import com.yuan.springbootwebshiro.entity.User;
import com.yuan.springbootwebshiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/6/15 12:44
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        User user1 = new User();
        user1.setName("aaaa");
        boolean equals = user.getName().equals(user1.getName());
        if (equals) {
            log.info(String.format("当前登录用户为：%s", user.getName()));
            return user1;
        } else {
            log.info(String.format("当前登录用户%s不存在", user.getName()));
            return null;
        }

    }
}
