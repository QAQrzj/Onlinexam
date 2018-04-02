package com.qaqrz.onlinexam.dao.admin;

import java.util.List;

import com.qaqrz.onlinexam.po.Course;
import com.qaqrz.onlinexam.po.TeacherCourse;
import com.qaqrz.onlinexam.vo.TeacherCourseView;

public interface ICourseDao {
	/**
	 * 修改为返回一个map
	 * 
	 * @return
	 */
	public List<TeacherCourseView> findAllTeaCourInfo();

	/**
	 * 根据课程名称查询是否课程存在,如果存在则返回课程,不存在返回null
	 * 
	 * @param name
	 * @return
	 */
	public Course findCourseByName(String name);

	public TeacherCourse findTeacherCourseById(int id);

	public void addCourse(String name);

	public void updateCourse(Course course);

	public Course findCourseById(int id);

	public void addTeacherCourse(TeacherCourse tc);

	/**
	 * 修改为map
	 * 
	 * @param teaCourId
	 * @return
	 */
	public TeacherCourseView findTeaCourInfoById(int id);

	/**
	 * 查找所有的课程
	 * 
	 * @return
	 */
	public List<Course> findAllCourses();

	/**
	 * 查找所有的课程
	 * 
	 * @return
	 */
	public List<Course> findAllCoursesByName(String name);

	/**
	 * 根据提供的TeacherCourse对象信息查询是否存在
	 * 
	 * @param courseId
	 * @param teaId
	 * @param stuClassId
	 * @return true表示存在，false表示不存在
	 */
	public boolean isExitByAllIds(TeacherCourse tc);

	public void updateTeacherCourse(TeacherCourse tc);

	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey);

	public void deleteCourse(int id);

	public void deleteTeacherCourse(int id);

	/**
	 * 根据当前的教师id查询属于这个教师的课程
	 * 
	 * @param teaId
	 * @return
	 */
	public List<Course> findCoursesByTeacherId(int teaId);
}