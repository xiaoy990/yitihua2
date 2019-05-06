package com.xiaoy.user.service.userservice.impl;

import com.xiaoy.user.entity.users.User;
import com.xiaoy.user.mapper.usermapper.UserMapper;
import com.xiaoy.user.service.userservice.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
