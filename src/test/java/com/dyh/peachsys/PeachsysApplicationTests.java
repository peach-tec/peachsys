package com.dyh.peachsys;

import com.dyh.peachsys.entity.User;
import com.dyh.peachsys.service.IUserService;
import com.dyh.peachsys.util.RedisUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
class PeachsysApplicationTests {

    /**
     * redis模板对象
     * 封装了基本的方法
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IUserService userService;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void getUser(){
        /**
         * 通过注解的方式
         */
        long start = System.currentTimeMillis();
        List<User> all = userService.getAll();
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }

    @Test
    void contextLoads() {
        //存到redis中
        //存取方式对中英文在代码中影响不大
        //在可视化工具中，中文会被转义
        redisTemplate.opsForValue().set("user", "testUsername");
        redisTemplate.opsForValue().set("user2", "这个一个牛逼的作者");
        //获取redis中的数据
        System.out.println(redisTemplate.opsForValue().get("user"));
        System.out.println(redisTemplate.opsForValue().get("user2"));
    }


    @Test
    public void redisTest() {
        /**
         * 演示将从数据库回去的user存到redis中
         */
        //获取数据
        List<User> user = userService.list();
        // 通过工具保存
        // 本来是打算用list来存的
        // 但是弄了很久都没弄好
        // 所以这里建议使用json字符串来存储
        // 然后转换很方便
        boolean isTrue = redisUtil.set("user", user);

        System.out.println("是否保存成功:" + isTrue);
        //通过工具获取
        String str = redisUtil.get("user");
        List<User> users = redisUtil.toObject(str, User.class);
        for (User u : users) {
            System.out.println(u.getId());
            System.out.println(u.getName());
            System.out.println(u.getEmail());
            System.out.println(u.getAge());
        }
    }

}
