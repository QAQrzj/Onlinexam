package com.qaqrz.onlinexam.dao.admin;

import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.po.StudentClass;

public interface IStudentClassDao {
	public List<?> findAllStudentClassInfo();

	public Map<String, Object> findStudentClassById(int classId);

	public void deleteStudentClassById(int classId);

	public void addStudentClass(StudentClass sc);

	public void updateStudentClass(StudentClass sc);

	public String findClassNamesByIds(String ids);

	/**
	 * 根据当前的教师id查询属于这个教师的班级
	 * 
	 * @param teaId
	 * @return
	 */
	public List<StudentClass> findStudentClassesByTeacherId(int teacherId);
}