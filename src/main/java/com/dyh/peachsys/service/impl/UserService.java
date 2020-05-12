package com.dyh.peachsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyh.peachsys.entity.User;
import com.dyh.peachsys.mapper.UserMapper;
import com.dyh.peachsys.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/5/12-21:42
 * @address 成都
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
}
