package com.xl.provider.mapper;

import com.xl.provider.pojo.User;

public interface UserMapper {

    int insert(User user);

    User selectUserById(String id);



}
