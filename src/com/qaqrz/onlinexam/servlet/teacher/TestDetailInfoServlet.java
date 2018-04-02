package com.qaqrz.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.Teacher;
import com.qaqrz.onlinexam.service.teacher.IQuestionService;
import com.qaqrz.onlinexam.service.teacher.ITestService;
import com.qaqrz.onlinexam.service.teacher.QuestionService;
import com.qaqrz.onlinexam.service.teacher.TestService;

@WebServlet("/testDetailInfo")
public class TestDetailInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IQuestionService qs = new QuestionService();
	private ITestService ts = new TestService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher t = (Teacher) req.getSession().getAttribute("user");
		Map<String, Object> test = ts.findTestById(Integer.valueOf(req.getParameter("id")), t.getId());
		req.setAttribute("test", test);
		req.setAttribute("questionList", qs.findQuestionByIds(test.get("questions").toString()));
		req.getRequestDispatcher("teacher/viewtest.jsp").forward(req, resp);
	}
}