package com.dyh.peachsys.spring_shiro_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dyh.peachsys.spring_shiro_demo.entity.SysUser;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/9-21:26
 * @address 成都
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 通过手机号码获取用户
     * @param phone
     * @return
     */
    SysUser getSysUserByPhone(String phone);
}
