package com.xl.admin;



import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class AdminApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    void contextLoads() {


    }

    /**
     * 测试数据源是否配置成功
     * 由之前的驱动换成了p6spy驱动，---用于打印执行sql
     */
    @Test
    public void dataSourceTest() {
        System.out.println("数据源：" + dataSource);
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
