package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.service.admin.ICourseService;
import com.qaqrz.onlinexam.service.admin.CourseService;

@WebServlet("/courseAdd")
public class CourseAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService ts = new CourseService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ts.addCourse(req.getParameter("coursename"));
		resp.sendRedirect("courseQuery");
	}
}