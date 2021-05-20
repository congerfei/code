package com.xl.provider;

import com.xl.provider.mapper.UserMapper;
import com.xl.provider.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.UUID;

@SpringBootTest
public class ProviderApplicationTest {

    @Autowired
    DataSource dataSource;

    @Resource
    UserMapper userMapper;

    @Test
    public void test1() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void test2(){
        System.out.println(userMapper.selectUserById("14101000000"));
    }

    /**
     * 测试事务，1.事务默认开启，每执行一条sql就提交了事务，不加@Transactional，以下测试会发现加了一条到数据库了
     *          2.加了@Transactional 如果报错了，则一条都不会添加进去
     */
    @Test
    @Transactional
    public void test3(){
        int i = userMapper.insert(new User(UUID.randomUUID().toString(),"13701000000", "山东"));
        System.out.println(i);
        int a = 1/0;
        int b = userMapper.insert(new User(UUID.randomUUID().toString(),"13701000001", "山东"));

    }


}
