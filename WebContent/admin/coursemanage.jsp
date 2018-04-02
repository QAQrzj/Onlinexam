<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>课程管理 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">课程管理</h2>
		</div>
		<div class="ui right floated primary labeled icon button"
			id="addcourse">
			<i class="add icon"></i>添加课程
		</div>
		<div style="height: 35px;"></div>
		<table class="ui celled small table center aligned">
			<thead class="full-width">
				<tr>
					<th>课程编号</th>
					<th>课程名称</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${courseList}">
					<tr>
						<td>${c.id}</td>
						<td>${c.courseName}</td>
						<td><button class="ui green mini labeled icon button"
								name="modify" id="${c.id}">
								<i class="edit icon"></i>修改
							</button></td>
						<td><button class="ui red mini labeled icon button"
								name="delete" id="${c.id}">
								<i class="remove icon"></i>删除
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="ui standard modal transition hidden" id="add">
		<div class="header">添加课程</div>
		<div class="content">
			<form class="ui form" method="post" action="courseAdd" id="addform">
				<div class="field">
					<label>课程名称</label>
					<div class="ui left icon input">
						<i class="book icon"></i> <input type="text" name="coursename"
							placeholder="课程名称" />
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
		<form class="ui form" action="courseDelete" id="deleteform">
			<input type="hidden" name="id" id="deleteid" />
		</form>
		<div class="header">删除课程</div>
		<div class="content">
			<p>确定删除这个课程吗?</p>
		</div>
		<div class="actions">
			<div class="ui black deny button">取消</div>
			<div class="ui positive right labeled icon button">
				删除 <i class="checkmark icon"></i>
			</div>
		</div>
	</div>
	<script>
		$('#addcourse').click(function() {
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
							'courseModify?id=' + $(this).attr('id'));
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