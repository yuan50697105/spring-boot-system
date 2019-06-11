package com.yuan.springbootwebmapper.service.impl;

import com.yuan.springbootwebmapper.entity.User;
import com.yuan.springbootwebmapper.mapper.UserMapper;
import com.yuan.springbootwebmapper.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author yuane
 * @date 2019/6/10 23:20
 **/
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void insert(User user) {
        userMapper.insertList(Collections.singletonList(user));
    }
}
