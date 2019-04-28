
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
				<li><a href="${pageContext.request.contextPath}/ListUser">用户管理</a></li>
				<li><a href="${pageContext.request.contextPath}/ListMusic">歌曲管理</a></li>
				<li><a href=" ">专辑管理</a></li>
			</ul>
		</div>
	</div>

</body>
</html>
