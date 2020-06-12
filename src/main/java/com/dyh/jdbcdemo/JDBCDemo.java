package com.dyh.jdbcdemo;


import com.dyh.entity.JDBCEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

/**
 * @author Peach-華
 * @version V1.0
 * @desc jdbc 演示示例
 * @copyright &copy; DYH
 * @date 2020/6/10-21:50
 * @address 成都
 */
@RestController
public class JDBCDemo {
    @Autowired
    private JDBCEntity jdbc;

    private void jdbcTest() throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName(jdbc.getDbDriver());
        //连接成功，创建数据库对象
        Connection connection = DriverManager.getConnection(jdbc.getDbUrl(), jdbc.getDbUsername(), jdbc.getDbPassword());
        //创建执行sql的对象
        Statement statement = connection.createStatement();
        //执行sql语句
        ResultSet resultSet = statement.executeQuery("select * from user");
        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("age=" + resultSet.getObject("age"));
            System.out.println("email=" + resultSet.getObject("email"));
        }
        //释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new JDBCDemo().jdbcTest();
    }
}
