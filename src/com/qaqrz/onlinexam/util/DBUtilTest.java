package com.qaqrz.onlinexam.util;

import java.util.*;
import java.util.Map.*;
import com.qaqrz.onlinexam.po.*;

public class DBUtilTest {
	public static void main(String[] args) throws Exception {
		DBUtil db = new DBUtil();
		String sql = "select * from course";
		Map<String, Object> courseMap = db.getObject(sql);
		Iterator<Entry<String, Object>> it = courseMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = (Entry<String, Object>) it.next();
			System.out.println(entry);
		}
		String sql2 = "select * from test where id = ? and teacherId = ?";
		Map<String, Object> courseMap2 = db.getObject(sql2, new Object[] { 1, 1 });
		System.out.println(courseMap2);
		Test c = (Test) db.getObject(Test.class, sql2, new Object[] { 1, 1 });
		System.out.println(c.toString());
	}
}