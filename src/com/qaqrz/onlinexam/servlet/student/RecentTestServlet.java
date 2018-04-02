package com.qaqrz.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.Student;
import com.qaqrz.onlinexam.service.teacher.ITestService;
import com.qaqrz.onlinexam.service.teacher.TestService;

@WebServlet("/recentTest")
public class RecentTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ITestService ts = new TestService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s = (Student) req.getSession().getAttribute("user");
		List<Map<String, Object>> testList = ts.getTestByStudent(s.getId());
		req.setAttribute("testList", testList);
		req.getRequestDispatcher("student/index.jsp").forward(req, resp);
	}
}