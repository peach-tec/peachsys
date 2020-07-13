package com.dyh.peachsys;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * spring boot的启动类
 */
@EnableScheduling //开启定时任务
@EnableAsync // 开启异步任务
@SpringBootApplication//引导类
@MapperScan({"com.dyh.peachsys.peach.mapper","com.dyh.peachsys.mybatisdemo.mapper","com.dyh.peachsys.xizudemo.mapper","com.dyh.peachsys.spring_shiro_demo.mapper"})//扫描mapper文件
//@MapperScan({"mapper1,mapper2..."})//扫描多个mapper
public class PeachsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeachsysApplication.class, args);
    }

    /**
     * 设置上传文件大小
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件上传大小
        factory.setMaxFileSize(DataSize.ofMegabytes(10485760*5));
        //总文件上传大小
        factory.setMaxRequestSize(DataSize.ofMegabytes(10485760*10));
        return factory.createMultipartConfig();
    }
}
