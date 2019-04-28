<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
<head>
<title>专辑</title>
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
		<form action="${pageContext.request.contextPath}/AddAlbum" method="post" enctype="multipart/form-data">
		<table width="600" >
			<tr>
				<td>专辑名:</td>
				<td><input type="text" name="a_name"></td>
			</tr>
			<tr>
				<td>歌手:</td>
				<td><input type="text" name="a_singer"></td>
			</tr>
			<tr>
				<td>图片:</td>
				<td><input type="file" name="a_img"></td>
			</tr>
			<td><input type="submit" value="提交"></td>
			<td><input type="reset" value="取消"></td>
		</table>
	</form>
				
			</div>
		</div>
		
	</div>
		
	
</body>
</html>