package com.qaqrz.onlinexam.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.qaqrz.onlinexam.po.*;

public class DBUtilQueryTest {
	public static void main(String[] args) throws Exception {
		DBUtil db = new DBUtil();
		String sql = "select * from test";
		List<Map<String, Object>> testList = db.getQueryList(sql);
		for (int i = 0; i < testList.size(); i++) {
			Map<String, Object> testMap = testList.get(i);
			Iterator<Entry<String, Object>> it = testMap.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Object> entry = it.next();
				System.out.println(entry);
			}
		}
		String sql2 = "select * from test where courseId = ? and teacherId = ?";
		List<Map<String, Object>> testList2 = db.getQueryList(sql2, new Object[] { 1, 1 });
		for (int i = 0; i < testList2.size(); i++) {
			Map<String, Object> testMap = testList2.get(i);
			Iterator<Entry<String, Object>> it = testMap.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Object> entry = it.next();
				System.out.println(entry);
			}
		}
		List<Class<?>> testList3 = db.getQueryList(Test.class, sql2, new Object[] { 1, 1 });
		for (Object o : testList3) {
			System.out.println(o.toString());
		}
		for (int i = 0; i < testList3.size(); i++) {
			System.out.println(((Object) testList3.get(i)).toString());
		}
		String task1 = "select student.studentName,paper.score from student,paper where student.id=paper.studentId and student.studentName like ?";
		List<Map<String, Object>> taskList = db.getQueryList(task1, new Object[] { "张%" });
		for (Object o : taskList) {
			System.out.println(o.toString());
		}
		String task2 = "select teacher.teacherName,course.courseName,studentclass.className from teacher,teachercourse,course,studentclass where teacher.id = teachercourse.teacherId and teachercourse.courseId = course.id and teachercourse.courseId = studentclass.id and teacher.teacherName = ?";
		List<Map<String, Object>> taskList2 = db.getQueryList(task2, new Object[] { "刘晓红" });
		for (Object o : taskList2) {
			System.out.println(o.toString());
		}
		String task3 = "select * from question";
		List<Class<?>> taskList3 = db.getQueryList(Question.class, task3, new Object[] {});
		for (Object o : taskList3) {
			System.out.println(o.toString());
		}
	}
}