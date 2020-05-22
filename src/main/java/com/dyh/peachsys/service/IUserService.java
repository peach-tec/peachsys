package com.dyh.peachsys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dyh.peachsys.entity.User;

import java.util.List;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/5/12-21:38
 * @address 成都
 */
public interface IUserService extends IService<User> {
    List<User> getAll();
}
