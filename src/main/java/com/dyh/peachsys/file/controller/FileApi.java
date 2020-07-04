package com.dyh.peachsys.file.controller;

import com.dyh.peachsys.peach.common.Res;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

        File dest = new File(path + fileName);

        file.transferTo(dest);

        return Res.success(path + fileName);
    }
}
