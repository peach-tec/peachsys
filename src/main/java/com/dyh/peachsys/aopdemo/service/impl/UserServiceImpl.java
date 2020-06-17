package com.dyh.peachsys.aopdemo.service.impl;

import com.dyh.peachsys.aopdemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/16-22:19
 * @address 成都
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("执行了add方法");
    }

    @Override
    public void delete() {
        System.out.println("执行了delete方法");
    }

    @Override
    public void update() {
        System.out.println("执行了update方法");
    }

    @Override
    public void select() {
        System.out.println("执行了select方法");
    }
}
