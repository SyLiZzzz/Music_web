<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="css/style.css" type="text/css" rel="stylesheet">
	<script language="javascript" src="${pageContext.request.contextPath}/admin/js/public.js"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/admin/js/check.js"></script>
	<%
  String flowid = request.getParameter("a_id"); 
	
%>
</HEAD>
<body>
		<form action="${pageContext.request.contextPath}/EditAlbum" method="post">
		<input  name="a_id" value="<%=flowid%>" /> &nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4" height="45">
					<font size="3"><strong>编辑专辑</strong></font>
				</td>
			</tr>
			</br>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01"  height="45">
				<font size="2">专辑名称：</font>
				</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="a_name" class="bg" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01" height="45">
				<font size="2">专辑歌手：</font>
				</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="a_singer" class="bg" />
				</td>
			</tr>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4" height="45">
					<input type="submit" class="button_ok" value="确定"> 
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<input type="reset" value="重置" class="button_cancel" /> 
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> 
					<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>