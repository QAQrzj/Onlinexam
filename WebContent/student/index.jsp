<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>近期考试 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">近期考试</h2>
		</div>
		<div style="height: 1px;"></div>
		<table class="ui celled small table center aligned">
			<thead class="full-width">
				<tr>
					<th>试卷名称</th>
					<th>考试科目</th>
					<th>考试截止时间</th>
					<th>考试时长</th>
					<th>总分</th>
					<th>考试状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="t" items="${testList}">
					<tr>
						<td>${t.testName}</td>
						<td>${t.courseName}</td>
						<td>${t.endDate}</td>
						<td>${t.testTime}分钟</td>
						<td>${t.scores}分</td>
						<td>正在考试</td>
						<td><button class="ui green mini labeled icon button"
								name="write" id="${t.id}">
								<i class="write icon"></i>开始考试
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		$('[name="write"]').click(function() {
			$(window).attr('location', 'studentTest?id=' + $(this).attr('id'));
		});
	</script>
	<%@ include file="../footer.jsp"%>
</body>
</html>