package com.hong.server.db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBHelper {
	private static Connection Conn; // 数据库连接对象

	// 数据库连接地址
	private static String URL = "jdbc:mysql://localhost:3306/qq?characterEncoding=utf8&useSSL=true";

	// 数据库的用户名
	private static String UserName = "root";
	// 数据库的密码
	private static String Password = "";

	public static Connection getConnection() {

		try {

			Class.forName("com.mysql.jdbc.Driver"); // 加载驱动

			// System.out.println("加载驱动成功!!!");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try {

			// 通过DriverManager类的getConenction方法指定三个参数,连接数据库
			Conn = (Connection) DriverManager.getConnection(URL, UserName, Password);
			// System.out.println("连接数据库成功!!!");

			// 返回连接对象
			return Conn;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
