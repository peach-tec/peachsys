package com.dyh.peachsys.spring_shiro_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyh.peachsys.spring_shiro_demo.entity.SysUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/9-21:25
 * @address 成都
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("select * from sys_user where mobile = #{phone}")
    SysUser getSysUserByPhone(String phone);
}
