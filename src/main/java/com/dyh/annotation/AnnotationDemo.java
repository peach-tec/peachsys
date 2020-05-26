package com.dyh.annotation;

/**
 * @author Peach-華
 * @version V1.0
 * @desc    自定义注解的演示demo
 * @copyright &copy; DYH
 * @date 2020/5/26-20:10
 * @address 成都
 */
public class AnnotationDemo {
    @MyAnnotation("華")
    public void test() {
        System.out.println("test annotation...");
    }
}
