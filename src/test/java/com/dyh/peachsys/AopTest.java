package com.dyh.peachsys;

import com.dyh.peachsys.aopdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/17-20:29
 * @address 成都
 */
@SpringBootTest
public class AopTest {
    @Autowired
    private UserService userService;

    @Test
    public void aopTest(){
        userService.add();
    }
}
