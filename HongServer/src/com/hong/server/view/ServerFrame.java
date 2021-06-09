package com.hong.server.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.hong.server.model.HongServer;

public class ServerFrame extends JFrame implements ActionListener {

	JPanel jp1;
	JButton jb1, jb2;

	public ServerFrame() {
		// TODO Auto-generated constructor stub
		jp1 = new JPanel();
		jb1 = new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2 = new JButton("关闭服务器");
		jp1.add(jb1);
		jp1.add(jb2);

		this.add(jp1);
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new ServerFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb1) {
			new HongServer();
		}
	}

}
