package com.dyh.peachsys.spring_generator_demo.service.impl;

import com.dyh.peachsys.spring_generator_demo.entity.SysUser;
import com.dyh.peachsys.spring_generator_demo.mapper.SysUserMapper;
import com.dyh.peachsys.spring_generator_demo.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author peach-D
 * @since 2020-07-17
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
