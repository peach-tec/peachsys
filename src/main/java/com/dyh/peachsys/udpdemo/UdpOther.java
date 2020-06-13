package com.dyh.peachsys.udpdemo;

/**
 * @author Peach-華
 * @version V1.0
 * @desc    udp接收
 * @copyright &copy; DYH
 * @date 2020/5/25-20:01
 * @address 成都
 */
public class UdpOther {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"localhost",9999)).start();
        new Thread(new TalkReceive(8888,"老师")).start();
    }
}
