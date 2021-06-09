package com.hong.server.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.hong.common.Message;

public class ServerClientThread extends Thread {

	Socket s;

	public ServerClientThread(Socket s) {
		this.s = s;
	}

	public void run() {
		while (true) {
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message message = (Message) ois.readObject();

				// System.out.println(message.getSender() + "¸ø" + message.getGetter() + "·¢ËÍ" +
				// message.getCon());

				ServerClientThread sc = ManageClientThread.geClientThread(message.getGetter());
				ObjectOutputStream oos = new ObjectOutputStream(sc.s.getOutputStream());
				oos.writeObject(message);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
