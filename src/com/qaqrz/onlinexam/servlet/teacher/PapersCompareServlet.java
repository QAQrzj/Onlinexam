package com.qaqrz.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.Teacher;
import com.qaqrz.onlinexam.service.teacher.IPaperService;
import com.qaqrz.onlinexam.service.teacher.PaperService;

@WebServlet("/papersCompare")
public class PapersCompareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IPaperService ps = new PaperService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher t = (Teacher) req.getSession().getAttribute("user");
		req.setAttribute("paperList", ps.getPaperCompare(t.getId()));
		req.getRequestDispatcher("teacher/classpapers.jsp").forward(req, resp);
	}
}