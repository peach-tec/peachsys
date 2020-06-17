package com.dyh.peachsys.aopdemo.service;

import org.springframework.stereotype.Component;

/**
 * @author Peach-華
 * @version V1.0
 * @desc    aop接口
 * @copyright &copy; DYH
 * @date 2020/6/16-22:18
 * @address 成都
 */
@Component("userService")
public interface UserService {
    void add();
    void delete();
    void update();
    void select();
}
