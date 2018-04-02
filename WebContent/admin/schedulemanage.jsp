<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>排课管理 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">排课管理</h2>
		</div>
		<div class="ui right floated primary labeled icon button"
			id="addschedule">
			<i class="add icon"></i>添加排课
		</div>
		<div style="height: 35px;"></div>
		<table class="ui celled small table center aligned">
			<thead class="full-width">
				<tr>
					<th>排课编号</th>
					<th>教师姓名</th>
					<th>课程名称</th>
					<th>班级名称</th>
					<th>所属方向</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tcv" items="${teacherCourseViewList}">
					<tr>
						<td>${tcv.id}</td>
						<td>${tcv.teacherName}</td>
						<td>${tcv.courseName}</td>
						<td>${tcv.className}</td>
						<td>${tcv.deptName}</td>
						<td><button class="ui green mini labeled icon button"
								name="modify" id="${tcv.id}">
								<i class="edit icon"></i>修改
							</button></td>
						<td><button class="ui red mini labeled icon button"
								name="delete" id="${tcv.id}">
								<i class="remove icon"></i>删除
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="ui standard modal transition hidden" id="add">
		<div class="header">添加排课</div>
		<div class="content">
			<form class="ui form" method="post" action="scheduleAdd" id="addform">
				<div class="field">
					<label>教师</label>
					<div class="ui fluid selection dropdown">
						<input type="hidden" name="teacherid"> <i
							class="dropdown icon"></i>
						<div class="default text">
							<i class="user icon"></i>教师
						</div>
						<div class="menu">
							<c:forEach var="t" items="${teacherList}">
								<div class="item" data-value="${t.id}">
									<i class="user icon"></i>${t.teacherName}
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="field">
					<label>科目</label>
					<div class="ui fluid selection dropdown">
						<input type="hidden" name="courseid"> <i
							class="dropdown icon"></i>
						<div class="default text">
							<i class="book icon"></i>科目
						</div>
						<div class="menu">
							<c:forEach var="c" items="${courseList}">
								<div class="item" data-value="${c.id}">
									<i class="book icon"></i>${c.courseName}
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="field">
					<label>班级</label>
					<div class="ui fluid selection dropdown">
						<input type="hidden" name="classid"> <i
							class="dropdown icon"></i>
						<div class="default text">
							<i class="users icon"></i>班级
						</div>
						<div class="menu">
							<c:forEach var="sc" items="${studentClassList}">
								<div class="item" data-value="${sc.id}">
									<i class="users icon"></i>${sc.className}
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="ui error message"></div>
			</form>
		</div>
		<div class="actions">
			<div class="ui black deny button">取消</div>
			<div class="ui green right labeled icon button" id="addbutton">
				添加<i class="checkmark icon"></i>
			</div>
		</div>
	</div>
	<div class="ui mini modal transition hidden" id="delete">
		<form class="ui form" action="scheduleDelete" id="deleteform">
			<input type="hidden" name="id" id="deleteid" />
		</form>
		<div class="header">删除排课</div>
		<div class="content">
			<p>确定删除这个排课吗?</p>
		</div>
		<div class="actions">
			<div class="ui black deny button">取消</div>
			<div class="ui positive right labeled icon button">
				删除 <i class="checkmark icon"></i>
			</div>
		</div>
	</div>
	<script>
		$('#addschedule').click(function() {
			$('#add').modal({
				blurring : true,
				autofocus : false
			}).modal('show');
		});
		$('#addbutton').click(function() {
			$('#addform').submit();
		});
		$('[name="modify"]').click(
				function() {
					$(window).attr('location',
							'scheduleModify?id=' + $(this).attr('id'));
				});
		$('[name="delete"]').click(function() {
			$('#deleteid').attr('value', $(this).attr('id'));
			$('#delete').modal({
				blurring : true,
				autofocus : false,
				onApprove : function() {
					$('#deleteform').submit();
				}
			}).modal('show');
		});
	</script>
	<%@ include file="../footer.jsp"%>
</body>
</html>