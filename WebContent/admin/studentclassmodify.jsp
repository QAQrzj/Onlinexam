<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>修改班级信息 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui main text container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">修改班级信息</h2>
		</div>
		<div style="height: 25px;"></div>
		<form class="ui form" method="post" action="studentClassModify">
			<div class="field">
				<label>班级编号</label>
				<div class="ui left icon disabled input">
					<i class="pin icon"></i> <input type="text" name="studentclassid"
						value="${studentClass.id}" />
				</div>
			</div>
			<div class="field">
				<label>班级名称</label>
				<div class="ui left icon input">
					<i class="users icon"></i> <input type="text" name="classname"
						value="${studentClass.className}" placeholder="班级名称" />
				</div>
			</div>
			<div class="field">
				<label>所属方向</label>
				<div class="ui fluid selection dropdown">
					<input type="hidden" name="deptname"> <i
						class="dropdown icon"></i>
					<div class="default text">
						<i class="cubes icon"></i>所属方向
					</div>
					<div class="menu">
						<c:forEach var="dept" items="${deptList}">
							<c:choose>
								<c:when test="${dept.name()==studentClass.deptName}">
									<div class="item selected" data-value="${dept}">
										<i class="cube icon"></i>${dept}
									</div>
								</c:when>
								<c:otherwise>
									<div class="item" data-value="${dept}">
										<i class="cube icon"></i>${dept}
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
			$(window).attr('location', 'studentClassQuery');
		});
	</script>
	<%@ include file="../footer.jsp"%>
</body>
</html>