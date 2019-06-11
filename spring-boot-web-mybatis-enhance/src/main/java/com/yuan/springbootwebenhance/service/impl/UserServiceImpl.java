package com.yuan.springbootwebenhance.service.impl;

import com.yuan.springbootwebenhance.entity.User;
import com.yuan.springbootwebenhance.mapper.UserMapper;
import com.yuan.springbootwebenhance.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author yuane
 * @date 2019/6/10 23:18
 **/
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void insert(User user) {
        userMapper.insertCollection(Collections.singletonList(user));
    }
}
