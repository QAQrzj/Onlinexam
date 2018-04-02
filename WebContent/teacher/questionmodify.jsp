<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>修改试题信息 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui main text container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">修改试题信息</h2>
		</div>
		<div style="height: 25px;"></div>
		<form class="ui form" method="post" action="questionModify">
			<div class="field">
				<label>试题编号</label>
				<div class="ui left icon disabled input">
					<i class="pin icon"></i> <input type="text" name="questionid"
						value="${questionMap.id}" />
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
								<c:when test="${questionMap.courseId==c.id}">
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
				<label>试题类型</label>
				<div class="ui fluid selection dropdown">
					<input type="hidden" name="queType"> <i
						class="dropdown icon"></i>
					<div class="default text">
						<i class="flag icon"></i>试题类型
					</div>
					<div class="menu">
						<div class="item selected" data-value="1">
							<i class="flag icon"></i>单项选择题
						</div>
					</div>
				</div>
			</div>
			<div class="field">
				<label>题目</label>
				<div class="ui left icon input">
					<i class="write square icon"></i> <input type="text"
						name="queTitle" value="${questionMap.queTitle}" placeholder="题目" />
				</div>
			</div>
			<div class="field">
				<label>选项A</label>
				<div class="ui left icon input">
					<i class="write icon"></i> <input type="text" name="choiceA"
						value="${questionMap.choiceA}" placeholder="选项A" />
				</div>
			</div>
			<div class="field">
				<label>选项B</label>
				<div class="ui left icon input">
					<i class="write icon"></i> <input type="text" name="choiceB"
						value="${questionMap.choiceB}" placeholder="选项B" />
				</div>
			</div>
			<div class="field">
				<label>选项C</label>
				<div class="ui left icon input">
					<i class="write icon"></i> <input type="text" name="choiceC"
						value="${questionMap.choiceC}" placeholder="选项C" />
				</div>
			</div>
			<div class="field">
				<label>选项D</label>
				<div class="ui left icon input">
					<i class="write icon"></i> <input type="text" name="choiceD"
						value="${questionMap.choiceD}" placeholder="选项D" />
				</div>
			</div>
			<div class="field">
				<label>答案</label>
				<div class="ui left icon input">
					<i class="tag icon"></i> <input type="text" name="ans"
						value="${questionMap.ans}" placeholder="答案" />
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
			$(window).attr('location', 'questionQuery');
		});
	</script>
	<%@ include file="../footer.jsp"%>
</body>
</html>