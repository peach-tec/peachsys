package com.dyh.peachsys.peach.api;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    /**
     * 通过后端跳转到主页
     *
     * @return
     */
    public String home() {
        return "index";
    }

    /**
     * uedtior的配置和上传
     *
     * @param request
     * @param response
     * @param action   需要执行的操作，通过config.json中的imageActionName属性来执行，如果action=config，则表示执行读取config.json内容
     * @param upfile   需要上传的文件
     * @throws IOException
     */
    @RequestMapping("/config")
    public void config(HttpServletRequest request, HttpServletResponse response, String action, MultipartFile upfile) throws IOException {
        String path = null;
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        //获取config.json的路径
        if ("config".equals(action)) {
            //将config.json放在resources根目录下，用io流来读取
            //因为在导成jar包部署后获取不到config.json的路径
            ClassPathResource resource = new ClassPathResource("config.json");
            StringBuffer buffer = new StringBuffer();
            try {
                InputStreamReader reader = new InputStreamReader(resource.getInputStream(), "UTF-8");
                BufferedReader bf = new BufferedReader(reader);
                String str = null;
                while ((str = bf.readLine()) != null) {
                    buffer.append(str);
                }
                path = buffer.toString().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //可以改成调用自己的保存方法，然后返回json格式的字符串，示例：
            String testPath = "/image/20200603/1591154731689075892.jpg";//引用我本地的图片
            //这是返回的数据，需要将url字段的值改为testPath
            long size = upfile.getSize();
            String originalFilename = upfile.getOriginalFilename();
            String type = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf("."));
            String title = testPath.substring(testPath.lastIndexOf("/") + 1);
            path = "{\"state\": \"SUCCESS\"," +
                    "\"original\": \"" + originalFilename + "\"," +
                    "\"size\": \"" + size + "\"," +
                    "\"title\": \"" + title + "\"," +
                    "\"type\": \"" + type + "\"," +
                    "\"url\": \"" + testPath + "\"}";
        }
        //将返回的路径返回至ueditor
        PrintWriter writer = response.getWriter();
        writer.write(path);
        writer.flush();
        writer.close();
    }
}
