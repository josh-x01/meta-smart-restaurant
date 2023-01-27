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
	if (session.getAttribute("userSession") != null) {
		if (session.getAttribute("userSession").getClass() == new Customer().getClass()) {
			session.invalidate();
			response.sendRedirect("/alimama/signin.jsp");
		}
		else if (session.getAttribute("userSession").getClass() == new Employee().getClass()) {
			session.invalidate();
			response.sendRedirect("/alimama/signin.jsp");
		}
	} else {
		response.sendRedirect("/alimama");
	}
%>
</body>
</html>