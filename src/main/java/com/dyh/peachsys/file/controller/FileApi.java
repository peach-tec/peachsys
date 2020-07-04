package com.dyh.peachsys.file.controller;

import com.dyh.peachsys.peach.common.Res;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author Peach-華
 * @version V1.0
 * @desc 文件上传
 * @copyright &copy; DYH
 * @date 2020/7/4-17:09
 * @address 成都
 */
@RestController
@RequestMapping("/file")
public class FileApi {

    @PostMapping("/upload")
    public Res uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String path = "D:/filetest/";//文件保存路径
        String fileName = file.getOriginalFilename();
        if (file.isEmpty()) {
            return Res.fail("上传文件不能为空");
        }


//        File dest = new File(path + fileName);

//        file.transferTo(dest);

        return Res.success(path + fileName);
    }

    @GetMapping("/download")
    public Res download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String path = "D:/filetest";
        String fileName = "logon.jpg";

        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path, fileName);
        //读取文件输入流
        FileInputStream input = new FileInputStream(file);
        //写出文件输出流
        ServletOutputStream out = response.getOutputStream();
        byte[] buff = new byte[1024];
        int index = 0;
        while ((index = input.read(buff)) != -1) {
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();

        return Res.success();
    }
}
