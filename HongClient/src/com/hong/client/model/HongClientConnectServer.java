package com.hong.client.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.hong.client.tools.ClientServerThread;
import com.hong.client.tools.ManageClientThread;
import com.hong.common.Message;
import com.hong.common.User;

//连接服务器
public class HongClientConnectServer {

	public Socket s;

	// 发送第一次请求
	public boolean sendLoginInfoToServer(Object o) {
		boolean b = false;
		try {
			// System.out.println("kk");
			s = new Socket("127.0.0.1", 9999);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);

			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message ms = (Message) ois.readObject();
			User user = (User) o;
			// 1:验证正确
			// 2:群聊信息
			if (ms.getMesType().equals("1")) {
				ClientServerThread cst = new ClientServerThread(s);
				ManageClientThread.setThread(user.getUserId(), cst);
				cst.start();
				b = true;
			} else {
				s.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {

		}
		return b;
	}

	public void SendInfoToServer(Object o) {
		/*
		 * try { Socket s=new Socket("127.0.0.1",9999);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); // TODO: handle exception
		 * }finally{
		 * 
		 * }
		 */
	}

}
