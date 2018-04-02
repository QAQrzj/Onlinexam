package com.qaqrz.onlinexam.po;

import java.sql.Timestamp;

public class Paper {
	private int id;
	private int testId;
	private int courseId;
	private String time;
	private double score;
	private String wrongQueId;
	private String wrongAns;
	private int studentId;
	private Timestamp createDate;

	public Paper() {

	}

	public Paper(int testId, int courseId, String time, double score, String wrongQueId, String wrongAns,
			int studentId) {
		this.testId = testId;
		this.courseId = courseId;
		this.time = time;
		this.score = score;
		this.wrongQueId = wrongQueId;
		this.wrongAns = wrongAns;
		this.studentId = studentId;
	}

	public Paper(int id, int testId, int courseId, String time, double score, String wrongQueId, String wrongAns,
			int studentId, Timestamp createDate) {
		this.id = id;
		this.testId = testId;
		this.courseId = courseId;
		this.time = time;
		this.score = score;
		this.wrongQueId = wrongQueId;
		this.wrongAns = wrongAns;
		this.studentId = studentId;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getWrongQueId() {
		return wrongQueId;
	}

	public void setWrongQueId(String wrongQueId) {
		this.wrongQueId = wrongQueId;
	}

	public String getWrongAns() {
		return wrongAns;
	}

	public void setWrongAns(String wrongAns) {
		this.wrongAns = wrongAns;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Paper [id=" + id + ", testId=" + testId + ", courseId=" + courseId + ", time=" + time + ", score="
				+ score + ", wrongQueId=" + wrongQueId + ", wrongAns=" + wrongAns + ", studentId=" + studentId
				+ ", createDate=" + createDate + "]";
	}
}