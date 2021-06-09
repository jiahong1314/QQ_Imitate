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

	// ���山����Ҫ�����

	JLabel jbl1;

	// �����в���Ҫ�����
	// .�в�������JPanel,��һ����ѡ����ڹ���
	JTabbedPane jtp;
	JPanel jp2;
	JLabel jp2_jbl1, jp2_jbl2;
	JButton jp2_jb1;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1, jp2_jcb2;
	// �����ϲ���Ҫ�����
	JPanel jp1;
	JButton jp1_jb1, jp1_jb2, jp1_jb3;

	public HongClientLogin() {
		// ������
		jbl1 = new JLabel(new ImageIcon("image/qq.png"));

		// �����в�
		jp2 = new JPanel(new GridLayout(2, 2));

		jp2_jbl1 = new JLabel("QQ����", JLabel.CENTER);
		jp2_jbl2 = new JLabel("QQ����", JLabel.CENTER);
		jp2_jb1 = new JButton(new ImageIcon("image/clear.gif"));
		jp2_jtf = new JTextField();
		jp2_jpf = new JPasswordField();

		// �ѿؼ�����˳����뵽jp2
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jb1);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		// ����ѡ�����
		jtp = new JTabbedPane();
		jtp.add("QQ����", jp2);

		// �����ϲ�
		jp1 = new JPanel();
		jp1_jb1 = new JButton(new ImageIcon("image/denglu.gif"));
		// ��Ӧ�û������¼
		jp1_jb1.addActionListener(this);
		jp1_jb2 = new JButton(new ImageIcon("image/quxiao.gif"));
		// ��������ť���뵽jp1
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
				JOptionPane.showMessageDialog(this, "�û������������");
			}
		}
	}

}
