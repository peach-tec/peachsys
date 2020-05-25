package com.dyh.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author Peach-華
 * @version V1.0
 * @desc 消息接收
 * @copyright &copy; DYH
 * @date 2020/5/25-20:18
 * @address 成都
 */
public class TalkReceive implements Runnable {
    DatagramSocket socket = null;
    private Integer port;
    /**
     * 消息的来源
     */
    private String msgFrom;

    public TalkReceive(Integer port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            socket = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] container = new byte[1024];//缓冲区
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);//接收

                byte[] data = packet.getData();//获取接收的数据
                String receiceData = new String(data, 0, data.length);//将接收的数据转为字符串
                System.out.println(msgFrom + ":" + receiceData);

                if (receiceData.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
