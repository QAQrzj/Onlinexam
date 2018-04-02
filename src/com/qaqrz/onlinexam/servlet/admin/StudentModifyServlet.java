package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.qaqrz.onlinexam.po.Student;
import com.qaqrz.onlinexam.service.admin.StudentService;
import com.qaqrz.onlinexam.service.admin.IStudentClassService;
import com.qaqrz.onlinexam.service.admin.IStudentService;
import com.qaqrz.onlinexam.service.admin.StudentClassService;

@WebServlet("/studentModify")
public class StudentModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentService ss = new StudentService();
	private IStudentClassService scs = new StudentClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = ss.findStudentById(Integer.valueOf(req.getParameter("id")));
		List<?> studentClassList = scs.findAll();
		req.setAttribute("studentClassList", studentClassList);
		req.setAttribute("student", student);
		req.getRequestDispatcher("admin/studentmodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s = new Student(Integer.valueOf(req.getParameter("studentid")), req.getParameter("studentname"),
				DigestUtils.sha512Hex(req.getParameter("password")), req.getParameter("school"),
				req.getParameter("sex"), Date.valueOf(req.getParameter("born")),
				Integer.valueOf(req.getParameter("classid")));
		ss.updateStudent(s);
		resp.sendRedirect("studentQuery");
	}
}