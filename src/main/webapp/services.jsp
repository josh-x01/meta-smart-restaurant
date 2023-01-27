<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.alimama.users.User"
    import="com.alimama.data_util.CustomerDataUtil"
    import="com.alimama.users.Customer"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Service</title>
</head>
<body>
<%
	if (session.getAttribute("userSession") == null) {
		response.sendRedirect("/alimama/signin");
	} else {
		session.setAttribute("password", request.getAttribute("password"));
%>		

 <h1>This is your service page</h1>
 

 <a href="/alimama/dashboard.jsp">Dashboard</a>
<%}%>	
</body>
</html>