package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.service.admin.ITeacherService;
import com.qaqrz.onlinexam.service.admin.TeacherService;

@WebServlet("/teacherDelete")
public class TeacherDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITeacherService scs = new TeacherService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		scs.deleteTeacherById(Integer.valueOf(req.getParameter("id")));
		resp.sendRedirect("teacherQuery");
	}
}