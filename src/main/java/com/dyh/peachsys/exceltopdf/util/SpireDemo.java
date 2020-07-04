package com.dyh.peachsys.exceltopdf.util;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/29-16:05
 * @address 成都
 */
public class SpireDemo {
    public static void pdfToHtml(){
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("test.pdf");
        pdf.saveToFile("ToHTML.html", FileFormat.HTML);
    }

    public static void main(String[] args) {
        pdfToHtml();
    }
}
