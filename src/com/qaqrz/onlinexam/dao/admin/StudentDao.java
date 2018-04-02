package com.qaqrz.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.po.Student;
import com.qaqrz.onlinexam.util.DBUtil;

public class StudentDao implements IStudentDao {
	private DBUtil db = new DBUtil();

	@Override
	public void addStudent(Student s) {
		String sql = "insert into student(studentName,pwd,school,sex,born,classId) values(?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { s.getStudentName(), s.getPwd(), s.getSchool(), s.getSex(),
					s.getBorn().toString(), s.getClassId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		String sql = "update student set studentName = ?,pwd = ?,school = ?,sex = ?,born = ?,classId = ? where id = ?";
		try {
			db.execute(sql, new Object[] { s.getStudentName(), s.getPwd(), s.getSchool(), s.getSex(),
					s.getBorn().toString(), s.getClassId(), s.getId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student findStudentById(int id) {
		String sql = "select * from student where student.id = ?";
		Student student = new Student();
		try {
			student = (Student) db.getObject(Student.class, sql, new Object[] { id });
		} catch (Exception e) {
			student = new Student();
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		String sql = "select student.*,studentclass.className,studentclass.deptName from student,studentclass where student.classId = studentclass.id";
		List<Map<String, Object>> studentList = new ArrayList<Map<String, Object>>();
		try {
			studentList = db.getQueryList(sql);
		} catch (Exception e) {
			studentList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public void deleteStudentById(int id) {
		String sql = "delete from student where id = ?";
		try {
			db.execute(sql, new Object[] { id });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}