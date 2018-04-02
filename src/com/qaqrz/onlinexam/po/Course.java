package com.qaqrz.onlinexam.po;

public class Course {
	private int id;
	private String courseName;

	public Course() {

	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public Course(int id, String courseName) {
		this.id = id;
		this.courseName = courseName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + "]";
	}
}