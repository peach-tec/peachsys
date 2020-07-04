package com.dyh.peachsys.exceltopdf.controller;

import com.spire.pdf.PdfDocument;
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
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
 * @desc excel换pdf
 * 官方文档：https://www.e-iceblue.cn/spirexlsjavaconversion/convert-excel-to-pdf-using-java.html
 * 安装文档：https://www.e-iceblue.cn/licensing/install-spirepdf-for-java-from-maven-repository.html
 * @copyright &copy; DYH
 * @date 2020/6/28-21:22
 * @address 成都
 */
@RestController
@RequestMapping("/excel")
public class ExcelToPDFApi {

    @PostMapping("/to/pdf")
    public void toPDF(@RequestParam("file") MultipartFile file,
                      @RequestParam("fielName") String fielName) throws IOException {
        String filePath = "G:/peachsys";//文件保存地址
        File test = new File(filePath, fielName);//文件示例，第一个参数是文件路径，第二个参数是文件名
        file.transferTo(test);//写入文件

        String name = fielName.substring(0, fielName.indexOf("."));//获取文件名，不加后缀
        //保存为pdf
        Workbook wb = new Workbook();
        wb.loadFromFile(fielName);
        wb.saveToFile(name + ".pdf", FileFormat.PDF);
    }
}
