package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.StudentClass;
import com.qaqrz.onlinexam.service.admin.IStudentClassService;
import com.qaqrz.onlinexam.service.admin.StudentClassService;
import com.qaqrz.onlinexam.util.Department;

@WebServlet("/studentClassModify")
public class StudentClassModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentClassService scs = new StudentClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> studentClassMap = scs.findStudentClassById(Integer.valueOf(req.getParameter("id")));
		req.setAttribute("studentClass", studentClassMap);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("admin/studentclassmodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentClass sc = new StudentClass(Integer.valueOf(req.getParameter("studentclassid")),
				req.getParameter("classname"), req.getParameter("deptname"));
		scs.updateStudentClass(sc);
		resp.sendRedirect("studentClassQuery");
	}
}