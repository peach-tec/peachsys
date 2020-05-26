package com.dyh.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解演示代码
 * 创建类的时候选择annotation
 * 下面四个称为元注解
 */
@Target(value = ElementType.METHOD)//定义注解的使用范围(方法、类、包、字段等范围)
@Retention(value = RetentionPolicy.RUNTIME)//注解的声明周期，在什么地方有效(源码SOURCE、编译文件CLASS、运行时RUNTIME，三种)
@Documented//将注解生成在java doc中
@Inherited//子类可以继承父类的该注解
public @interface MyAnnotation {
    /**
     * 注解的参数
     * 如果注解没有default，使用时必须加上name属性
     * default设置默认值
     * 属性为value时使用时可以省略属性字段不写
     * @return
     */
    String value() default "";
}
