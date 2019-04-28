<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>登录页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="js/register.js"></script>
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
</head>

<body>

	<div id="wrap">
		<div id="top_content">
			<div id="logo_login">
				<a href="index.jsp"><h1>智慧云</h1></a>
			</div>
			<div id="content">
				<p id="whereami"></p>
		<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎登录</h1>
					<form action="${pageContext.request.contextPath}/login" method="post">
					<table cellpadding="0" cellspacing="0" border="0"
						class="form_table">
						<tr>
						<td valign="middle" align="right" width="250">用户名</td>
							<td valign="middle" align="left"><input type="text" class="inputgri" name="username" id="user" onblur="checkUser();"/>
							<span id="user_span"></span>
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">密码</td>
							<td valign="middle" align="left"><input type="password" class="inputgri" name="password" id="pass" onblur="checkPassword();"/>
							<span id="p"></span>
							</td>
						</tr>
						<tr>
						<td valign="middle" align="right"> </td>
						<td><font color="#ff0000" >
						${requestScope["login_msg"]}</font>
						</td>
						</tr>
						</table>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" class="button" value="确定" />&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;
						<input type="reset" class="button" value="取消" />
						<span style="color: red; font-size: 20px;">${login }</span>
					</p>
					<a href="forget.jsp"><h6 align="right">忘记密码</h6></a>
				</form>
			</div>
		</div>

	</div>
</body>
</html>