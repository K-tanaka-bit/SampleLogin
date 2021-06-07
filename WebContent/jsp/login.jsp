<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<h3>ログイン</h3>
	<%
	String message = (String) request.getAttribute("message");
	String user_id = (String) session.getAttribute("user_id");
	if (message != null) {
	%>

	<%=(String) request.getAttribute("message")%>
	<%
	}
	%>
	
	<form action="../servlet/LoginServlet" method="post">
		ユーザID：<input type="text" size="10" name="user_id"
			value=
			<% if(user_id!=null){%>
			<%=session.getAttribute("user_id")%>
			<%}else{} %>><br> 
			パスワード： <input type="password" name="password"><br> 
			<input type="submit" value="ログイン">
	</form>
</body>
</html>