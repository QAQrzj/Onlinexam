<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>修改排课信息 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui main text container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">修改排课信息</h2>
		</div>
		<div style="height: 25px;"></div>
		<form class="ui form" method="post" action="scheduleModify">
			<div class="field">
				<label>排课编号</label>
				<div class="ui left icon disabled input">
					<i class="pin icon"></i> <input type="text" name="scheduleid"
						value="${schedule.id}" />
				</div>
			</div>
			<div class="field">
				<label>教师</label>
				<div class="ui fluid selection dropdown">
					<input type="hidden" name="teacherid"><i
						class="dropdown icon"></i>
					<div class="default text">
						<i class="user icon"></i>教师
					</div>
					<div class="menu">
						<c:forEach var="t" items="${teacherList}">
							<c:choose>
								<c:when test="${schedule.teacherId==t.id}">
									<div class="item selected" data-value="${t.id}">
										<i class="users icon"></i>${t.teacherName}
									</div>
								</c:when>
								<c:otherwise>
									<div class="item" data-value="${t.id}">
										<i class="users icon"></i>${t.teacherName}
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="field">
				<label>科目</label>
				<div class="ui fluid selection dropdown">
					<input type="hidden" name="courseid"><i
						class="dropdown icon"></i>
					<div class="default text">
						<i class="book icon"></i>科目
					</div>
					<div class="menu">
						<c:forEach var="c" items="${courseList}">
							<c:choose>
								<c:when test="${schedule.courseId==c.id}">
									<div class="item selected" data-value="${c.id}">
										<i class="users icon"></i>${c.courseName}
									</div>
								</c:when>
								<c:otherwise>
									<div class="item" data-value="${c.id}">
										<i class="users icon"></i>${c.courseName}
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="field">
				<label>班级</label>
				<div class="ui fluid selection dropdown">
					<input type="hidden" name="classid"><i
						class="dropdown icon"></i>
					<div class="default text">
						<i class="users icon"></i>班级
					</div>
					<div class="menu">
						<c:forEach var="sc" items="${studentClassList}">
							<c:choose>
								<c:when test="${schedule.classId==sc.id}">
									<div class="item selected" data-value="${sc.id}">
										<i class="users icon"></i>${sc.className}
									</div>
								</c:when>
								<c:otherwise>
									<div class="item" data-value="${sc.id}">
										<i class="users icon"></i>${sc.className}
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
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
			$(window).attr('location', 'scheduleQuery');
		});
	</script>
	<%@ include file="../footer.jsp"%>
</body>
</html>