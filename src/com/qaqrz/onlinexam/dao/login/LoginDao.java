package com.qaqrz.onlinexam.dao.login;

import com.qaqrz.onlinexam.po.Student;
import com.qaqrz.onlinexam.po.Teacher;
import com.qaqrz.onlinexam.util.DBUtil;

public class LoginDao implements ILoginDao {
	private DBUtil db = new DBUtil();

	@Override
	public Teacher canLogin(Teacher t) {
		String sql = "select * from teacher where teacherName = ? and pwd = ?";
		Teacher teacher = new Teacher();
		try {
			teacher = (Teacher) db.getObject(Teacher.class, sql, new Object[] { t.getTeacherName(), t.getPwd() });
		} catch (Exception e) {
			teacher = null;
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public Student canLogin(Student s) {
		String sql = "select * from student where studentName = ? and pwd = ?";
		Student student = new Student();
		try {
			student = (Student) db.getObject(Student.class, sql, new Object[] { s.getStudentName(), s.getPwd() });
		} catch (Exception e) {
			student = null;
			e.printStackTrace();
		}
		return student;
	}
}