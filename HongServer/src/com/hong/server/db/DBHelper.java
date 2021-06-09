package com.hong.server.db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBHelper {
	private static Connection Conn; // ���ݿ����Ӷ���

	// ���ݿ����ӵ�ַ
	private static String URL = "jdbc:mysql://localhost:3306/qq?characterEncoding=utf8&useSSL=true";

	// ���ݿ���û���
	private static String UserName = "root";
	// ���ݿ������
	private static String Password = "";

	public static Connection getConnection() {

		try {

			Class.forName("com.mysql.jdbc.Driver"); // ��������

			// System.out.println("���������ɹ�!!!");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try {

			// ͨ��DriverManager���getConenction����ָ����������,�������ݿ�
			Conn = (Connection) DriverManager.getConnection(URL, UserName, Password);
			// System.out.println("�������ݿ�ɹ�!!!");

			// �������Ӷ���
			return Conn;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
