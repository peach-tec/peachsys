package com.dyh.peachsys.spring_security_demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Peach-華
 * @version V1.0
 * @desc Security 配置
 * @copyright &copy; DYH
 * @date 2020/7/7-21:19
 * @address 成都
 */
@EnableWebSecurity //开启security
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //添加访问权限，请求的授权规则
        http.authorizeRequests()
                .antMatchers("/security/test1").permitAll() ///security/test1允许所有人访问
                .antMatchers("/security/test2").hasRole("vip1") //用户拥有权限次才能访问
                .antMatchers("/security/test3").hasRole("vip2") //用户拥有权限次才能访问
                .antMatchers("/security/test4").hasRole("vip3") //用户拥有权限次才能访问
                .antMatchers("/security/test5").hasRole("vip4");//用户拥有权限次才能访问

        //没有权限自动跳转到登录界面
        http.formLogin();

        //关闭csrf功能(不关闭可能会导致登出失败)
        http.csrf().disable();

        //开启注销功能，请求/logout
        http.logout();

        //开启记住我功能
        http.rememberMe();
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存在授权，直接将用户存在内存中，因为我还没去设计数据库,jdbcAuthentication 数据库授权
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin1").password(new BCryptPasswordEncoder().encode("root1")).roles("vip1")
                .and()//开始拼接下一个
                .withUser("admin2").password(new BCryptPasswordEncoder().encode("root2")).roles("vip2")
                .and()//开始拼接下一个
                .withUser("admin3").password(new BCryptPasswordEncoder().encode("root3")).roles("vip3")
                .and()//开始拼接下一个
                .withUser("admin4").password(new BCryptPasswordEncoder().encode("root4")).roles("vip4");
    }
}
