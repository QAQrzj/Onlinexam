package com.qaqrz.onlinexam.po;

public class Teacher {
	private int id;
	private String teacherName;
	private String pwd;
	private String deptName;

	public Teacher() {

	}

	public Teacher(String teacherName, String pwd) {
		this.teacherName = teacherName;
		this.pwd = pwd;
	}

	public Teacher(int id, String teacherName, String pwd, String deptName) {
		this.id = id;
		this.teacherName = teacherName;
		this.pwd = pwd;
		this.deptName = deptName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacherName=" + teacherName + ", pwd=" + pwd + ", deptName=" + deptName + "]";
	}
}