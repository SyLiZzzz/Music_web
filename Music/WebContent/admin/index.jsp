
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>index</title>
<link href="css/body.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="header">
		<div id="logo">
			<h1>JavaMusic</h1>
		</div>
		<div id="menu">
			<ul>
				<li class="active"><a href="#">首页</a></li>
			</ul>
		</div>
	</div>
	<hr />
	<div id="page">
		<img src="images/img00.png" width="680" />
		<div id="sidebar">
			<div id="about-box" style="font-size: 12px">
				<div>
					<form action="${pageContext.request.contextPath}/Login " method="post">
						<label> &nbsp;&nbsp;用户名： </label> <br /> &nbsp;&nbsp; <input
							type="text" name="username" style="width: 170;" size="15"
							maxlength="16" value="" /><br /> </br> <label>
							&nbsp;&nbsp;密 码： </label> <br />&nbsp;&nbsp; <input type="password"
							name="password" style="width: 170;" size="15" maxlength="16" />
						<br /> <br /> &nbsp;&nbsp;&nbsp;&nbsp; </br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="登  录" />
						<!-- 登录错误信息 -->
						<td style="text-align: center; padding-top: 20px;"><font
							color="#ff0000">${requestScope["login_msg"]}</font></td>
					</form>
				</div>
			</div>
		</div>
	</div>
	<hr />
</body>
</html>
