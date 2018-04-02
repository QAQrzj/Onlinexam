package com.qaqrz.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.qaqrz.onlinexam.po.Teacher;
import com.qaqrz.onlinexam.service.admin.ITeacherService;
import com.qaqrz.onlinexam.service.admin.TeacherService;
import com.qaqrz.onlinexam.util.Department;

@WebServlet("/teacherAdd")
public class TeacherAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITeacherService ts = new TeacherService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("admin/teacheradd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher t = new Teacher(req.getParameter("teachername"), DigestUtils.sha512Hex(req.getParameter("password")));
		ts.addTeacher(t);
		resp.sendRedirect("teacherQuery");
	}
}