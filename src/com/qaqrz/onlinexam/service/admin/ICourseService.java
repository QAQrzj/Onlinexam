package com.qaqrz.onlinexam.service.admin;

import java.util.List;

import com.qaqrz.onlinexam.po.Course;
import com.qaqrz.onlinexam.po.TeacherCourse;
import com.qaqrz.onlinexam.vo.TeacherCourseView;

public interface ICourseService {
	/**
	 * 查询所有的关系映射表
	 * 
	 * @return
	 */
	public List<TeacherCourseView> findAll();

	/**
	 * 根据映射表的id查询某一条映射记录
	 * 
	 * @param id
	 * @return
	 */
	public TeacherCourse findTeacherCourseById(int id);

	/**
	 * 根据课程id号查询课程
	 * 
	 * @param id
	 * @return
	 */
	public Course findCourseById(int id);

	/**
	 * 查询所有的课程
	 * 
	 * @return
	 */
	public List<Course> findAllCourses();

	/**
	 * 模糊查询
	 * 
	 * @param name
	 * @return
	 */
	public List<Course> findAllCourses(String name);

	/**
	 * 先判断一下是否存在,如果不存在,直接插入操作,如果存在,则更新
	 * 
	 * @param teaCourID
	 *            映射ID号,自增长
	 * @param courseId
	 * @param teaId
	 * @param stuClassId
	 * @return
	 */
	public void modifyTeacherCourse(TeacherCourse tc);

	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey);

	public void deleteTeacherCourse(int tcId);

	public void deleteCourseById(int id);

	/**
	 * 添加课程信息
	 * 
	 * @return
	 */
	public void addCourse(String courseName);

	/**
	 * 添加课程信息
	 * 
	 * @return
	 */
	public void updateCourse(Course course);

	/**
	 * 添加排课信息,包括老师,班级,和课程
	 * 
	 * @return
	 */
	public void addSchedule(TeacherCourse tc);

	/**
	 * 根据当前的教师id查询属于这个教师的课程
	 * 
	 * @param teaId
	 * @return
	 */
	public List<Course> findCoursesByTeacherId(int teaId);
}
