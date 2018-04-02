<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>教师管理 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">教师管理</h2>
		</div>
		<div class="ui small action input">
			<input type="text" id="searchteachername" placeholder="模糊搜索">
			<button class="ui icon button" id="search">
				<i class="search icon"></i>
			</button>
		</div>
		<div class="ui right floated primary labeled icon button"
			id="addteacher">
			<i class="add user icon"></i>添加教师
		</div>
		<table class="ui celled small table center aligned">
			<thead class="full-width">
				<tr>
					<th>教工号</th>
					<th>教师姓名</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="t" items="${teacherList}">
					<tr>
						<td>${t.id}</td>
						<td>${t.teacherName}</td>
						<td><button class="ui green mini labeled icon button"
								name="modify" id="${t.id}">
								<i class="edit icon"></i>修改
							</button></td>
						<td><button class="ui red mini labeled icon button"
								name="delete" id="${t.id}">
								<i class="remove user icon"></i>删除
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="ui standard modal transition hidden" id="add">
		<div class="header">添加教师</div>
		<div class="content">
			<form class="ui form" method="post" action="teacherAdd" id="addform">
				<div class="field">
					<label>姓名</label>
					<div class="ui left icon input">
						<i class="user icon"></i> <input type="text" name="teachername"
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
		<form class="ui form" action="teacherDelete" id="deleteform">
			<input type="hidden" name="id" id="deleteid" />
		</form>
		<div class="header">删除教师</div>
		<div class="content">
			<p>确定删除这名教师吗?</p>
		</div>
		<div class="actions">
			<div class="ui black deny button">取消</div>
			<div class="ui positive right labeled icon button">
				删除 <i class="checkmark icon"></i>
			</div>
		</div>
	</div>
	<script>
		$('#search').click(
				function() {
					$(window).attr(
							'location',
							'teacherQuery?searchteachername='
									+ $('#searchteachername').val());
				});
		$('#addteacher').click(function() {
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
							'teacherModify?id=' + $(this).attr('id'));
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