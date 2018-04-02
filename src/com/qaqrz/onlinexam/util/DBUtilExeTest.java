package com.qaqrz.onlinexam.util;

public class DBUtilExeTest {
	public static void main(String[] args) throws Exception {
		DBUtil db = new DBUtil();
		// String sql = "insert into course(courseName) values('计算机组成原理')";
		// db.execute(sql);
		// String sql2 = "insert into course(courseName) values(?)";
		// db.execute(sql2, new Object[] { "计算机网络" });
		String sql3 = "delete from course where courseName = ?";
		db.execute(sql3, new Object[] { "计算机网络" });
	}
}