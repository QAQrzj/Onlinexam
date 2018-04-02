<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>以往考试 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">以往考试</h2>
		</div>
		<div style="height: 1px;"></div>
		<table class="ui celled small table center aligned">
			<thead class="full-width">
				<tr>
					<th>试卷名称</th>
					<th>考试科目</th>
					<th>考试时长</th>
					<th>考试所用时长</th>
					<th>考试时间</th>
					<th>总分</th>
					<th>得分</th>
					<th>考试状态</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${paperList}">
					<tr>
						<td>${p.testName}</td>
						<td>${p.courseName}</td>
						<td>${p.testTime}分钟</td>
						<td>${p.time}</td>
						<td>${p.createDate}</td>
						<td>${p.scores}分</td>
						<td>${p.score}分</td>
						<td>已结束</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>