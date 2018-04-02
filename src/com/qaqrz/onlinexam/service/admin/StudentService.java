package com.qaqrz.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.dao.admin.IStudentDao;
import com.qaqrz.onlinexam.dao.admin.StudentDao;
import com.qaqrz.onlinexam.po.Student;

public class StudentService implements IStudentService {
	private IStudentDao sd = new StudentDao();

	@Override
	public void addStudent(Student s) {
		sd.addStudent(s);
	}

	@Override
	public void updateStudent(Student s) {
		sd.updateStudent(s);
	}

	@Override
	public Student findStudentById(int id) {
		return sd.findStudentById(id);
	}

	@Override
	public List<Map<String, Object>> findAll() {
		return sd.findAll();
	}

	@Override
	public void deleteStudentById(int id) {
		sd.deleteStudentById(id);
	}
}