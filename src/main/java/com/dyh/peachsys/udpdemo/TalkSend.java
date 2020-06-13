package com.dyh.peachsys.udpdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author Peach-華
 * @version V1.0
 * @desc 消息发送
 * @copyright &copy; DYH
 * @date 2020/5/25-20:02
 * @address 成都
 */
public class TalkSend implements Runnable {
    /**
     * 建立连接对象
     */
    DatagramSocket socket = null;
    BufferedReader reader = null;
    /**
     * 接收的ip
     */
    private String toIp;
    /**
     * 发送的端口
     */
    private Integer fromport;
    /**
     * 接收的端口
     */
    private Integer toPort;

    public TalkSend(Integer fromport, String toIp, Integer toPort) {
        this.fromport = fromport;
        this.toIp = toIp;
        this.toPort = toPort;
        try {
            socket = new DatagramSocket(fromport);//建立连接
            reader = new BufferedReader(new InputStreamReader(System.in));//接收输入
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = reader.readLine();//读取输入的字符串
                byte[] datas = data.getBytes();//将字符串转换为字节数组
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIp, this.toPort));//建立通信
                socket.send(packet);//发送
                if (data.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
