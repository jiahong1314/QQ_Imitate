package com.hong.client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hong.client.tools.ManageClientThread;
import com.hong.common.Message;

public class HongChat extends JFrame implements ActionListener {
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	String ownerId;
	String friendId;

	public static void main(String[] args) {
		HongChat hongChat = new HongChat("1", "2");
	}

	public HongChat(String ownerId, String friend) {
		this.ownerId = ownerId;
		this.friendId = friend;
		jta = new JTextArea();
		jtf = new JTextField(15);
		jb = new JButton("发送");
		jb.addActionListener(this);
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);

		this.add(jta, "Center");
		this.add(jp, "South");
		this.setTitle(ownerId + " 正在和 " + friend + " 聊天");
		this.setIconImage((new ImageIcon("image/qq.gif").getImage()));
		this.setSize(300, 200);
		this.setVisible(true);
	}

	// 写一个方法，让它显示消息
	public void showMessage(Message m) {
		String info = m.getSender() + " :" + m.getCon() + "\r\n";
		this.jta.append(info);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == jb) {
			Message m = new Message();
			m.setSender(ownerId);
			m.setGetter(friendId);
			m.setCon(jtf.getText());
			m.setSendTime(new Date().toString());
			this.jta.append("                                                                  " + m.getCon() + "  "
					+ m.getSender() + "\r\n");
			this.jtf.setText("");
			try {
				ObjectOutputStream oos = new ObjectOutputStream(
						ManageClientThread.geThread(ownerId).getSocket().getOutputStream());
				oos.writeObject(m);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
