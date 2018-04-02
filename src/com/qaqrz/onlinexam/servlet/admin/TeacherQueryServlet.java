package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.service.admin.ITeacherService;
import com.qaqrz.onlinexam.service.admin.TeacherService;

@WebServlet("/teacherQuery")
public class TeacherQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITeacherService ts = new TeacherService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String teacherName = req.getParameter("searchteachername");
		if (null == teacherName)
			teacherName = "";
		List<?> teacherList = ts.findTeachers(teacherName);
		req.setAttribute("teacherList", teacherList);
		req.getRequestDispatcher("admin/teachermanage.jsp").forward(req, resp);
	}
}