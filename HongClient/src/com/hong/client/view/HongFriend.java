package com.hong.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.hong.client.tools.ManageQq;

public class HongFriend extends JFrame implements ActionListener, MouseListener {

	String owner;
	// 处理第一张卡片.

	JPanel jphy1, jphy2, jphy3;
	JButton jphy_jb1, jphy_jb2, jphy_jb3;
	JScrollPane jsp1;
	JLabel[] jb1s;
	// 处理第二张卡片(陌生人).

	JPanel jpmsr1, jpmsr2, jpmsr3;
	JButton jpmsr_jb1, jpmsr_jb2, jpmsr_jb3;
	JScrollPane jsp2;
	JLabel[] jb2s;

	// 黑名单
	JPanel jphmd1, jphmd2, jphmd3;
	JButton jphmd_jb1, jphmd_jb2, jphmd_jb3;
	JScrollPane jsp3;
	JLabel[] jb3s;

	// 把整个JFrame设置成CardLayout
	CardLayout cl;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// QqFriendList qqFriendList=new QqFriendList();
		HongFriend hongFriend = new HongFriend("2");
	}

	public HongFriend(String ownerId) {
		this.owner = ownerId;
		// 处理第一张卡片(显示好友列表)
		jphy_jb1 = new JButton("我的好友");
		jphy_jb2 = new JButton("陌生人");
		jphy_jb2.addActionListener(this);
		jphy_jb3 = new JButton("黑名单");
		jphy_jb3.addActionListener(this);
		jphy1 = new JPanel(new BorderLayout());
		// 假定有50个好友
		jphy2 = new JPanel(new GridLayout(50, 1, 4, 4));

		// 给jphy2，初始化50好友.
		jb1s = new JLabel[50];

		for (int i = 0; i < jb1s.length; i++) {
			jb1s[i] = new JLabel(i + 1 + "", new ImageIcon("image/mm.jpg"), JLabel.LEFT);
			jb1s[i].addMouseListener(this);
			/*
			 * jb1s[i].setEnabled(false); if (jb1s[i].getText().equals(ownerId)) {
			 * jb1s[i].setEnabled(true); } jb1s[i].addMouseListener(this);
			 */
			jphy2.add(jb1s[i]);

		}

		jphy3 = new JPanel(new GridLayout(2, 1));
		// 把两个按钮加入到jphy3
		jphy3.add(jphy_jb2);
		jphy3.add(jphy_jb3);

		jsp1 = new JScrollPane(jphy2);

		// 对jphy1,初始化
		jphy1.add(jphy_jb1, "North");
		jphy1.add(jsp1, "Center");
		jphy1.add(jphy3, "South");

		// 处理第二张卡片

		jpmsr_jb1 = new JButton("我的好友");
		jpmsr_jb1.addActionListener(this);
		jpmsr_jb2 = new JButton("陌生人");
		jpmsr_jb3 = new JButton("黑名单");
		jpmsr_jb3.addActionListener(this);
		jpmsr1 = new JPanel(new BorderLayout());
		// 假定有20个陌生人
		jpmsr2 = new JPanel(new GridLayout(20, 1, 4, 4));

		// 初始化20陌生人.
		jb2s = new JLabel[20];

		for (int i = 0; i < jb2s.length; i++) {
			jb2s[i] = new JLabel(i + 51 + "", new ImageIcon("image/mm.jpg"), JLabel.LEFT);
			jb2s[i].addMouseListener(this);
			jpmsr2.add(jb2s[i]);
		}

		jpmsr3 = new JPanel(new GridLayout(2, 1));
		// 把两个按钮加入
		jpmsr3.add(jpmsr_jb1);
		jpmsr3.add(jpmsr_jb2);

		jsp2 = new JScrollPane(jpmsr2);

		jpmsr1.add(jpmsr3, "North");
		jpmsr1.add(jsp2, "Center");
		jpmsr1.add(jpmsr_jb3, "South");

		// 处理第三张卡片

		jphmd_jb1 = new JButton("我的好友");
		jphmd_jb1.addActionListener(this);
		jphmd_jb2 = new JButton("陌生人");
		jphmd_jb2.addActionListener(this);
		jphmd_jb3 = new JButton("黑名单");
		jphmd1 = new JPanel(new BorderLayout());
		// 假定有20个陌生人
		jphmd2 = new JPanel(new GridLayout(20, 1, 4, 4));

		// 初始化20陌生人.
		jb3s = new JLabel[20];

		for (int i = 0; i < jb3s.length; i++) {
			jb3s[i] = new JLabel(i + 71 + "", new ImageIcon("image/mm.jpg"), JLabel.LEFT);
			jb3s[i].addMouseListener(this);
			jphmd2.add(jb3s[i]);
		}

		jphmd3 = new JPanel(new GridLayout(3, 1));
		// 把三个按钮加入到jphmd3
		jphmd3.add(jphmd_jb1);
		jphmd3.add(jphmd_jb2);
		jphmd3.add(jphmd_jb3);
		jsp3 = new JScrollPane(jphmd2);

		jphmd1.add(jphmd3, "North");
		jphmd1.add(jsp3, "Center");

		cl = new CardLayout();
		this.setLayout(cl);
		this.add(jphy1, "1");
		this.add(jpmsr1, "2");
		this.add(jphmd1, "3");
		// 在窗口显示自己的编号.
		this.setTitle(ownerId);
		this.setSize(340, 400);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// 如果点击了陌生人按钮，就显示第二张卡片
		if (arg0.getSource() == jphy_jb2) {
			cl.show(this.getContentPane(), "2");
		} else if (arg0.getSource() == jpmsr_jb1) {
			cl.show(this.getContentPane(), "1");
		} else if (arg0.getSource() == jphy_jb3) {
			cl.show(this.getContentPane(), "3");
		} else if (arg0.getSource() == jpmsr_jb3) {
			cl.show(this.getContentPane(), "3");
		} else if (arg0.getSource() == jphmd_jb1) {
			cl.show(this.getContentPane(), "1");
		} else if (arg0.getSource() == jphmd_jb2) {
			cl.show(this.getContentPane(), "2");
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// 响应用户双击的事件，并得到好友的编号.
		if (arg0.getClickCount() == 2) {
			// 得到该好友的编号
			String friendNo = ((JLabel) arg0.getSource()).getText();
			HongChat hongChat = new HongChat(this.owner, friendNo);

			ManageQq.addQqChat(this.owner + " " + friendNo, hongChat);

		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel) arg0.getSource();
		jl.setForeground(Color.red);
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel) arg0.getSource();
		jl.setForeground(Color.black);
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
