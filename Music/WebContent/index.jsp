<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
		<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/header.js"></script>
	</head>
	<body>
	<!-- header-->
	<%@include file="header.jsp" %>
	
	<!-- page -->
	<div id="page">
		<img src="images/index-bj.jpg">
	</div>
	
	<!-- end page -->
	<%@include file="footer.jsp" %>
	<div id="end">
		<p id="copyright">©2018-12-29</p>
		
	</div>
</body>
</html>