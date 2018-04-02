package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.TeacherCourse;
import com.qaqrz.onlinexam.service.admin.CourseService;
import com.qaqrz.onlinexam.service.admin.ICourseService;
import com.qaqrz.onlinexam.service.admin.IStudentClassService;
import com.qaqrz.onlinexam.service.admin.ITeacherService;
import com.qaqrz.onlinexam.service.admin.StudentClassService;
import com.qaqrz.onlinexam.service.admin.TeacherService;

@WebServlet("/scheduleModify")
public class ScheduleModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService cs = new CourseService();
	private ITeacherService ts = new TeacherService();
	private IStudentClassService scs = new StudentClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<?> studentClassList = scs.findAll();
		List<?> courseList = cs.findAllCourses();
		List<?> teacherList = ts.findTeachers("");
		TeacherCourse teacherCourse = cs.findTeacherCourseById(Integer.valueOf(req.getParameter("id")));
		req.setAttribute("courseList", courseList);
		req.setAttribute("teacherList", teacherList);
		req.setAttribute("studentClassList", studentClassList);
		req.setAttribute("schedule", teacherCourse);
		req.getRequestDispatcher("admin/schedulemodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherCourse tc = new TeacherCourse(Integer.valueOf(req.getParameter("scheduleid")),
				Integer.valueOf(req.getParameter("courseid")), Integer.valueOf(req.getParameter("teacherid")),
				Integer.valueOf(req.getParameter("classid")));
		cs.modifyTeacherCourse(tc);
		resp.sendRedirect("scheduleQuery");
	}
}