package com.dyh.peachsys.spring_task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Peach-華
 * @version V1.0
 * @desc SpringBoot任务
 * @copyright &copy; DYH
 * @date 2020/7/12-21:28
 * @address 成都
 */
@Service
public class TaskService {

    @Async //标注这个方法是异步任务
    public void asyncTest() throws InterruptedException {
        Thread.sleep(3000);//休眠3s
        System.out.println("正在执行异步任务...." + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
