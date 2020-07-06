package com.dyh.peachsys.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/7/5-20:33
 * @address 成都
 */
@Controller
public class ThymeleafApi {
    @RequestMapping("/thymeleaf/test")
    public String thymeleafTest(Model model){
        model.addAttribute("msg","<h1>这是一个很牛逼的作者</h1>");
        model.addAttribute("users", Arrays.asList("张三","李四","王五"));
        return "thymeleaf";
    }
}
