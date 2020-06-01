package com.dyh.peachsys.api;

import com.baidu.ueditor.ActionEnter;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/5/29-10:29
 * @address 成都
 */
@RestController
@RequestMapping("/")
public class UEditorApi {
    public String home() {
        return "index";
    }

    @RequestMapping("/config")
    public void config(HttpServletRequest request, HttpServletResponse response, String action, MultipartFile upfile) throws IOException {
        System.out.println("正在保存文件");
        String path = "/image/20200529/1590762943597055974.jpg";
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
//        response.setHeader("Content-Type", "text/html");
//        if (action.equals("config")){
            //获取config.json所在的目录
            String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static";
            path = new ActionEnter(request, rootPath).exec();
//        }
        PrintWriter writer = response.getWriter();
        writer.write(path);
        writer.flush();
        writer.close();
    }

    @PostMapping("/post")
    public void post(){

    }
}