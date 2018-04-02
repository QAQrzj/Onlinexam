package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.Course;
import com.qaqrz.onlinexam.service.admin.CourseService;
import com.qaqrz.onlinexam.service.admin.ICourseService;

@WebServlet("/courseModify")
public class CourseModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService cs = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Course course = cs.findCourseById(Integer.valueOf(req.getParameter("id")));
		req.setAttribute("course", course);
		req.getRequestDispatcher("admin/coursemodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Course c = new Course(Integer.valueOf(req.getParameter("courseid")), req.getParameter("coursename"));
		cs.updateCourse(c);
		resp.sendRedirect("courseQuery");
	}
}