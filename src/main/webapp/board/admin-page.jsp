<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.alimama.users.Board"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body>
<%
	Board user = (Board) request.getAttribute("user");
	if (user != null) {
		session.setAttribute("userSession", user);
		session.setAttribute("password", request.getAttribute("password"));
		session.setMaxInactiveInterval(60*60*60*24);
	}

	if (session.getAttribute("userSession") == null) {
		response.sendRedirect("/alimama/board/admin.jsp");
	} else {
%>		

 <h1>This is your Admin page</h1>
 

 <a href="/alimama/dashboard.jsp">Dashboard</a>
<%}%>


</body>
</html>