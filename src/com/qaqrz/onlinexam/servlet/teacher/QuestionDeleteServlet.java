package com.qaqrz.onlinexam.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.service.teacher.IQuestionService;
import com.qaqrz.onlinexam.service.teacher.QuestionService;

@WebServlet("/questionDelete")
public class QuestionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IQuestionService qs = new QuestionService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		qs.deleteQuestion(Integer.valueOf(req.getParameter("id")));
		resp.sendRedirect("questionQuery");
	}
}