package com.dyh.peachsys.spring_shiro_demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/8-21:18
 * @address 成都
 */
@Controller
@RequestMapping("/shiro")
public class ShiroApi {

    @RequestMapping("/index")
    public String index() {
        return "shirodemo/index";
    }

    @RequestMapping("/add")
    public String add() {
        return "shirodemo/add";
    }

    @RequestMapping("/update")
    public String update() {
        return "shirodemo/update";
    }

    @RequestMapping("/to/login")
    public String toLog() {
        return "shirodemo/login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            //执行登录方法，如果没有异常就登陆成功
            subject.login(token);
            return "shirodemo/index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "unknown username");
            return "shirodemo/login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "error password");
            return "shirodemo/login";
        }
    }

    /**
     * 未授权页面
     *
     * @return
     */
    @RequestMapping("/401")
    @ResponseBody
    public String unauthorized() {
        return "未经授权，无法访问";
    }
}
