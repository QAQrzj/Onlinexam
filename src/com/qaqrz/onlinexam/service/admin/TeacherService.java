package com.qaqrz.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.dao.admin.ITeacherDao;
import com.qaqrz.onlinexam.dao.admin.TeacherDao;
import com.qaqrz.onlinexam.po.Teacher;

public class TeacherService implements ITeacherService {
	private ITeacherDao td = new TeacherDao();

	@Override
	public List<Teacher> findTeachers(String name) {
		return td.findAllTeacherByInfo(name);
	}

	@Override
	public void addTeacher(Teacher teacher) {
		td.addTeacher(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldid) {
		td.updateTeacher(teacher, oldid);
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		return td.findTeacherInfo(id);
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		return null;
	}

	@Override
	public void deleteTeacherById(int id) {
		td.deleteTeacherById(id);
	}
}