package com.qaqrz.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.Student;
import com.qaqrz.onlinexam.service.teacher.IPaperService;
import com.qaqrz.onlinexam.service.teacher.PaperService;

@WebServlet("/pastTest")
public class PastTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPaperService ps = new PaperService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s = (Student) req.getSession().getAttribute("user");
		List<?> paperList = ps.getPaperByStudentId(s.getId());
		req.setAttribute("user", s);
		req.setAttribute("paperList", paperList);
		req.getRequestDispatcher("student/history.jsp").forward(req, resp);
	}
}