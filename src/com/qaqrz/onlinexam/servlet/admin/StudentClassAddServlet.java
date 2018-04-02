package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.StudentClass;
import com.qaqrz.onlinexam.service.admin.IStudentClassService;
import com.qaqrz.onlinexam.service.admin.StudentClassService;
import com.qaqrz.onlinexam.util.Department;

@WebServlet("/studentClassAdd")
public class StudentClassAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentClassService scs = new StudentClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("admin/studentclassadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentClass sc = new StudentClass(req.getParameter("classname"), req.getParameter("deptname"));
		scs.addStudentClass(sc);
		resp.sendRedirect("studentClassQuery");
	}
}