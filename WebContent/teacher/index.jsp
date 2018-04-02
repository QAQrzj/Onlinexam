<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>近期考试 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">近期考试</h2>
		</div>
		<div class="ui right floated primary labeled icon button" id="addtest">
			<i class="add icon"></i>发布试卷
		</div>
		<div style="height: 35px;"></div>
		<table class="ui celled small table center aligned">
			<thead class="full-width">
				<tr>
					<th>试卷编号</th>
					<th>试卷名称</th>
					<th>考试科目</th>
					<th>考试班级</th>
					<th>考试截止时间</th>
					<th>考试时长</th>
					<th>总分</th>
					<th>考试状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="t" items="${testList}">
					<tr>
						<td>${t.id}</td>
						<td>${t.testName}</td>
						<td>${t.courseName}</td>
						<td>${t.classNames}</td>
						<td>${t.endDate}</td>
						<td>${t.testTime}分钟</td>
						<td>${t.scores}分</td>
						<td>正在考试</td>
						<td><button class="ui green mini labeled icon button"
								name="view" id="${t.id}">
								<i class="dashboard icon"></i>详细信息
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="ui standard modal transition hidden" id="add">
		<div class="header">发布试卷</div>
		<div class="content">
			<form class="ui form" method="post" action="testAdd" id="addform">
				<div class="field">
					<label>试卷名称</label>
					<div class="ui left icon input">
						<i class="sticky note icon"></i> <input type="text"
							name="testname" placeholder="试卷名称" />
					</div>
				</div>
				<div class="field">
					<label>考试科目</label>
					<div class="ui fluid selection dropdown">
						<input type="hidden" name="testcourseid"> <i
							class="dropdown icon"></i>
						<div class="default text">
							<i class="book icon"></i>考试科目
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
					<label>考试班级</label>
					<c:forEach var="sc" items="${studentClassList}">
						<div class="ui checkbox">
							<input type="checkbox" name="classcheck" value="${sc.id}">
							<label>${sc.className}</label>
						</div>
					</c:forEach>
				</div>
				<div class="field">
					<label>截止时间</label>
					<div class="ui left icon input">
						<i class="calendar icon"></i> <input type="date" name="enddate" />
					</div>
				</div>
				<div class="field">
					<label>考试时长</label>
					<div class="ui left icon right labeled input">
						<i class="wait icon"></i> <input type="text" name="testtime"
							placeholder="考试时长" />
						<div class="ui basic label">分钟</div>
					</div>
				</div>
				<div class="field">
					<label>总分</label>
					<div class="ui left icon input">
						<i class="calculator icon"></i> <input type="text"
							name="sinscores" placeholder="总分" />
					</div>
				</div>
				<div class="field">
					<label>题目数量</label>
					<div class="ui left icon input">
						<i class="tags icon"></i> <input type="text" name="sinnum"
							placeholder="题目数量" />
					</div>
				</div>
				<div class="ui error message"></div>
			</form>
		</div>
		<div class="actions">
			<div class="ui black deny button">取消</div>
			<div class="ui green right labeled icon button" id="addbutton">
				自动组题<i class="checkmark icon"></i>
			</div>
		</div>
	</div>
	<script>
		$('#addtest').click(function() {
			$('#add').modal({
				blurring : true,
				autofocus : false
			}).modal('show');
		});
		$('#addbutton').click(function() {
			$('#addform').submit();
		});
		$('[name="view"]').click(
				function() {
					$(window).attr('location',
							'testDetailInfo?id=' + $(this).attr('id'));
				});
	</script>
	<%@ include file="../footer.jsp"%>
</body>
</html>