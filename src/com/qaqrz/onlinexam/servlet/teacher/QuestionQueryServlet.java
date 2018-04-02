package com.qaqrz.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.service.admin.CourseService;
import com.qaqrz.onlinexam.service.admin.ICourseService;
import com.qaqrz.onlinexam.service.teacher.IQuestionService;
import com.qaqrz.onlinexam.service.teacher.QuestionService;

@WebServlet("/questionQuery")
public class QuestionQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService cs = new CourseService();
	private IQuestionService qs = new QuestionService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<?> questionList = qs.findAll(req.getParameter("searchtype"), req.getParameter("searchname"));
		List<?> courseList = cs.findAllCourses();
		req.setAttribute("courseList", courseList);
		req.setAttribute("questionList", questionList);
		req.getRequestDispatcher("teacher/questionmanage.jsp").forward(req, resp);
	}
}