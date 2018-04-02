<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>修改学生信息 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui main text container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">修改学生信息</h2>
		</div>
		<div style="height: 25px;"></div>
		<form class="ui form" method="post" action="studentModify">
			<div class="field">
				<label>学号</label>
				<div class="ui left icon disabled input">
					<i class="pin icon"></i> <input type="text" name="studentid"
						value="${student.id}" />
				</div>
			</div>
			<div class="field">
				<label>姓名</label>
				<div class="ui left icon input">
					<i class="student icon"></i> <input type="text" name="studentname"
						value="${student.studentName}" placeholder="姓名" />
				</div>
			</div>
			<div class="field">
				<label>密码</label>
				<div class="ui left icon input">
					<i class="lock icon"></i> <input type="text" name="password"
						placeholder="密码" />
				</div>
			</div>
			<div class="field">
				<label>学院</label>
				<div class="ui left icon input">
					<i class="university icon"></i> <input type="text" name="school"
						value="${student.school}" placeholder="学院" />
				</div>
			</div>
			<div class="field">
				<label>性别</label>
				<div class="inline fields">
					<div class="field">
						<c:choose>
							<c:when test="${student.sex=='男'}">
								<div class="ui radio checkbox">
									<input type="radio" name="sex" value="男" checked="checked" />
									<label>男</label>
								</div>
							</c:when>
							<c:otherwise>
								<div class="ui radio checkbox">
									<input type="radio" name="sex" value="男" /> <label>男</label>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="field">
						<c:choose>
							<c:when test="${student.sex=='女'}">
								<div class="ui radio checkbox">
									<input type="radio" name="sex" value="女" checked="checked" />
									<label>女</label>
								</div>
							</c:when>
							<c:otherwise>
								<div class="ui radio checkbox">
									<input type="radio" name="sex" value="女" /> <label>女</label>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<div class="field">
				<label>出生日期</label>
				<div class="ui left icon input">
					<i class="calendar icon"></i> <input type="date" name="born"
						value="${student.born}" />
				</div>
			</div>
			<div class="field">
				<label>所属班级</label>
				<div class="ui fluid selection dropdown">
					<input type="hidden" name="classid"> <i
						class="dropdown icon"></i>
					<div class="default text">
						<i class="users icon"></i>所属班级
					</div>
					<div class="menu">
						<c:forEach var="sc" items="${studentClassList}">
							<c:choose>
								<c:when test="${sc.id==student.classId}">
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
			$(window).attr('location', 'studentQuery');
		});
	</script>
	<%@ include file="../footer.jsp"%>
</body>
</html>