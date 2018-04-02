package com.qaqrz.onlinexam.po;

public class TeacherCourse {
	private int id;
	private int courseId;
	private int teacherId;
	private int classId;

	public TeacherCourse() {

	}

	public TeacherCourse(int courseId, int teacherId, int classId) {
		this.courseId = courseId;
		this.teacherId = teacherId;
		this.classId = classId;
	}

	public TeacherCourse(int id, int courseId, int teacherId, int classId) {
		this.id = id;
		this.courseId = courseId;
		this.teacherId = teacherId;
		this.classId = classId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "TeacherCourse [id=" + id + ", courseId=" + courseId + ", teacherId=" + teacherId + ", classId="
				+ classId + "]";
	}
}