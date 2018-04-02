package com.qaqrz.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.dao.admin.IStudentClassDao;
import com.qaqrz.onlinexam.dao.admin.StudentClassDao;
import com.qaqrz.onlinexam.po.StudentClass;

public class StudentClassService implements IStudentClassService {
	private IStudentClassDao scd = new StudentClassDao();

	@Override
	public List<?> findAll() {
		return scd.findAllStudentClassInfo();
	}

	@Override
	public void addStudentClass(StudentClass sc) {
		scd.addStudentClass(sc);
	}

	@Override
	public void updateStudentClass(StudentClass sc) {
		scd.updateStudentClass(sc);
	}

	@Override
	public Map<String, Object> findStudentClassById(int id) {
		return scd.findStudentClassById(id);
	}

	@Override
	public void deleteStudentClassById(int id) {
		scd.deleteStudentClassById(id);
	}

	@Override
	public String findClassNamesByIds(String ids) {
		return scd.findClassNamesByIds(ids);
	}

	@Override
	public List<StudentClass> findStudentClassesByTeacherId(int teaId) {
		return scd.findStudentClassesByTeacherId(teaId);
	}
}