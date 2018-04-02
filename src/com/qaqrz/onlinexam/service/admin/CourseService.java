package com.qaqrz.onlinexam.service.admin;

import java.util.List;

import com.qaqrz.onlinexam.dao.admin.CourseDao;
import com.qaqrz.onlinexam.dao.admin.ICourseDao;
import com.qaqrz.onlinexam.po.Course;
import com.qaqrz.onlinexam.po.TeacherCourse;
import com.qaqrz.onlinexam.vo.TeacherCourseView;

public class CourseService implements ICourseService {
	private ICourseDao cd = new CourseDao();

	@Override
	public List<TeacherCourseView> findAll() {
		return cd.findAllTeaCourInfo();
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		return cd.findTeacherCourseById(id);
	}

	@Override
	public Course findCourseById(int id) {
		return cd.findCourseById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		return cd.findAllCourses();
	}

	@Override
	public List<Course> findAllCourses(String name) {
		return null;
	}

	@Override
	public void modifyTeacherCourse(TeacherCourse tc) {
		cd.updateTeacherCourse(tc);
	}

	@Override
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey) {
		return null;
	}

	@Override
	public void deleteTeacherCourse(int tcId) {
		cd.deleteTeacherCourse(tcId);
	}

	@Override
	public void addCourse(String courseName) {
		cd.addCourse(courseName);
	}

	@Override
	public void updateCourse(Course course) {
		cd.updateCourse(course);
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		cd.addTeacherCourse(tc);
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		return cd.findCoursesByTeacherId(teaId);
	}

	@Override
	public void deleteCourseById(int id) {
		cd.deleteCourse(id);
	}
}