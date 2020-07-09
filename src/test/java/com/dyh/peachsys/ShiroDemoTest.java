package com.dyh.peachsys;

import com.dyh.peachsys.spring_shiro_demo.entity.SysUser;
import com.dyh.peachsys.spring_shiro_demo.service.ISysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/9-21:34
 * @address 成都
 */
@SpringBootTest
public class ShiroDemoTest {
    @Autowired
    private ISysUserService userService;

    @Test
    public void userTest() {
        SysUser user = userService.getSysUserByPhone("18482133793");
        System.out.println(user.toString());
    }
}
