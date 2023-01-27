<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.alimama.users.User"
    import="com.alimama.users.Board"
    import="com.alimama.users.Customer"
    import="com.alimama.users.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign out</title>
</head>
<body>
<%
		session.invalidate();
		response.sendRedirect("/alimama/board/admin.jsp");
%>
</body>
</html>