package com.qaqrz.onlinexam.vo;

public class TeacherCourseView {
	private int id;
	private int teacherId;
	private String teacherName;
	private int courseId;
	private String courseName;
	private int classId;
	private String className;
	private String deptName;

	public TeacherCourseView() {

	}

	public TeacherCourseView(int teacherId, String teacherName, int courseId, String courseName, int classId,
			String className, String deptName) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.classId = classId;
		this.className = className;
		this.deptName = deptName;
	}

	public TeacherCourseView(int id, int teacherId, String teacherName, int courseId, String courseName, int classId,
			String className, String deptName) {
		this.id = id;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.classId = classId;
		this.className = className;
		this.deptName = deptName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "TeacherCourseView [id=" + id + ", teacherId=" + teacherId + ", teacherName=" + teacherName
				+ ", courseId=" + courseId + ", courseName=" + courseName + ", classId=" + classId + ", className="
				+ className + ", deptName=" + deptName + "]";
	}
}