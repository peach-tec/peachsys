package com.dyh.peachsys.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Peach-華
 * @version V1.0
 * @desc 主页跳转
 * @copyright &copy; DYH
 * @date 2020/6/29-9:37
 * @address 成都
 */
@Controller
public class HomeApi {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/upload")
    public String upload() {
        return "upload";
    }

    @RequestMapping("/arting365")
    public String arting365(){
        return "arting365";
    }
}
