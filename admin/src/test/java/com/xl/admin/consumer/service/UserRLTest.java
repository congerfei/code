package com.xl.admin.consumer.service;


import com.xl.admin.consumer.entity.TUser;
import com.xl.admin.consumer.mapper.TUserMapper;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRLTest {

    @Autowired
    TUserMapper tUserMapper;


    @Test
    public void contextLoads() {
        TUser tUser = tUserMapper.selectById("13714858284");
        System.out.println(tUser);

    }

    /**
     * 测试用户与机构的关系
     */
    @Test
    public void test1() {
        TUser tUser = tUserMapper.selectUserAndInsByUserID("13714858284");
        System.out.println(tUser);

    }
}
