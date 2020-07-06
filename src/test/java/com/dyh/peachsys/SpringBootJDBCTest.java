package com.dyh.peachsys;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/6-21:03
 * @address 成都
 */
@SpringBootTest
public class SpringBootJDBCTest {
    @Autowired
    private DataSource dataSource;

    /**
     * 数据源测试
     */
    @Test
    public void datasourceTest() throws Exception {
        //查看默认数据源
        System.out.println(dataSource.getClass());
        //获取数据库连接
        Connection connection = dataSource.getConnection();
        //关闭连接
        connection.close();
    }
}
