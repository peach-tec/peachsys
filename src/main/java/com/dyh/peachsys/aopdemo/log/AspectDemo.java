package com.dyh.peachsys.aopdemo.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Peach-華
 * @version V1.0
 * @desc aop实现前面编程
 * @copyright &copy; DYH
 * @date 2020/6/16-22:21
 * @address 成都
 */
@Component
@Aspect//标注切面类
public class AspectDemo {
    /**
     * 前置增强的方法
     * UserServiceImpl下面的所有方法在执行前都先执行这个方法
     */
    @Before("execution(* com.dyh.peachsys.aopdemo.service.impl.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("==========方法执行前============");
    }

    /**
     * 后置增强
     */
    @After("execution(* com.dyh.peachsys.aopdemo.service.impl.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("=======后置增强=====");
    }

    /**
     * 环绕增强
     */
//    @Around("execution(* com.dyh.peachsys.aopdemo.service.impl.UserServiceImpl.*(..))")
    public void around(){
        System.out.println("=========环绕增强======");
    }


}
