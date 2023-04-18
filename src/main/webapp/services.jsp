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
		String redirect = request.getParameter("continue");
		if (redirect != null) {
			response.sendRedirect(redirect);
		}
%>		
<jsp:include page="nav.html" />
<br/><br/><br/>
 <h1>This is your service page</h1>
 
 
 <a href="/alimama/services/menu.jsp" >Menu</a>

	
 <a href="/alimama/dashboard.jsp">Dashboard</a>
<%}%>	
</body>
</html>