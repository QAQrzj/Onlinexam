package com.qaqrz.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.po.Teacher;

public interface ITeacherService {
	/**
	 * 此方法用来查询符合条件的教师信息
	 * 
	 * @param name
	 *            教师姓名
	 * @return 教师集合List,集合里都是Teacher对象
	 */
	public List<Teacher> findTeachers(String name);

	public void addTeacher(Teacher teacher);

	public void updateTeacher(Teacher teacher, int oldid);

	public Map<String, Object> findTeacherInfo(int id);

	public void deleteTeacherById(int id);

	public List<Map<String, Object>> findClassesByTeacherId(int teacherId);
}