package cn.fancy.io.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        byte[] sendBuf = "手动阀手动阀急啊卡上的飞机喀什的肌肤卡洛斯就老是看到放假啦空手道JFK拉萨酱豆腐啊就是灯笼裤飞机上的放假啦空手道解放拉萨决定了发觉受到了放假啊塑料袋放进拉萨大家发拉萨大家发拉萨大家发是手动阀手动阀士大夫立刻就".getBytes();
        client.send(new DatagramPacket(sendBuf, sendBuf.length, InetAddress.getByName("127.0.0.1"), 6666));
        byte[] recvBuf = new byte[100];
        DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
        client.receive(recvPacket);
        String recvStr = new String(recvPacket.getData(), 0, recvPacket.getLength());
        System.out.println("收到:" + recvStr);
        client.close();
    }
}