package cn.fancy.io.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(6666);
        byte[] recvBuf = new byte[100];
        DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
        server.receive(recvPacket);
        System.out.println("receiver======:" + new String(recvPacket.getData(), 0, recvPacket.getLength()));
        byte[] sendBuf = "手动阀技术老大咖啡机阿斯兰的看法解开了发四道口附近啊老师的课飞机拉萨扩大解放拉升阶段弗兰克涉及到了附件ask砥砺奋进 介绍了扩大飞机阿斯利康的飞机拉萨大家发拉萨大家发拉萨大家发了卡圣诞节分厘卡十九点零分咯技术的离开房间洛杉矶的克里夫啊就是离开的房间阿斯利康的JFK拉萨的发觉上当了".getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, recvPacket.getAddress(), recvPacket.getPort());
        server.send(sendPacket);
        server.close();
    }
}
