package com.dyh.peachsys.spring_security_demo.controller;

import com.dyh.peachsys.peach.common.Res;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Peach-華
 * @version V1.0
 * @desc 测试接口
 * @copyright &copy; DYH
 * @date 2020/7/7-21:25
 * @address 成都
 */

/**
 * 测试接口
 * 通过权限设置访问接口
 */
@RestController
@RequestMapping("/security")
public class SecurityApi {

    @GetMapping("/test1")
    public Res test1() {
        return Res.success("test1....");
    }

    @GetMapping("/test2")
    public Res test2() {
        return Res.success("test2....");
    }

    @GetMapping("/test3")
    public Res test3() {
        return Res.success("test3....");
    }

    @GetMapping("/test4")
    public Res test4() {
        return Res.success("test4....");
    }
    @GetMapping("/test5")
    public Res test5() {
        return Res.success("test5....");
    }
}
