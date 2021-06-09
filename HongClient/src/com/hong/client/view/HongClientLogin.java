package com.hong.client.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.hong.client.model.HongClientUser;
import com.hong.common.User;

public class HongClientLogin extends JFrame implements ActionListener {

	// 定义北部需要的组件

	JLabel jbl1;

	// 定义中部需要的组件
	// .中部有三个JPanel,有一个叫选项卡窗口管理
	JTabbedPane jtp;
	JPanel jp2;
	JLabel jp2_jbl1, jp2_jbl2;
	JButton jp2_jb1;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1, jp2_jcb2;
	// 定义南部需要的组件
	JPanel jp1;
	JButton jp1_jb1, jp1_jb2, jp1_jb3;

	public HongClientLogin() {
		// 处理北部
		jbl1 = new JLabel(new ImageIcon("image/qq.png"));

		// 处理中部
		jp2 = new JPanel(new GridLayout(2, 2));

		jp2_jbl1 = new JLabel("QQ号码", JLabel.CENTER);
		jp2_jbl2 = new JLabel("QQ密码", JLabel.CENTER);
		jp2_jb1 = new JButton(new ImageIcon("image/clear.gif"));
		jp2_jtf = new JTextField();
		jp2_jpf = new JPasswordField();

		// 把控件按照顺序加入到jp2
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jb1);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		// 创建选项卡窗口
		jtp = new JTabbedPane();
		jtp.add("QQ号码", jp2);

		// 处理南部
		jp1 = new JPanel();
		jp1_jb1 = new JButton(new ImageIcon("image/denglu.gif"));
		// 响应用户点击登录
		jp1_jb1.addActionListener(this);
		jp1_jb2 = new JButton(new ImageIcon("image/quxiao.gif"));
		// 把三个按钮放入到jp1
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		this.add(jbl1, "North");
		this.setSize(430, 280);
		this.add(jtp, "Center");
		this.add(jp1, "South");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp2_jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp2_jtf.setText("");

			}
		});
		this.setVisible(true);
	}

	public static void main(String[] args) {
		HongClientLogin hClientLogin = new HongClientLogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jp1_jb1) {
			HongClientUser hUser = new HongClientUser();
			User user = new User();
			user.setUserId(jp2_jtf.getText().trim());
			user.setPassword(new String(jp2_jpf.getPassword()));

			if (hUser.CheckUser(user)) {
				new HongFriend(user.getUserId());
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
			}
		}
	}

}
