<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<div id="header">
	<div id="logo">
		<h1>MUSIC</h1>
	</div>
	<div id="search">
		<form action="${pageContext.request.contextPath }/findName">
			<input id="search-key" placeholder="请输入您要搜索的歌曲" name="str"> <input
				id="search-sub" type="submit" value="搜索">
		</form>
	</div>
	<div id="menu">
		<ul>
			<li><a href="index.jsp">首页</a></li>
			<li class="lick"><a href="register.jsp">注册</a></li>
			<c:choose>
				<c:when test="${empty sessionScope['user'] }">
					<li class="lick"><a href="login.jsp">登录</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath }/listMusic">歌单</a></li>
					<li><a href="upload.jsp">分享</a></li>
					<li><a href="${pageContext.request.contextPath }/FindByPage">专辑</a></li>
					<li><a href>欢迎你,${sessionScope["user"].username }</a></li>
					<li><a href="${pageContext.request.contextPath }/out">注销</a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>
	

</div>
<div id="menu_time">
		<span id="time"></span>
	</div>