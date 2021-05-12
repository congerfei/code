package com.xl.admin.consumer.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xl.admin.consumer.entity.TUser;
import com.xl.admin.consumer.mapper.TUserMapper;
import com.xl.admin.consumer.service.impl.TUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.*;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @Autowired
    TUserServiceImpl userService;

    @Resource
    TUserMapper tUserMapper;

    @Test
    public void contextLoads() {


    }

    @Test
    public void select() {
        TUser byId = userService.getById("1");
        System.out.println(byId);
    }

    @Test
    public void insert() {
        TUser tUser = new TUser();
        tUser.setLgcSn(UUID.randomUUID().toString());
        tUser.setCreateDt(new Date());
        tUser.setUserId("14201000000");
        tUser.setUserName("湖北");
        boolean save = userService.save(tUser);
        System.out.println("是否保存成功：" + save);
    }

    @Test
    public void insertBatch() {
        for (int i = 0; i < 100; i++) {
            TUser tUser = new TUser();
            tUser.setLgcSn(UUID.randomUUID().toString());
            tUser.setCreateDt(new Date());
            tUser.setUserId(14201000000L + i + "");
            tUser.setUserName("湖北" + i);
            boolean save = userService.save(tUser);
        }


    }


    /**
     * 逻辑删除，使用逻辑删除之前要将数据delered字段全部刷城0--和yml中的配置一致即可
     */
    @Test
    public void delete() {
        int i = tUserMapper.deleteById("d11ded65-8b0d-4f18-9a42-788915c50e8a");//默认是更新操作UPDATE T_USER SET deleted=1 WHERE LGC_SN='d11ded65-8b0d-4f18-9a42-788915c50e8a' AND deleted=0
        Assert.state(i == 1, "删除失败");

    }

    /**
     * 测试分页
     */
    @Test
    public void pageTest() {
        Page<TUser> page = new Page<>(1, 10);
        Page<TUser> tUserPage = tUserMapper.selectPage(page, null);
        System.out.println(tUserPage.getRecords());
    }

    /**
     * 带条件的分页查询
     */
    @Test
    public void pageTest2() {
        Page<TUser> page = new Page<>(1, 10);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("deleted", 1);
        Page<TUser> tUserPage = tUserMapper.selectPage(page, queryWrapper);
        System.out.println(tUserPage.getRecords());
    }

    /**
     * 条件构造器
     */
    @Test
    public void allEqTest() {
        QueryWrapper queryWrapper = new QueryWrapper();
        Map<String, Object> map = new HashMap<>();
        //一定要用数据库字段名，测试oracle 是不分大小写的
        map.put("ISER_ID", "14201000000");
        map.put("USER_NAME", "湖北");
        queryWrapper.allEq(map);

        List list = tUserMapper.selectList(queryWrapper);
        for (int i = 0; i < list.size(); i++) {
            TUser tUser = (TUser) list.get(i);
            System.out.println(tUser.toString());
        }
    }


}
