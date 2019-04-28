<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>歌单</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript" src="js/audio.js"></script>
</head>
<body>
	<!-- header-->
	<%@include file="header.jsp" %>

	<div id="wrap_show">
		<div id="top_content">
			<div id="content" >
				<p id="whereami"></p>
				<h1>智慧云</h1>
				<table class="table">
					<tr class="table_header">
						<td>标号</td>
						<td>歌名</td>
						<td>歌手</td>
						<td>操作</td>
						<td>下载</td>
					</tr>
					<c:forEach items="${m}" var="m">
					<tr class="row">
						<td>${m.id }</td>
						<td>${m.mname }</td>
						<td>${m.singer }</td>
						<td><a href="#"><audio src="${pageContext.request.contextPath}/upload/${m.url}" controls="controls" preload="auto" loop="loop"></audio></a></td>
						<td><a href="${pageContext.request.contextPath}/download?fname=${m.url}">下载</a></td>
						</tr>
					</c:forEach>
				</table>
				
			</div>
		</div>
		
	</div>
		<%@include file="footer.jsp" %>
	
</body>
</html>
 