package com.qaqrz.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.Question;
import com.qaqrz.onlinexam.service.admin.CourseService;
import com.qaqrz.onlinexam.service.admin.ICourseService;
import com.qaqrz.onlinexam.service.teacher.IQuestionService;
import com.qaqrz.onlinexam.service.teacher.QuestionService;

@WebServlet("/questionModify")
public class QuestionModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService cs = new CourseService();
	private IQuestionService qs = new QuestionService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<?> courseList = cs.findAllCourses();
		Map<String, Object> questionMap = qs.findQuestionById(Integer.valueOf(req.getParameter("id")));
		req.setAttribute("questionMap", questionMap);
		req.setAttribute("courseList", courseList);
		req.getRequestDispatcher("teacher/questionmodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Question q = new Question(Integer.valueOf(req.getParameter("questionid")),
				Integer.valueOf(req.getParameter("courseid")), Integer.valueOf(req.getParameter("queType")),
				req.getParameter("queTitle"), req.getParameter("choiceA"), req.getParameter("choiceB"),
				req.getParameter("choiceC"), req.getParameter("choiceD"), req.getParameter("ans"));
		qs.updateQuestionInfo(q);
		resp.sendRedirect("questionQuery");
	}
}