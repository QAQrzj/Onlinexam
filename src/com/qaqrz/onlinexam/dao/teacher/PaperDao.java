package com.qaqrz.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.List;

import com.qaqrz.onlinexam.po.Paper;
import com.qaqrz.onlinexam.util.DBUtil;

public class PaperDao implements IPaperDao {
	private DBUtil db = new DBUtil();

	@Override
	public void save(Paper paper) {
		String sql = "insert into paper(testId,courseId,time,score,wrongQueId,WrongAns,studentId) values(?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { paper.getTestId(), paper.getCourseId(), paper.getTime(), paper.getScore(),
					paper.getWrongQueId(), paper.getWrongAns(), paper.getStudentId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<?> getPaperByStudentId(int studentId, int testId) {
		return null;
	}

	@Override
	public List<?> getPaperByStudentId(int studentId) {
		String sql = "select paper.*,course.courseName,test.testName,test.testTime,test.scores from paper,course,test where studentId = ? and paper.courseId = course.id and paper.testId = test.id";
		List<?> paperList = new ArrayList();
		try {
			paperList = db.getQueryList(sql, new Object[] { studentId });
		} catch (Exception e) {
			paperList = new ArrayList();
			e.printStackTrace();
		}
		return paperList;
	}

	@Override
	public List<?> getPaperCompare(int teaId) {
		String sql = "select studentclass.*, course.courseName,test.testName,test.endDate,avg(paper.score) avgScore from studentclass,student,course,test,paper where test.teacherId = ? and test.courseId = course.id and find_in_set(studentclass.id,test.classIds) and test.id = paper.testId and test.courseId = paper.courseId and student.classId = studentclass.id and student.id = paper.studentId group by studentclass.id,course.id,test.id";
		List<?> paperList = new ArrayList();
		try {
			paperList = db.getQueryList(sql, new Object[] { teaId });
		} catch (Exception e) {
			paperList = new ArrayList();
			e.printStackTrace();
		}
		return paperList;
	}
}