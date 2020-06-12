package com.dyh.udpdemo;

/**
 * @author Peach-華
 * @version V1.0
 * @desc    udp发送
 * @copyright &copy; DYH
 * @date 2020/5/25-20:00
 * @address 成都
 */
public class UdpMe {
    public static void main(String[] args) {
        new Thread(new TalkSend(5555,"localhost",8888)).start();
        new Thread(new TalkReceive(9999,"学生")).start();
    }
}
