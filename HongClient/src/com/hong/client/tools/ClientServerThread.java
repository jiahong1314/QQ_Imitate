package com.hong.client.tools;

import java.io.ObjectInputStream;
import java.net.Socket;

import com.hong.client.view.HongChat;
import com.hong.common.Message;

public class ClientServerThread extends Thread {

	private Socket socket;

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ClientServerThread(Socket s) {
		this.socket = s;
	}

	public void run() {

		while (true) {

			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message message = (Message) ois.readObject();
				System.out.println(message.getSender() + "¸ø" + message.getGetter() + "·¢ËÍÁË" + message.getCon());
				HongChat hongChat = ManageQq.getQqChat(message.getGetter() + " " + message.getSender());
				hongChat.showMessage(message);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
