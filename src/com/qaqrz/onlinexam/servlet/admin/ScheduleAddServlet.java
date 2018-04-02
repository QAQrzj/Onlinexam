package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.TeacherCourse;
import com.qaqrz.onlinexam.service.admin.CourseService;
import com.qaqrz.onlinexam.service.admin.ICourseService;

@WebServlet("/scheduleAdd")
public class ScheduleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService cs = new CourseService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherCourse tc = new TeacherCourse(Integer.valueOf(req.getParameter("courseid")),
				Integer.valueOf(req.getParameter("teacherid")), Integer.valueOf(req.getParameter("classid")));
		cs.addSchedule(tc);
		resp.sendRedirect("scheduleQuery");
	}
}