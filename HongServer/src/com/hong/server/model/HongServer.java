package com.hong.server.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.hong.common.Message;
import com.hong.common.User;
import com.hong.server.db.dbUtil;

public class HongServer {

	public HongServer() {
		try {

			System.out.println("我是服务器，在9999监听");
			ServerSocket ss = new ServerSocket(9999);
			while (true) {
				Socket socket = ss.accept();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				User user = (User) ois.readObject();
				Message message = new Message();
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				User userActual = new dbUtil().getUser(user.getUserId());
				if (user.getPassword().equals(userActual.getPassword())) {
					System.out.println("用户" + user.getUserId() + "密码" + user.getPassword());
					message.setMesType("1");
					oos.writeObject(message);

					ServerClientThread sClientThread = new ServerClientThread(socket);
					ManageClientThread.addClientThread(user.getUserId(), sClientThread);
					sClientThread.start();

				} else {
					message.setMesType("2");
					oos.writeObject(message);
					socket.close();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {

		}
	}
}
