package cn.itcast.UDP.b;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 通过多线程改进刚才的聊天程序，这样我就可以实现在一个窗口发送和接收数据了
 * @author 贤元
 *
 */
public class ChatRoom {
	public static void main(String[] args) throws SocketException {
		//发送端的Socket
		DatagramSocket dsSend = new DatagramSocket();
		//接收端的Socket
		DatagramSocket dsReceive = new DatagramSocket(12306);
		
		//创建资源
		SendThread st = new SendThread(dsSend);
		ReceiveThread rt = new ReceiveThread(dsReceive);
		
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(rt);
		
		t1.start();
		t2.start();
		
	}
}
