package com.dyh.peachsys.spring_shiro_demo.config;

import com.dyh.peachsys.spring_shiro_demo.entity.SysUser;
import com.dyh.peachsys.spring_shiro_demo.service.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/8-20:56
 * @address 成都
 */
@Component
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private ISysUserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("/shiro/update");//授权

        //获取当前登录对象
        Subject subject = SecurityUtils.getSubject();
        SysUser currentUser = (SysUser) subject.getPrincipal();
//        info.addObjectPermission(currentUser.getPerms());//从数据库中获取权限
        return info;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        String username = "root";
//        String password = "123456";

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //从数据库中查询用户
        SysUser user = userService.getSysUserByPhone(token.getUsername());
        //用户验证
        if (user == null){
            return null;
        }
        //密码校验
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), "");

//        //用户名校验
//        if (!token.getUsername().equals(username)) {
//            return null; //抛出异常 UnknownAccountException
//        }
        //密码校验
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("", password, "");
        return info;
    }
}
