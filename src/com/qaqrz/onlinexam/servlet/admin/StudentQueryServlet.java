package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.service.admin.IStudentClassService;
import com.qaqrz.onlinexam.service.admin.IStudentService;
import com.qaqrz.onlinexam.service.admin.StudentClassService;
import com.qaqrz.onlinexam.service.admin.StudentService;

@WebServlet("/studentQuery")
public class StudentQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentService ss = new StudentService();
	private IStudentClassService scs = new StudentClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<?> studentClassList = scs.findAll();
		List<?> studentList = ss.findAll();
		req.setAttribute("studentList", studentList);
		req.setAttribute("studentClassList", studentClassList);
		req.getRequestDispatcher("admin/studentmanage.jsp").forward(req, resp);
	}
}