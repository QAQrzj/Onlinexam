<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>班级成绩汇总 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">班级成绩汇总</h2>
		</div>
		<div style="height: 35px;"></div>
		<table class="ui celled small table center aligned">
			<thead class="full-width">
				<tr>
					<th>试卷名称</th>
					<th>考试科目</th>
					<th>考试班级</th>
					<th>所属方向</th>
					<th>考试截止时间</th>
					<th>班级平均分</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${paperList}">
					<tr>
						<td>${p.testName}</td>
						<td>${p.courseName}</td>
						<td>${p.className}</td>
						<td>${p.deptName}</td>
						<td>${p.endDate}</td>
						<td>${p.avgScore}分</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>