package com.yuan.springbootwebmybatisplus.service.impl;

import com.yuan.springbootwebmybatisplus.entity.User;
import com.yuan.springbootwebmybatisplus.mapper.UserMapper;
import com.yuan.springbootwebmybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author yuane
 * @date 2019/6/10 23:21
 **/
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
