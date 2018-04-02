package com.qaqrz.onlinexam.dao.admin;

import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.po.Student;

public interface IStudentDao {
	public void addStudent(Student s);

	public void updateStudent(Student s);

	public Student findStudentById(int id);

	public void deleteStudentById(int id);

	public List<Map<String, Object>> findAll();
}