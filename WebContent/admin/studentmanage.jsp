<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>学生管理 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">学生管理</h2>
		</div>
		<div class="ui right floated primary labeled icon button"
			id="addstudent">
			<i class="add user icon"></i>添加学生
		</div>
		<div style="height: 35px;"></div>
		<table class="ui celled small table center aligned">
			<thead class="full-width">
				<tr>
					<th>学号</th>
					<th>学生姓名</th>
					<th>学院</th>
					<th>所属方向</th>
					<th>性别</th>
					<th>出生日期</th>
					<th>所属班级</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${studentList}">
					<tr>
						<td>${s.id}</td>
						<td>${s.studentName}</td>
						<td>${s.school}</td>
						<td>${s.deptName}</td>
						<td>${s.sex}</td>
						<td>${s.born}</td>
						<td>${s.className}</td>
						<td><button class="ui green mini labeled icon button"
								name="modify" id="${s.id}">
								<i class="edit icon"></i>修改
							</button></td>
						<td><button class="ui red mini labeled icon button"
								name="delete" id="${s.id}">
								<i class="remove user icon"></i>删除
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="ui standard modal transition hidden" id="add">
		<div class="header">添加学生</div>
		<div class="content">
			<form class="ui form" method="post" action="studentAdd" id="addform">
				<div class="field">
					<label>姓名</label>
					<div class="ui left icon input">
						<i class="student icon"></i> <input type="text" name="studentname"
							placeholder="姓名" />
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
							placeholder="学院" />
					</div>
				</div>
				<div class="field">
					<label>性别</label>
					<div class="inline fields">
						<div class="field">
							<div class="ui radio checkbox">
								<input type="radio" name="sex" value="男" checked="checked" /> <label>男</label>
							</div>
						</div>
						<div class="field">
							<div class="ui radio checkbox">
								<input type="radio" name="sex" value="女" /> <label>女</label>
							</div>
						</div>
					</div>
				</div>
				<div class="field">
					<label>出生日期</label>
					<div class="ui left icon input">
						<i class="calendar icon"></i> <input type="date" name="born" />
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
		<form class="ui form" action="studentDelete" id="deleteform">
			<input type="hidden" name="id" id="deleteid" />
		</form>
		<div class="header">删除学生</div>
		<div class="content">
			<p>确定删除这名学生吗?</p>
		</div>
		<div class="actions">
			<div class="ui black deny button">取消</div>
			<div class="ui positive right labeled icon button">
				删除 <i class="checkmark icon"></i>
			</div>
		</div>
	</div>
	<script>
		$('#addstudent').click(function() {
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
							'studentModify?id=' + $(this).attr('id'));
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