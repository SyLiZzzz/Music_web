<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
<head>
<title>分享歌曲</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/header.js"></script>
</head>
<body>
	<!-- header-->
	<%@include file="header.jsp" %>

	<div id="wrap_show">
		<div id="top_content">
			<div id="content" >
				<p id="whereami"></p>
				<h1>智慧云</h1>
		<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
		<table width="600" >
			<tr>
				<td>歌名:</td>
				<td><input type="text" name="Mname"></td>
			</tr>
			<tr>
				<td>歌手:</td>
				<td><input type="text" name="singer"></td>
			</tr>
			<tr>
				<td>地址:</td>
				<td><input type="file" name="fname"></td>
			</tr>
			<input type="hidden" name="a_id" value="0">
			<td><input type="submit" value="提交"></td>
			<td><input type="reset" value="取消"></td>
		</table>
	</form>
				
			</div>
		</div>
		
	</div>
		
	
</body>
</html>