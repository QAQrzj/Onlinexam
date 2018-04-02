package com.qaqrz.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.Teacher;
import com.qaqrz.onlinexam.service.admin.CourseService;
import com.qaqrz.onlinexam.service.admin.ICourseService;
import com.qaqrz.onlinexam.service.admin.IStudentClassService;
import com.qaqrz.onlinexam.service.admin.StudentClassService;
import com.qaqrz.onlinexam.service.teacher.ITestService;
import com.qaqrz.onlinexam.service.teacher.TestService;

@WebServlet("/testQuery")
public class TestQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITestService ts = new TestService();
	private ICourseService cs = new CourseService();
	private IStudentClassService scs = new StudentClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher t = (Teacher) req.getSession().getAttribute("user");
		List<Map<String, Object>> testList = ts.findTestsByTeaId(t.getId());
		req.setAttribute("studentClassList", scs.findStudentClassesByTeacherId(t.getId()));
		req.setAttribute("courseList", cs.findCoursesByTeacherId(t.getId()));
		req.setAttribute("testList", testList);
		req.getRequestDispatcher("teacher/index.jsp").forward(req, resp);
	}
}