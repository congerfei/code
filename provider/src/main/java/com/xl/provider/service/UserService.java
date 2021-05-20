package com.xl.provider.service;

import com.xl.provider.pojo.User;

public interface UserService {


    int insert(User user);

    User selectUserById(String id);

}
