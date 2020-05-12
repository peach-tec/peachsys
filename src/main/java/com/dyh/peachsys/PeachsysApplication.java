package com.dyh.peachsys;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot的启动类
 */
@SpringBootApplication//引导类
@MapperScan("com.dyh.peachsys.mapper")//扫描mapper文件
//@MapperScan({"mapper1,mapper2..."})//扫描多个mapper
public class PeachsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeachsysApplication.class, args);
    }
}
