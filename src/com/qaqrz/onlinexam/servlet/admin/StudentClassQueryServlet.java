package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.service.admin.IStudentClassService;
import com.qaqrz.onlinexam.service.admin.StudentClassService;
import com.qaqrz.onlinexam.util.Department;

@WebServlet("/studentClassQuery")
public class StudentClassQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentClassService scs = new StudentClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<?> studentClassList = scs.findAll();
		req.setAttribute("studentClassList", studentClassList);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("admin/studentclassmanage.jsp").forward(req, resp);
	}
}