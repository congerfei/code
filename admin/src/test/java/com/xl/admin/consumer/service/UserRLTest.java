package com.xl.admin.consumer.service;


import com.xl.admin.consumer.entity.TUser;
import com.xl.admin.consumer.mapper.TUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
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
//        TUser tUser = tUserMapper.selectUserAndInsByUserID("13714858284");
//        System.out.println(tUser);

    }
}
