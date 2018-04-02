package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.service.admin.IStudentService;
import com.qaqrz.onlinexam.service.admin.StudentService;

@WebServlet("/studentDelete")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentService ss = new StudentService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ss.deleteStudentById(Integer.valueOf(req.getParameter("id")));
		resp.sendRedirect("studentQuery");
	}
}