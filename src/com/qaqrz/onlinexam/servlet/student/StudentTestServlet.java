package com.qaqrz.onlinexam.servlet.student;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qaqrz.onlinexam.po.Paper;
import com.qaqrz.onlinexam.po.Question;
import com.qaqrz.onlinexam.po.Student;
import com.qaqrz.onlinexam.service.teacher.IPaperService;
import com.qaqrz.onlinexam.service.teacher.IQuestionService;
import com.qaqrz.onlinexam.service.teacher.ITestService;
import com.qaqrz.onlinexam.service.teacher.PaperService;
import com.qaqrz.onlinexam.service.teacher.QuestionService;
import com.qaqrz.onlinexam.service.teacher.TestService;
import com.qaqrz.onlinexam.util.ToolUtil;

@WebServlet("/studentTest")
public class StudentTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ITestService ts = new TestService();
	IQuestionService qs = new QuestionService();
	IPaperService ps = new PaperService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s = (Student) req.getSession().getAttribute("user");
		Map<String, Object> test = ts.findStudentTestsById(s.getId(), Integer.valueOf(req.getParameter("id")));
		List<Question> questionList = qs.findQuestionByIds(test.get("questions").toString());
		req.getSession().setAttribute("test", test);
		req.getSession().setAttribute("questionList", questionList);
		req.setAttribute("scoreperquestion", Double.valueOf(test.get("scores").toString()) / questionList.size());
		Date time = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		req.setAttribute("time", sdf.format(time.getTime() + Long.valueOf(test.get("testTime").toString()) * 60000));
		req.getRequestDispatcher("student/exam.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<?> questionList = (List<?>) req.getSession().getAttribute("questionList");
		Map<?, ?> testMap = (Map<?, ?>) req.getSession().getAttribute("test");
		StringBuffer wrongQueId = new StringBuffer();
		StringBuffer wrongAns = new StringBuffer();
		int wrongQueNum = 0;
		for (int i = 0; i < questionList.size(); i++) {
			Question q = (Question) questionList.get(i);
			String ans = req.getParameter("ques_" + q.getId());
			if (!q.getAns().equals(ans)) {
				wrongQueId.append(q.getId()).append((i < questionList.size() - 1) ? "," : "");
				wrongAns.append(ans).append((i < questionList.size() - 1) ? "," : "");
				wrongQueNum++;
			}
		}
		Paper p = new Paper(Integer.valueOf(testMap.get("id").toString()),
				Integer.valueOf(testMap.get("courseId").toString()), req.getParameter("time"),
				Double.valueOf(testMap.get("scores").toString()) * (questionList.size() - wrongQueNum)
						/ questionList.size(),
				wrongQueId.toString(), wrongAns.toString(), ((Student) req.getSession().getAttribute("user")).getId());
		ps.save(p);
		resp.sendRedirect("recentTest");
	}
}