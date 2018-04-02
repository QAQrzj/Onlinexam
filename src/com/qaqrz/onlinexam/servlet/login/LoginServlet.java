package com.qaqrz.onlinexam.servlet.login;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.qaqrz.onlinexam.po.Student;
import com.qaqrz.onlinexam.po.Teacher;
import com.qaqrz.onlinexam.service.login.ILoginService;
import com.qaqrz.onlinexam.service.login.LoginService;
import com.qaqrz.onlinexam.util.DBDataSource;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILoginService ls = new LoginService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = DigestUtils.sha512Hex(req.getParameter("password"));
		if ("admin".equals(req.getParameter("role"))) {
			try {
				Properties config = new Properties();
				config.load(new FileReader(DBDataSource.class.getClassLoader().getResource("db.properties").getPath()));
				if (username.equals(config.getProperty("adminUsername"))
						&& DigestUtils.sha512Hex(config.getProperty("adminPassword")).equals(password)) {
					req.getSession().setAttribute("user", username);
					req.getSession().setAttribute("role", "admin");
					resp.sendRedirect("admin");
				} else {
					resp.sendRedirect("login");
				}
			} catch (Exception e) {
				resp.sendRedirect("login");
				e.printStackTrace();
			}
		} else if ("teacher".equals(req.getParameter("role"))) {
			Teacher t = new Teacher(username, password);
			t = ls.canLogin(t);
			if (null != t) {
				req.getSession().setAttribute("user", t);
				req.getSession().setAttribute("role", "teacher");
				resp.sendRedirect("teacher");
			} else {
				resp.sendRedirect("login");
			}
		} else if ("student".equals(req.getParameter("role"))) {
			Student s = new Student(username, password);
			s = ls.canLogin(s);
			if (null != s) {
				req.getSession().setAttribute("user", s);
				req.getSession().setAttribute("role", "student");
				resp.sendRedirect("student");
			} else {
				resp.sendRedirect("login");
			}
		}
	}
}