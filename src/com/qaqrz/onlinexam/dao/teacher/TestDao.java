package com.qaqrz.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.po.Test;
import com.qaqrz.onlinexam.util.DBUtil;

public class TestDao implements ITestDao {
	private DBUtil db = new DBUtil();

	@Override
	public void createTest(Test t) {
		String sql = "insert into test(testName,courseId,endDate,testTime,questions,teacherId,classIds,scores) values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { t.getTestName(), t.getCourseId(), t.getEndDate().toString(), t.getTestTime(),
					t.getQuestions(), t.getTeacherId(), t.getClassIds(), t.getScores() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		String sql = "select test.*,course.courseName,group_concat(studentclass.className) classNames from test,course,studentclass where test.courseId = course.id and test.teacherId = ? and test.endDate > CURRENT_TIMESTAMP and find_in_set(studentclass.id,test.classIds) group by test.id";
		List<Map<String, Object>> testList = new ArrayList<Map<String, Object>>();
		try {
			testList = db.getQueryList(sql, new Object[] { teaId });
		} catch (Exception e) {
			testList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return testList;
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		String sql = "select test.*,course.courseName,group_concat(studentclass.className) classNames from test,course,studentclass where test.id = ? and test.courseId = course.id and test.teacherId = ? and find_in_set(studentclass.id,test.classIds) group by test.id";
		Map<String, Object> testMap = new HashMap<String, Object>();
		try {
			testMap = db.getObject(sql, new Object[] { id, teaId });
		} catch (Exception e) {
			testMap = new HashMap<String, Object>();
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		String sql = "select test.*,student.studentName,course.courseName,studentclass.className from student,test,course,studentclass where test.id = ? and find_in_set(student.classId,test.classIds) and student.id = ? and test.courseId = course.id and student.classId = studentclass.id";
		Map<String, Object> testMap = new HashMap<String, Object>();
		try {
			testMap = db.getObject(sql, new Object[] { testid, studentid });
		} catch (Exception e) {
			testMap = new HashMap<String, Object>();
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id) {
		String sql = "select test.*,course.courseName from test,course,student,studentclass where student.id = ? and student.classId = studentclass.id and find_in_set(studentclass.id,test.classIds) and test.courseId = course.id and test.endDate > current_timestamp and test.id not in (select testId from paper where studentId = ?)";
		List<Map<String, Object>> testList = new ArrayList<Map<String, Object>>();
		try {
			testList = db.getQueryList(sql, new Object[] { id, id });
		} catch (Exception e) {
			testList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return testList;
	}
}