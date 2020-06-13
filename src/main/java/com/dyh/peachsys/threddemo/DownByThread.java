package com.dyh.peachsys.threddemo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Peach-華
 * @version V1.0
 * @desc 通过线程下载
 * @copyright &copy; DYH
 * @date 2020/5/25-20:55
 * @address 成都
 */
//通过实现接口
public class DownByThread implements Runnable {
    private String url;
    private String fileName;

    public DownByThread(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fileName));//需要导入"commons-io"的jar包
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590422269759&di=ad7ad9448d2e4ae4191235eaab6921ec&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F14%2F75%2F01300000164186121366756803686.jpg";

        new Thread(new DownByThread(url,"86.jpg")).start();
    }
}


//通过继承实现线程
//public class DownByThread extends Thread {
//    private String url;//网路资源的路径
//    private String fileName;//文件名
//
//    public DownByThread(String url, String fileName) {
//        this.url = url;
//        this.fileName = fileName;
//    }
//
//    @Override
//    public void run() {
//        DownLoader downLoader = new DownLoader();
//        downLoader.downLoader(url, fileName);
//    }
//
//    public static void main(String[] args) {
//        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590422269759&di=ad7ad9448d2e4ae4191235eaab6921ec&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F14%2F75%2F01300000164186121366756803686.jpg";
//        new DownByThread(url,"86.jpg").start();
//    }
//}
//
///**
// * 下载器
// */
//class DownLoader {
//    /**
//     * 将网络资源下载为文件
//     *
//     * @param url      网路资源的路径
//     * @param fileName 文件名
//     */
//    public void downLoader(String url, String fileName) {
//        try {
//            FileUtils.copyURLToFile(new URL(url), new File(fileName));//需要导入"commons-io"的jar包
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
