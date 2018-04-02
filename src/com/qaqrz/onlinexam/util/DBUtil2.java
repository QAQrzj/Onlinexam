package com.qaqrz.onlinexam.util;

import java.io.*;
import java.util.*;
import java.sql.*;
import com.qaqrz.onlinexam.po.*;

public class DBUtil2 {
	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;

	public static void getConfig() {
		Properties prop = new Properties();
		InputStream in = DBUtil2.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			prop.load(in);
			driverClassName = prop.getProperty("driverClassName");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		DBUtil2.getConfig();
		Connection conn = DBUtil2.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from course");
		ResultSet rs = pstmt.executeQuery();
		Course s = new Course();
		while (rs.next()) {
			s.setId(rs.getInt("id"));
			s.setCourseName(rs.getString("courseName"));
			System.out.println(s.getId() + " " + s.getCourseName());
		}
		DBUtil2.close(rs);
		DBUtil2.close(pstmt);
		DBUtil2.close(conn);
	}
}