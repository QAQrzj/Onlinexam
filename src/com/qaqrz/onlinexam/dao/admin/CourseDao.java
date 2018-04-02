package com.qaqrz.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;

import com.qaqrz.onlinexam.po.Course;
import com.qaqrz.onlinexam.po.TeacherCourse;
import com.qaqrz.onlinexam.util.DBUtil;
import com.qaqrz.onlinexam.vo.TeacherCourseView;

public class CourseDao implements ICourseDao {
	private DBUtil db = new DBUtil();

	@Override
	public List<TeacherCourseView> findAllTeaCourInfo() {
		String sql = "select teachercourse.id,teacher.id teacherId,teacher.teacherName,course.id courseId,course.courseName,studentclass.id classId,studentclass.className,studentclass.deptName from teachercourse,teacher,course,studentclass where teachercourse.teacherId = teacher.id and teachercourse.courseId = course.id and teachercourse.classId = studentclass.id";
		List teacherCourseViewList = new ArrayList<TeacherCourseView>();
		try {
			teacherCourseViewList = db.getQueryList(TeacherCourseView.class, sql, new Object[] {});
		} catch (Exception e) {
			teacherCourseViewList = new ArrayList<TeacherCourseView>();
			e.printStackTrace();
		}
		return teacherCourseViewList;
	}

	@Override
	public Course findCourseByName(String name) {
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		String sql = "select * from teachercourse where id = ?";
		TeacherCourse teachercourse = new TeacherCourse();
		try {
			teachercourse = (TeacherCourse) db.getObject(TeacherCourse.class, sql, new Object[] { id });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachercourse;
	}

	@Override
	public void addCourse(String name) {
		String sql = "insert into course(courseName) values(?)";
		try {
			db.execute(sql, new Object[] { name });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourse(Course course) {
		String sql = "update course set courseName = ? where id= ?";
		try {
			db.execute(sql, new Object[] { course.getCourseName(), course.getId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Course findCourseById(int id) {
		String sql = "select * from course where id = ?";
		Course course = new Course();
		try {
			course = (Course) db.getObject(Course.class, sql, new Object[] { id });
		} catch (Exception e) {
			course = new Course();
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		String sql = "insert into teachercourse(courseId,teacherId,classId) values(?,?,?)";
		try {
			db.execute(sql, new Object[] { tc.getCourseId(), tc.getTeacherId(), tc.getClassId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public TeacherCourseView findTeaCourInfoById(int id) {
		return null;
	}

	@Override
	public List<Course> findAllCourses() {
		String sql = "select * from course";
		List courseList = new ArrayList<Course>();
		try {
			courseList = db.getQueryList(sql);
		} catch (Exception e) {
			courseList = new ArrayList<Course>();
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		return null;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		String sql = "update teachercourse set teacherId = ?,courseId = ?,classId = ? where id = ?";
		try {
			db.execute(sql, new Object[] { tc.getTeacherId(), tc.getCourseId(), tc.getClassId(), tc.getId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		return null;
	}

	@Override
	public void deleteCourse(int id) {
		String sql = "delete from course where id = ?";
		try {
			db.execute(sql, new Object[] { id });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		String sql = "select * from course where id in(select courseId from teachercourse where teacherId = ?)";
		List courseList = new ArrayList<Course>();
		try {
			courseList = db.getQueryList(Course.class, sql, new Object[] { teaId });
		} catch (Exception e) {
			courseList = new ArrayList<Course>();
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public void deleteTeacherCourse(int id) {
		String sql = "delete from teachercourse where id = ?";
		try {
			db.execute(sql, new Object[] { id });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}