package com.qaqrz.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.Test;
import com.qaqrz.onlinexam.service.teacher.ITestService;
import com.qaqrz.onlinexam.service.teacher.TestService;

@WebServlet("/testCreate")
public class TestCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITestService ts = new TestService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Test test = (Test) req.getSession().getAttribute("test");
		ts.createTest(test);
		req.getSession().removeAttribute("test");
		resp.sendRedirect("testQuery");
	}
}