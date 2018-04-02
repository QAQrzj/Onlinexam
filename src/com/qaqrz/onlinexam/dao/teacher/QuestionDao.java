package com.qaqrz.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.po.Question;
import com.qaqrz.onlinexam.util.DBUtil;

public class QuestionDao implements IQuestionDao {
	private DBUtil db = new DBUtil();

	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value) {
		String sql = "select question.*,course.courseName from question,course where question.courseId = course.id and queExist = 1";
		if (null != key && !"".equals(key) && null != value) {
			sql += " and " + key + " like '%" + value + "%'";
		}
		List<Map<String, Object>> questionList = new ArrayList<Map<String, Object>>();
		try {
			questionList = db.getQueryList(sql, new Object[] {});
		} catch (Exception e) {
			questionList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return questionList;
	}

	@Override
	public void addQuestion(Question q) {
		String sql = "insert into question(courseId,queType,queTitle,choiceA,choiceB,choiceC,choiceD,ans,queExist) values(?,?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { q.getCourseId(), q.getQueType(), q.getQueTitle(), q.getChoiceA(),
					q.getChoiceB(), q.getChoiceC(), q.getChoiceD(), q.getAns(), 1 });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		String sql = "select * from question where id = ? and queExist = 1";
		Map<String, Object> questionMap = new HashMap<String, Object>();
		try {
			questionMap = db.getObject(sql, new Object[] { id });
		} catch (Exception e) {
			questionMap = new HashMap<String, Object>();
			e.printStackTrace();
		}
		return questionMap;
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		String sql = "select * from question where find_in_set (id,?) and queExist = 1";
		List questionList = new ArrayList<Question>();
		try {
			questionList = db.getQueryList(Question.class, sql, new Object[] { ids });
		} catch (Exception e) {
			questionList = new ArrayList<Question>();
			e.printStackTrace();
		}
		return questionList;
	}

	@Override
	public void updateQuestionInfo(Question q) {
		String sql = "update question set courseId = ?,queType = ?,queTitle = ?,choiceA = ?,choiceB = ?,choiceC = ?,choiceD = ?,ans = ? where id = ? and queExist = 1";
		try {
			db.execute(sql, new Object[] { q.getCourseId(), q.getQueType(), q.getQueTitle(), q.getChoiceA(),
					q.getChoiceB(), q.getChoiceC(), q.getChoiceD(), q.getAns(), q.getId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		String sql = "select * from question where courseId = ? and queExist = 1";
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		try {
			queList = db.getQueryList(sql, new Object[] { courseId });
		} catch (Exception e) {
			queList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return queList;
	}

	@Override
	public void deleteQuestion(int id) {
		String sql = "update question set queExist = 0 where id = ?";
		try {
			db.execute(sql, new Object[] { id });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}