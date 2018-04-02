package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.service.admin.IStudentClassService;
import com.qaqrz.onlinexam.service.admin.StudentClassService;

@WebServlet("/studentClassDelete")
public class StudentClassDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentClassService scs = new StudentClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		scs.deleteStudentClassById(Integer.valueOf(req.getParameter("id")));
		resp.sendRedirect("studentClassQuery");
	}
}