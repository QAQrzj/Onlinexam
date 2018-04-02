<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header_static.jsp"%>
<title>考试 - <%=siteTitle%></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="ui main text container middle aligned">
		<div class="ui center aligned header">
			<h2 class="ui header">${test.testName}</h2>
		</div>
		<div style="height: 13px;"></div>
		<div class="ui">
			<table class="ui celled small table center aligned">
				<tr>
					<td>考试科目: ${test.courseName}</td>
					<td>班级: ${test.className}</td>
				</tr>
				<tr>
					<td>考试时长: ${test.testTime}分钟</td>
					<td>总分: ${test.scores}分</td>
				</tr>
			</table>
		</div>
		<div style="height: 18px;"></div>
		<form class="ui form" method="post" action="studentTest"
			id="submitform">
			<input type="hidden" name="time" id="examtime" />
			<div class="right ui rail">
				<div class="ui sticky" style="z-index: -1;">
					<div style="height: 60px;"></div>
					<div class="ui compact red message">
						<h5 class="ui center aligned header">考试剩余时间</h5>
						<h2 class="ui center aligned header" id="time"></h2>
						<h5 class="ui center aligned header">考试结束将自动交卷</h5>
					</div>
				</div>
			</div>
			<div class="ui segment" id="timer">
				<table class="ui celled small table">
					<thead class="full-width">
						<tr>
							<th>单项选择题（${test.scores}分）（每小题${scoreperquestion}分，错选、未选均不得分。）</th>
						</tr>
					</thead>
					<c:forEach var="que" items="${questionList}" varStatus="status">
						<tr>
							<td><label class="ui circular label">${status.index + 1}</label>
								<label>${que.queTitle}</label>
								<div class="grouped fields">
									<div class="field">
										<div class="ui radio checkbox">
											<input type="radio" name="ques_${que.id}" value="A" /> <label>A.
												${que.choiceA}</label>
										</div>
									</div>
									<div class="field">
										<div class="ui radio checkbox">
											<input type="radio" name="ques_${que.id}" value="B" /> <label>B.
												${que.choiceB}</label>
										</div>
									</div>
									<div class="field">
										<div class="ui radio checkbox">
											<input type="radio" name="ques_${que.id}" value="C" /> <label>C.
												${que.choiceC}</label>
										</div>
									</div>
									<div class="field">
										<div class="ui radio checkbox">
											<input type="radio" name="ques_${que.id}" value="D" /> <label>D.
												${que.choiceD}</label>
										</div>
									</div>
								</div></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="actions">
				<div class="ui right floated green right labeled icon button"
					id="submitbutton">
					交卷<i class="upload icon"></i>
				</div>
				<div style="clear: both"></div>
			</div>
		</form>
	</div>
	<div class="ui mini modal transition hidden" id="submit">
		<div class="header">交卷</div>
		<div class="content">
			<p>确定交卷吗?</p>
		</div>
		<div class="actions">
			<div class="ui black deny button">返回</div>
			<div class="ui positive right labeled icon button">
				确定 <i class="checkmark icon"></i>
			</div>
		</div>
	</div>
	<script>
		var time = 0;
		function format(num, length) {
			return (Array(length).join('0') + num).slice(-length);
		}
		$('.ui.sticky').sticky({
			context : '#timer'
		});
		$('#time').countdown(
				'${time}',
				function(event) {
					$(this).text(event.strftime('%H:%M:%S'));
					time++;
					$('#examtime').val(
							format(Math.floor(time / 3600), 2) + ':'
									+ format(Math.floor(time % 3600 / 60), 2)
									+ ':' + format(time % 60, 2));
				}).on('finish.countdown', function() {
			$('#submitform').submit();
		});
		$('#submitbutton').click(function() {
			$('#submit').modal({
				blurring : true,
				autofocus : false,
				onApprove : function() {
					$('#submitform').submit();
				}
			}).modal('show');
		});
		document.onselectstart = function() {
			return false;
		};
		document.oncontextmenu = function() {
			return false;
		};
		document.onkeydown = function() {
			return false;
		};
	</script>
	<%@ include file="../footer.jsp"%>
</body>
</html>