<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>班级管理 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">班级管理</h2>
		</div>
		<div class="ui right floated primary labeled icon button"
			id="addclass">
			<i class="add icon"></i>添加班级
		</div>
		<div style="height: 35px;"></div>
		<table class="ui celled small table center aligned">
			<thead class="full-width">
				<tr>
					<th>班级编号</th>
					<th>班级名称</th>
					<th>所属方向</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sc" items="${studentClassList}">
					<tr>
						<td>${sc.id}</td>
						<td>${sc.className}</td>
						<td>${sc.deptName}</td>
						<td><button class="ui green mini labeled icon button"
								name="modify" id="${sc.id}">
								<i class="edit icon"></i>修改
							</button></td>
						<td><button class="ui red mini labeled icon button"
								name="delete" id="${sc.id}">
								<i class="remove icon"></i>删除
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="ui standard modal transition hidden" id="add">
		<div class="header">添加班级</div>
		<div class="content">
			<form class="ui form" method="post" action="studentClassAdd"
				id="addform">
				<div class="field">
					<label>班级名称</label>
					<div class="ui left icon input">
						<i class="users icon"></i> <input type="text" name="classname"
							placeholder="班级名称" />
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
								<div class="item" data-value="${dept}">
									<i class="cube icon"></i>${dept}
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
		<form class="ui form" action="studentClassDelete" id="deleteform">
			<input type="hidden" name="id" id="deleteid" />
		</form>
		<div class="header">删除班级</div>
		<div class="content">
			<p>确定删除这个班级吗?</p>
		</div>
		<div class="actions">
			<div class="ui black deny button">取消</div>
			<div class="ui positive right labeled icon button">
				删除 <i class="checkmark icon"></i>
			</div>
		</div>
	</div>
	<script>
		$('#addclass').click(function() {
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
							'studentClassModify?id=' + $(this).attr('id'));
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