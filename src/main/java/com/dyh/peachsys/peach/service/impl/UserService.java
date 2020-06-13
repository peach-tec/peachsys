package com.dyh.peachsys.peach.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyh.peachsys.peach.entity.User;
import com.dyh.peachsys.peach.mapper.UserMapper;
import com.dyh.peachsys.peach.service.IUserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    @Cacheable(value = "user")
    public List<User> getAll() {
        return baseMapper.selectList(null);
    }
}
