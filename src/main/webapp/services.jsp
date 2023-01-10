<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.meta_restaurant.users.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Service</title>
</head>
<body>
<%
	User user = (User) request.getAttribute("user");
	if (user != null) {
		session.setAttribute("userSession", user);
		session.setAttribute("password", request.getAttribute("password"));
		session.setMaxInactiveInterval(60*60*60*24);
	}

	if (session.getAttribute("userSession") == null) {
		request.getRequestDispatcher("/signin.jsp")
		.forward(request, response);
	}
%>	
 <h1>This is your service page</h1>
 
 <a href="/metarestaurant/signout.jsp">Sign out</a>
 <a href="/metarestaurant/dashboard.jsp">Dashboard</a>
 
</body>
</html>