package com.qaqrz.onlinexam.po;

import java.sql.*;

public class Test {
	private int id;
	private String testName;
	private int courseId;
	private Timestamp endDate;
	private int testTime;
	private String questions;
	private int teacherId;
	private String classIds;
	private double scores;

	public Test() {

	}

	public Test(String testName, int courseId, Timestamp endDate, int testTime, String questions, int teacherId,
			String classIds, double scores) {
		this.testName = testName;
		this.courseId = courseId;
		this.endDate = endDate;
		this.testTime = testTime;
		this.questions = questions;
		this.teacherId = teacherId;
		this.classIds = classIds;
		this.scores = scores;
	}

	public Test(int id, String testName, int courseId, Timestamp endDate, int testTime, String questions, int teacherId,
			String classIds, double scores) {
		this.id = id;
		this.testName = testName;
		this.courseId = courseId;
		this.endDate = endDate;
		this.testTime = testTime;
		this.questions = questions;
		this.teacherId = teacherId;
		this.classIds = classIds;
		this.scores = scores;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public int getTestTime() {
		return testTime;
	}

	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getClassIds() {
		return classIds;
	}

	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}

	public double getScores() {
		return scores;
	}

	public void setScores(double scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", testName=" + testName + ", courseId=" + courseId + ", endDate=" + endDate
				+ ", testTime=" + testTime + ", questions=" + questions + ", teacherId=" + teacherId + ", classIds="
				+ classIds + ", scores=" + scores + "]";
	}
}