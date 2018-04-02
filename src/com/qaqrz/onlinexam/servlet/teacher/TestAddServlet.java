package com.qaqrz.onlinexam.servlet.teacher;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.Course;
import com.qaqrz.onlinexam.po.Teacher;
import com.qaqrz.onlinexam.po.Test;
import com.qaqrz.onlinexam.service.admin.CourseService;
import com.qaqrz.onlinexam.service.admin.ICourseService;
import com.qaqrz.onlinexam.service.admin.IStudentClassService;
import com.qaqrz.onlinexam.service.admin.StudentClassService;
import com.qaqrz.onlinexam.service.teacher.IQuestionService;
import com.qaqrz.onlinexam.service.teacher.QuestionService;
import com.qaqrz.onlinexam.util.ToolUtil;

@WebServlet("/testAdd")
public class TestAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService cs = new CourseService();
	private IStudentClassService scs = new StudentClassService();
	private IQuestionService qs = new QuestionService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int courseId = Integer.valueOf(req.getParameter("testcourseid"));
		String classIds = ToolUtil.arraytoString(req.getParameterValues("classcheck"));
		List<Map<String, Object>> queList = qs.collectQuestions(courseId, Integer.valueOf(req.getParameter("sinnum")));
		if (queList.size() < 1)
			resp.sendRedirect("testQuery");
		Test t = new Test(req.getParameter("testname"), courseId,
				Timestamp.valueOf(req.getParameter("enddate") + " 00:00:00"),
				Integer.valueOf(req.getParameter("testtime")), qs.testQuestionIds(queList),
				((Teacher) req.getSession().getAttribute("user")).getId(), classIds,
				Double.valueOf(req.getParameter("sinscores")));
		Course c = cs.findCourseById(courseId);
		req.setAttribute("classNames", scs.findClassNamesByIds(classIds));
		req.getSession().setAttribute("test", t);
		req.setAttribute("questionList", queList);
		req.setAttribute("c", c);
		req.getRequestDispatcher("teacher/test.jsp").forward(req, resp);
	}
}