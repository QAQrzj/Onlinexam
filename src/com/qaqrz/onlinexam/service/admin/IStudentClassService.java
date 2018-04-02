package com.qaqrz.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.po.StudentClass;

public interface IStudentClassService {

	/**
	 * 查询所有的班级信息
	 * 
	 * @return
	 */
	public List findAll();

	public void addStudentClass(StudentClass sc);

	public void updateStudentClass(StudentClass sc);

	public Map<String, Object> findStudentClassById(int id);

	public void deleteStudentClassById(int id);

	/**
	 * 查询指定的多个班级id号的班级名称
	 * 
	 * @param ids
	 * @return 返回的是班级名称的字符串，多个班级之间以空格隔开
	 */
	public String findClassNamesByIds(String ids);

	/**
	 * 根据当前的教师id查询属于这个教师的班级
	 * 
	 * @param teacherId
	 * @return
	 */
	public List<StudentClass> findStudentClassesByTeacherId(int teacherId);

}
