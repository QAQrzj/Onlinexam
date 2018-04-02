<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header_static.jsp"%>
<title>登录 - <%=siteTitle%></title>
<style type="text/css">
body {
	background-color: #DADADA;
}

.column {
	max-width: 450px;
}
</style>
</head>
<body>
	<div class="ui top fixed inverted menu">
		<a class="header active item" href=""> <i
			class="circular inverted trophy icon"></i>学生在线考试系统
		</a>
		<div class="right menu">
			<a class="item" href="login"> <i class="sign in icon"></i> 登录
			</a>
		</div>
	</div>
	<div class="ui middle aligned center aligned grid">
		<div class="column">
			<h1 class="ui blue image header">
				<img src="static/img/logo.png" class="image">
				<div class="content">学生在线考试系统</div>
			</h1>
			<form class="ui large form" method="post" action="login">
				<div class="ui stacked segment">
					<div class="field">
						<div class="ui left icon input">
							<i class="user icon"></i> <input type="text" name="username"
								placeholder="用户名" />
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input type="password" name="password"
								placeholder="密码" />
						</div>
					</div>
					<div class="field">
						<div class="ui fluid selection dropdown">
							<input type="hidden" name="role"> <i
								class="dropdown icon"></i>
							<div class="default text">
								<i class="users icon"></i>角色
							</div>
							<div class="menu">
								<div class="item" data-value="admin">
									<i class="spy icon"></i>管理员
								</div>
								<div class="item" data-value="teacher">
									<i class="user icon"></i>教师
								</div>
								<div class="item" data-value="student">
									<i class="student icon"></i>学生
								</div>
							</div>
						</div>
					</div>
					<div class="ui error message"></div>
					<button class="ui fluid large blue submit button">登录</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>