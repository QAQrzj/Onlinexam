package com.qaqrz.onlinexam.po;

import java.sql.Date;

public class Student {
	private int id;
	private String studentName;
	private String pwd;
	private String school;
	private String sex;
	private Date born;
	private int classId;

	public Student() {

	}

	public Student(String studentName, String pwd) {
		this.studentName = studentName;
		this.pwd = pwd;
	}

	public Student(String studentName, String pwd, String school, String sex, Date born, int classId) {
		this.studentName = studentName;
		this.pwd = pwd;
		this.school = school;
		this.sex = sex;
		this.born = born;
		this.classId = classId;
	}

	public Student(int id, String studentName, String pwd, String school, String sex, Date born, int classId) {
		this.id = id;
		this.studentName = studentName;
		this.pwd = pwd;
		this.school = school;
		this.sex = sex;
		this.born = born;
		this.classId = classId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", pwd=" + pwd + ", school=" + school + ", sex="
				+ sex + ", born=" + born + ", classId=" + classId + "]";
	}
}