package com.hong.server.db;

import java.sql.ResultSet;

import com.hong.common.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class dbUtil {

	private Connection conn;
	private ResultSet rs;

	public User getUser(String userId) {
		User user = new User();
		try {
			conn = DBHelper.getConnection();
			String sql = "select userId,password from user where userId=?";
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getString(1));
				user.setPassword(rs.getString(2));
			}
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return user;
	}

	/*
	 * public static void main(String[] args) { User user = new
	 * dbUtil().getUser("996141004"); System.out.println(user); }
	 */
}
