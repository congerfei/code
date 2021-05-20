package com.xl.provider.service.impl;

import com.xl.provider.mapper.UserMapper;
import com.xl.provider.pojo.User;
import com.xl.provider.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl  implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User selectUserById(String id) {
        return userMapper.selectUserById(id);
    }
}
