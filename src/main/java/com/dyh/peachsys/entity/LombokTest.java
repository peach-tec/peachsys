package com.dyh.peachsys.entity;

import lombok.*;
import lombok.extern.java.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Peach-華
 * @version V1.0
 * @desc Lombok测试实体类演示
 * @copyright &copy; DYH
 * @date 2020/5/7-18:38
 * @address 成都
 */
//@Getter(AccessLevel.PUBLIC)
//@Setter
//@ToString(exclude = {"password"})//通过exclude属性在输出时排除password字段，即在打印时不打印password
//@NoArgsConstructor//无参构造
@AllArgsConstructor//全参构造函数
//@RequiredArgsConstructor//指定构造函数，需要用@NonNull或者final去标识属性才会生成
//@EqualsAndHashCode
@Data//集成前面的注解
@Builder//构造者模式
@Log//日志，支持全部的日志组件
public class LombokTest {
    //    @Getter(AccessLevel.PRIVATE)//通过AccessLevel指定方法级别
    private Integer id;
//    @NonNull
    private String username;
//    @Setter(AccessLevel.NONE)
    private String password;

    public void test(@NonNull String str) {//通过@NonNull验证str不为空，否则会抛出空指针异常
        log.info("日志输出");//输出日志信息
        System.out.println(str);
    }

    public static void main(String[] args) throws FileNotFoundException {
        @Cleanup FileInputStream file = new FileInputStream("file");//通过@Cleanup，在使用完后自动关闭清理
        val t = new String();//在声明前不指定类型，声明后才指定类型
        LombokTest lombokTest = new LombokTest(1, "", "");
        LombokTest build = LombokTest.builder().id(1).username("").password("").build();//通过构造者模式创建对象
    }
}
