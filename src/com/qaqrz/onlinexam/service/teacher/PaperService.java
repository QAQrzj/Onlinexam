package com.qaqrz.onlinexam.service.teacher;

import java.util.List;

import com.qaqrz.onlinexam.dao.teacher.IPaperDao;
import com.qaqrz.onlinexam.dao.teacher.PaperDao;
import com.qaqrz.onlinexam.po.Paper;

public class PaperService implements IPaperService {
	private IPaperDao pd = new PaperDao();

	@Override
	public void save(Paper paper) {
		pd.save(paper);
	}

	@Override
	public List<?> getPaperByStudentId(int studentId, int testId) {
		return null;
	}

	@Override
	public List<?> getPaperByStudentId(int studentId) {
		return pd.getPaperByStudentId(studentId);
	}

	@Override
	public List<?> getPaperCompare(int teaId) {
		return pd.getPaperCompare(teaId);
	}
}