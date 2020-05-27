package com.dyh.reflection;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dyh.peachsys.entity.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Peach-華
 * @version V1.0
 * @desc 反射演示demo
 * @copyright &copy; DYH
 * @date 2020/5/26-21:16
 * @address 成都
 */
public class reflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        /**
         * 通过反射操作注解
         */
        //获得Class对象
        Class c1 = Class.forName("com.dyh.peachsys.entity.User");
        //获取所有的注解
        Annotation[] annotations = c1.getAnnotations();

        //获取注解的值(类注解)
        TableName tableId = (TableName) c1.getAnnotation(TableName.class);
        String value = tableId.value();
        System.out.println(value);

        //获取方法属性的注解
        Field id = c1.getDeclaredField("id");
        TableId annotation = id.getAnnotation(TableId.class);
        String value1 = annotation.value();
        System.out.println(annotation.value());
        System.out.println(annotation.type());
    }

    /**
     * 通过发射操作对象
     *
     * @throws Exception
     */
    private static void demo01() throws Exception {
        //获得Class对象
        Class c1 = Class.forName("com.dyh.peachsys.entity.User");
        //通过class对象构建实例
//        User user = (User) c1.newInstance();

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(Integer.class, String.class, Integer.class, String.class);
        Constructor constructor2 = c1.getDeclaredConstructor();

//        User user = (User) constructor.newInstance(12, "www", 122, "qqq");
        User user = (User) constructor2.newInstance();
        Object o = constructor2.newInstance();

        //获取类的方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //激活使用方法
        setName.invoke(user, "華");

        //通过反射操作属性
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);//取消安全检测(因为是私有属性)
        name.set(user, "华");
    }
}
