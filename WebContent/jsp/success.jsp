<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功</title>
<link rel="styleSheet" href="style.css">
</head>
<body>
<%@ include file="logout.jsp"%>
<h3>ログイン成功</h3>
	
	<%
	List<String[]> nameList = (List<String[]>) session.getAttribute("nameList");
	%>
	<p>ようこそ、
	<%
	for (String[] name : nameList) {
		if(session.getAttribute("user_id").equals( name[0])){%>
	<strong><%=name[1]%></strong>
	<%
	}}
	%>さん！</p>


</body>
</html>