package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.qaqrz.onlinexam.po.Student;
import com.qaqrz.onlinexam.service.admin.IStudentService;
import com.qaqrz.onlinexam.service.admin.StudentService;

@WebServlet("/studentAdd")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentService ss = new StudentService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s = new Student(req.getParameter("studentname"), DigestUtils.sha512Hex(req.getParameter("password")),
				req.getParameter("school"), req.getParameter("sex"), Date.valueOf(req.getParameter("born")),
				Integer.valueOf(req.getParameter("classid")));
		ss.addStudent(s);
		resp.sendRedirect("studentQuery");
	}
}