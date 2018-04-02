<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>题库管理 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">题库管理</h2>
		</div>
		<div class="ui small action input">
			<input type="text" id="searchname" placeholder="搜索"> <select
				class="ui compact selection dropdown" id="searchtype">
				<option value="courseName">课程名称</option>
				<option value="queTitle">试题题目</option>
			</select>
			<button class="ui icon button" id="search">
				<i class="search icon"></i>
			</button>
		</div>
		<div class="ui right floated primary labeled icon button"
			id="addquestion">
			<i class="add icon"></i>添加试题
		</div>
		<table class="ui celled small table center aligned">
			<thead class="full-width">
				<tr>
					<th>题号</th>
					<th>考试科目</th>
					<th>试题类型</th>
					<th>题目</th>
					<th>选项</th>
					<th>答案</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="q" items="${questionList}">
					<tr>
						<td>${q.id}</td>
						<td>${q.courseName}</td>
						<td>单项选择题</td>
						<td class="left aligned">${q.queTitle}</td>
						<td class="left aligned">
							<p>A. ${q.choiceA}</p>
							<p>B. ${q.choiceB}</p>
							<p>C. ${q.choiceC}</p>
							<p>D. ${q.choiceD}</p>
						</td>
						<td>${q.ans}</td>
						<td><button class="ui green mini labeled icon button"
								name="modify" id="${q.id}">
								<i class="edit icon"></i>修改
							</button></td>
						<td><button class="ui red mini labeled icon button"
								name="delete" id="${q.id}">
								<i class="remove icon"></i>删除
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="ui standard modal transition hidden" id="add">
		<div class="header">添加试题</div>
		<div class="content">
			<form class="ui form" method="post" action="questionAdd" id="addform">
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
							name="queTitle" placeholder="题目" />
					</div>
				</div>
				<div class="field">
					<label>选项A</label>
					<div class="ui left icon input">
						<i class="write icon"></i> <input type="text" name="choiceA"
							placeholder="选项A" />
					</div>
				</div>
				<div class="field">
					<label>选项B</label>
					<div class="ui left icon input">
						<i class="write icon"></i> <input type="text" name="choiceB"
							placeholder="选项B" />
					</div>
				</div>
				<div class="field">
					<label>选项C</label>
					<div class="ui left icon input">
						<i class="write icon"></i> <input type="text" name="choiceC"
							placeholder="选项C" />
					</div>
				</div>
				<div class="field">
					<label>选项D</label>
					<div class="ui left icon input">
						<i class="write icon"></i> <input type="text" name="choiceD"
							placeholder="选项D" />
					</div>
				</div>
				<div class="field">
					<label>答案</label>
					<div class="ui left icon input">
						<i class="tag icon"></i> <input type="text" name="ans"
							placeholder="答案" />
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
		<form class="ui form" action="questionDelete" id="deleteform">
			<input type="hidden" name="id" id="deleteid" />
		</form>
		<div class="header">删除试题</div>
		<div class="content">
			<p>确定删除这个试题吗?</p>
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
							'questionQuery?searchtype='
									+ $('#searchtype').val() + '&searchname='
									+ $('#searchname').val());
				});
		$('#addquestion').click(function() {
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
							'questionModify?id=' + $(this).attr('id'));
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