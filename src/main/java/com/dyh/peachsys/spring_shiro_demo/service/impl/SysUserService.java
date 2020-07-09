package com.dyh.peachsys.spring_shiro_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyh.peachsys.spring_shiro_demo.entity.SysUser;
import com.dyh.peachsys.spring_shiro_demo.mapper.SysUserMapper;
import com.dyh.peachsys.spring_shiro_demo.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/9-21:26
 * @address 成都
 */
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public SysUser getSysUserByPhone(String phone) {
        SysUser user = baseMapper.getSysUserByPhone(phone);
        return user;
    }
}
