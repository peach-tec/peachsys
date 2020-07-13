package com.dyh.peachsys.spring_task.controller;

import com.dyh.peachsys.spring_task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/12-21:41
 * @address 成都
 */
@RestController
public class TaskApi {
    @Autowired
    private TaskService taskService;

    @GetMapping("/async/test")
    public String asyncTest() throws InterruptedException {
        taskService.asyncTest();
        System.out.println("执行结束...." + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return "执行结束...." + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void scheduleTest(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ": debug==>正在执行....");
    }
}
