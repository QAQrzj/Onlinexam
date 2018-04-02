<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>修改课程信息 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui main text container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">修改课程信息</h2>
		</div>
		<div style="height: 25px;"></div>
		<form class="ui form" method="post" action="courseModify">
			<div class="field">
				<label>课程编号</label>
				<div class="ui left icon disabled input">
					<i class="pin icon"></i> <input type="text" name="courseid"
						value="${course.id}" />
				</div>
			</div>
			<div class="field">
				<label>课程名称</label>
				<div class="ui left icon input">
					<i class="book icon"></i> <input type="text" name="coursename"
						value="${course.courseName}" placeholder="课程名称" />
				</div>
			</div>
			<div class="ui error message"></div>
		</form>
		<div style="height: 20px;"></div>
		<div class="actions">
			<div class="ui right floated green right labeled icon button"
				id="modify">
				修改<i class="checkmark icon"></i>
			</div>
			<div class="ui right floated black button" id="cancel">取消</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<script>
		$('#modify').click(function() {
			$('.ui.form').submit();
		});
		$('#cancel').click(function() {
			$(window).attr('location', 'courseQuery');
		});
	</script>
	<%@ include file="../footer.jsp"%>
</body>
</html>