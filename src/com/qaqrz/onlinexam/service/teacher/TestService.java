package com.qaqrz.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.qaqrz.onlinexam.dao.teacher.ITestDao;
import com.qaqrz.onlinexam.dao.teacher.TestDao;
import com.qaqrz.onlinexam.po.Test;

public class TestService implements ITestService {
	private ITestDao td = new TestDao();

	@Override
	public void createTest(Test t) {
		td.createTest(t);
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		return td.findTestsByTeaId(teaId);
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		return td.findTestById(id, teaId);
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		return td.findStudentTestsById(studentid, testid);
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id) {
		return td.getTestByStudent(id);
	}
}