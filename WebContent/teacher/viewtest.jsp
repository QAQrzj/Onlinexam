<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>考试详细信息 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui main text container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">考试详细信息</h2>
		</div>
		<div style="height: 13px;"></div>
		<div class="ui">
			<table class="ui celled small table center aligned">
				<tr>
					<td>试卷编号: ${test.id}</td>
					<td>试卷名称: ${test.testName}</td>
					<td>考试科目: ${test.courseName}</td>
					<td>考试班级: ${test.classNames}</td>
				</tr>
				<tr>
					<td>考试时长: ${test.testTime}分钟</td>
					<td>总分: ${test.scores}分</td>
					<td colspan="2">考试截止时间: ${test.endDate}</td>
				</tr>
			</table>
		</div>
		<div style="height: 30px;"></div>
		<div>
			<table class="ui celled small table">
				<thead class="full-width">
					<tr>
						<th>单项选择题</th>
					</tr>
				</thead>
				<c:forEach var="que" items="${questionList}" varStatus="status">
					<tr>
						<td><label class="ui circular label">${status.index + 1}</label>
							<label>${que.queTitle}</label>
							<ul class="ui list">
								<li>A. ${que.choiceA}</li>
								<li>B. ${que.choiceB}</li>
								<li>C. ${que.choiceC}</li>
								<li>D. ${que.choiceD}</li>
							</ul>
							<div class="ui blue label">答案: ${que.ans}</div></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div style="height: 20px;"></div>
		<div class="actions">
			<div class="ui right floated green right labeled icon button"
				id="return">
				返回<i class="arrow left icon"></i>
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<script>
		$('#return').click(function() {
			$(window).attr('location', 'testQuery');
		});
	</script>
	<%@ include file="../footer.jsp"%>
</body>
</html>