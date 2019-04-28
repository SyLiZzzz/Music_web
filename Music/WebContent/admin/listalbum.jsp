
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript">
	function addAlbum() {
		window.location.href = "${pageContext.request.contextPath}/Album.jsp";
	}
</script>
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
				<li><a href="${pageContext.request.contextPath}/ListAlbum">专辑管理</a></li>
			</ul>
		</div>
	</div>
	<hr />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" id="add" name="add" value="&#28155;&#21152;"
			onclick="addAlbum()" text-align="center"  style="background-color:transparent;border:0">&#28155;&#21152;</button>
	<div id="page">
		<div>
			<form action="${pageContext.request.contextPath}/ListAlbum"
				method="post">
				<table cellspacing="0" cellpadding="2" rules="0.5"
					bordercolor="gray" border="1" id="DataGrid1">
					<tr>
						<td align="center" width="10%">id</td>
						<td align="center" width="25%">专辑名称</td>
						<td align="center" width="25%">专辑歌手</td>
						<td align="center" width="20%">图片路径</td>
						<td width="10%" align="center">编辑</td>
						<td width="10%" align="center">删除</td>
					</tr>
					<!--  循环输出所有商品 -->
					<c:forEach items="${list }" var="p">
						<tr>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10">${p.a_id }</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="25%">${p.a_name }</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="25%">${p.a_singer }</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="20%">${p.a_img }</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">
								<a href="${pageContext.request.contextPath}/admin/editalbum.jsp?a_id=${p.a_id}">编辑</a>
							</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">
								<a href="${pageContext.request.contextPath}/DeleteAlbum?a_id=${p.a_id}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
	
	<hr />
</body>
</html>
