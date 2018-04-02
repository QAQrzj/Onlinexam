package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.service.admin.ICourseService;
import com.qaqrz.onlinexam.service.admin.IStudentClassService;
import com.qaqrz.onlinexam.service.admin.ITeacherService;
import com.qaqrz.onlinexam.service.admin.StudentClassService;
import com.qaqrz.onlinexam.service.admin.TeacherService;
import com.qaqrz.onlinexam.service.admin.CourseService;

@WebServlet("/scheduleQuery")
public class ScheduleQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService cs = new CourseService();
	private ITeacherService ts = new TeacherService();
	private IStudentClassService scs = new StudentClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<?> teacherCourseViewList = cs.findAll();
		List<?> studentClassList = scs.findAll();
		List<?> courseList = cs.findAllCourses();
		List<?> teacherList = ts.findTeachers("");
		req.setAttribute("courseList", courseList);
		req.setAttribute("teacherList", teacherList);
		req.setAttribute("studentClassList", studentClassList);
		req.setAttribute("teacherCourseViewList", teacherCourseViewList);
		req.getRequestDispatcher("admin/schedulemanage.jsp").forward(req, resp);
	}
}