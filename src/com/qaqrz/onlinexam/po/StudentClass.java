package com.qaqrz.onlinexam.po;

public class StudentClass {
	private int id;
	private String className;
	private String deptName;

	public StudentClass() {

	}

	public StudentClass(String className, String deptName) {
		this.className = className;
		this.deptName = deptName;
	}

	public StudentClass(int id, String className, String deptName) {
		this.id = id;
		this.className = className;
		this.deptName = deptName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Class [id=" + id + ", className=" + className + ", deptName=" + deptName + "]";
	}
}